package com.example.ssu_blog.user.service

import com.example.ssu_blog.article.domain.repository.JpaArticleRepository
import com.example.ssu_blog.comment.domain.repository.JpaCommentRepository
import com.example.ssu_blog.user.domain.entity.UserModel
import com.example.ssu_blog.user.domain.repository.JpaUserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import javax.transaction.Transactional

@Service
@Transactional
class UserService(
    private val userRepository: JpaUserRepository,
    private val articleRepository: JpaArticleRepository,
    private val commentRepository: JpaCommentRepository,
    private val encoder: PasswordEncoder
) {
    fun join(user: UserModel): UserModel {
        validateDuplicateUser(user.email)
        return userRepository.save(user)
    }
    fun validateDuplicateUser(email: String) {
        userRepository.findByEmail(email)?.let {
            throw IllegalStateException("이미 존재하는 회원입니다.")
        }
    }
    fun matchAccount(email: String, password: String): UserModel {
        val accessUser = userRepository.findByEmail(email)
            ?.takeIf { encoder.matches(password, it.password) }	// 암호화된 비밀번호와 비교하도록 수정
            ?: throw IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다.")
        return accessUser
    }

    fun leave(leaveUser: UserModel) {
        userRepository.delete(leaveUser)
        articleRepository.deleteAllByUser(leaveUser)
        commentRepository.deleteAllByUser(leaveUser)
    }
}