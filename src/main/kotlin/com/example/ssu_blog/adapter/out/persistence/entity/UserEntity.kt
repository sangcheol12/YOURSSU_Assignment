package com.example.ssu_blog.adapter.out.persistence.entity

import com.example.ssu_blog.adapter.`in`.dto.request.SignUpRequest
import com.example.ssu_blog.utils.UserRoleEnum
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "user")
class UserEntity(
    email: String,
    pwd: String,
    username: String,
    role: UserRoleEnum
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Long? = null

    @Column(nullable = false)
    var email: String = email

    @Column(nullable = false)
    val password: String = pwd

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
                pwd = encoder.encode(request.password),
                username = request.username,
                role = userRole
            )
        }
    }
}