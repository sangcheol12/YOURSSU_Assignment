package com.example.ssuBlog.application.service

import com.example.ssuBlog.adapter.`in`.dto.response.TokenRefreshResponse
import com.example.ssuBlog.adapter.out.persistence.entity.UserEntity
import com.example.ssuBlog.adapter.out.persistence.repository.ArticleRepository
import com.example.ssuBlog.adapter.out.persistence.repository.CommentRepository
import com.example.ssuBlog.adapter.out.persistence.repository.UserRepository
import com.example.ssuBlog.auth.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import java.time.LocalDateTime
import javax.servlet.http.HttpServletRequest
import javax.transaction.Transactional

@Service
@Transactional
class UserService(
    private val userRepository: UserRepository,
    private val articleRepository: ArticleRepository,
    private val commentRepository: CommentRepository,
    private val jwtTokenProvider: JwtTokenProvider,
    private val encoder: PasswordEncoder
) {
    fun join(user: UserEntity): UserEntity {
        validateDuplicateUser(user.email)
        return userRepository.save(user)
    }
    fun validateDuplicateUser(email: String) {
        userRepository.findByEmail(email)?.let {
            throw IllegalStateException("이미 존재하는 회원입니다.")
        }
    }

    fun findOneByEmail(email: String): UserEntity {
        val curUser = userRepository.findByEmail(email)
            ?: throw NoSuchElementException("존재하지 않는 유저입니다")
        return curUser
    }

    fun matchAccount(email: String, password: String): UserEntity {
        val accessUser = userRepository.findByEmail(email)
            ?.takeIf { encoder.matches(password, it.password) }	// 암호화된 비밀번호와 비교하도록 수정
            ?: throw IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다.")
        val refreshToken = jwtTokenProvider.createRefreshToken(accessUser.email, accessUser.role.value())
        accessUser.updatedAt = LocalDateTime.now()
        accessUser.refreshToken = refreshToken
        return accessUser
    }

    fun refreshToken(request: HttpServletRequest): TokenRefreshResponse {
        val refreshToken = jwtTokenProvider.getRefreshToken(request)
        if (refreshToken == null || !jwtTokenProvider.validateRefreshToken(refreshToken)) {
            throw IllegalAccessException(
                "리프레쉬 토큰이 존재하지 않거나 유효하지 않습니다."
            )
        }
        val userEmail = jwtTokenProvider.getUserEmailByRefresh(refreshToken)
        val curUser = findOneByEmail(userEmail)
        // 데이터베이스에 저장 된 리프레쉬 토큰과 일치 여부 검사
        if (curUser.refreshToken != refreshToken) throw IllegalAccessException("리프레쉬 토큰이 일치하지 않습니다.")
        val userRole = jwtTokenProvider.getRoleByRefresh(refreshToken)
        val result = TokenRefreshResponse(
            jwtTokenProvider.createAccessToken(userEmail, userRole),
            jwtTokenProvider.createRefreshToken(userEmail, userRole)
        )
        curUser.refreshToken = result.refreshToken; curUser.updatedAt = LocalDateTime.now()
        userRepository.save(curUser)
        return result
    }

    fun leave(leaveUser: UserEntity) {
        val articles = articleRepository.findAllByUserEntityId(leaveUser)
        articles.forEach { article ->
            commentRepository.deleteAllByArticleEntityId(article)
        }
        commentRepository.deleteAllByUserEntityId(leaveUser)
        articleRepository.deleteAllByUserEntityId(leaveUser)
        userRepository.delete(leaveUser)
    }
}
