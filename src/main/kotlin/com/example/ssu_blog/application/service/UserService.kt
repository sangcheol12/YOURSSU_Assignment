package com.example.ssu_blog.application.service

import com.example.ssu_blog.adapter.out.persistence.entity.UserEntity
import com.example.ssu_blog.adapter.out.persistence.repository.*
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import javax.transaction.Transactional

@Service
@Transactional
class UserService(
    private val userRepository: UserRepository,
    private val articleRepository: ArticleRepository,
    private val commentRepository: CommentRepository,
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
    fun matchAccount(email: String, password: String): UserEntity {
        val accessUser = userRepository.findByEmail(email)
            ?.takeIf { encoder.matches(password, it.password) }	// 암호화된 비밀번호와 비교하도록 수정
            ?: throw IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다.")
        return accessUser
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