package com.example.ssu_blog.service

import com.example.ssu_blog.domain.UserModel
import com.example.ssu_blog.repository.JpaUserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class UserService(
    private val userRepository: JpaUserRepository,
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
}