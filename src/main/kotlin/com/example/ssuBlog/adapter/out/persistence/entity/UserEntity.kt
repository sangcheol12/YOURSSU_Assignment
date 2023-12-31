package com.example.ssuBlog.adapter.out.persistence.entity

import com.example.ssuBlog.adapter.`in`.dto.request.SignUpRequest
import com.example.ssuBlog.utils.UserRoleEnum
import com.querydsl.core.annotations.QueryEntity
import org.springframework.security.crypto.password.PasswordEncoder
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@QueryEntity
@Table(name = "user")
class UserEntity(
    email: String,
    password: String,
    username: String,
    role: UserRoleEnum
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Long? = null

    @Column(nullable = false)
    var email: String = email

    @Column(nullable = false)
    val password: String = password

    @Column(nullable = false)
    val username: String = username

    @Column(nullable = true)
    var refreshToken: String? = null

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var role: UserRoleEnum = role

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()

    @Column(nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()

    companion object {
        fun from(request: SignUpRequest, encoder: PasswordEncoder): UserEntity {
            val userRole = when (request.role) {
                "USER" -> UserRoleEnum.USER
                "ADMIN" -> UserRoleEnum.ADMIN
                else -> throw IllegalArgumentException("유효하지 않은 role 입니다.")
            }
            return UserEntity(
                email = request.email,
                password = encoder.encode(request.password),
                username = request.username,
                role = userRole
            )
        }
    }
}
