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
    nickname: String,
    role: UserRoleEnum
): UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Long? = null

    @Column(nullable = false)
    var email: String = email

    @Column(nullable = false, name = "password")
    val pwd: String = pwd

    @Column(nullable = false, name = "username")
    val nickname: String = nickname

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
                nickname = request.username,
                role = userRole
            )
        }
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val authorities = mutableListOf<GrantedAuthority>()

        // 사용자의 권한에 따라 권한을 추가
        when (this.role.value()) {
            "ADMIN" -> authorities.add(SimpleGrantedAuthority("ADMIN"))
            else -> authorities.add(SimpleGrantedAuthority("USER"))
        }
        return authorities
    }

    override fun getPassword(): String {
        return this.pwd
    }

    override fun getUsername(): String {
        return this.email
    }

    override fun isAccountNonExpired(): Boolean {
        return false
    }

    override fun isAccountNonLocked(): Boolean {
        return false
    }

    override fun isCredentialsNonExpired(): Boolean {
        return false
    }

    override fun isEnabled(): Boolean {
        return false
    }
}