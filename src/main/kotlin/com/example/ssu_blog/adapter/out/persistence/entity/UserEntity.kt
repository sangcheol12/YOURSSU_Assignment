package com.example.ssu_blog.adapter.out.persistence.entity

import com.example.ssu_blog.adapter.`in`.dto.request.SignUpRequest
import org.springframework.security.crypto.password.PasswordEncoder
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user")
class UserEntity (
    email: String,
    password: String,
    username: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Long? = null

    @Column(nullable = false)
    var email: String = email

    @Column(nullable = false)
    var password: String = password

    @Column(nullable = false)
    var username: String = username

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()

    @Column(nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()

    companion object {
        fun from(request: SignUpRequest, encoder: PasswordEncoder): UserEntity {
            return UserEntity(
                email = request.email,
                password = encoder.encode(request.password),
                username = request.username
            )
        }
    }
}