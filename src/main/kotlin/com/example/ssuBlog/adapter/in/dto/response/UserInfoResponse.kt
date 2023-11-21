package com.example.ssuBlog.adapter.`in`.dto.response

import com.example.ssuBlog.adapter.out.persistence.entity.UserEntity

data class UserInfoResponse(
    val id: Long,
    val email: String? = null,
    val username: String? = null,
    val role: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null
) {
    companion object {
        fun from(userEntity: UserEntity): UserInfoResponse {
            return UserInfoResponse(
                id = userEntity.userId!!,
                email = userEntity.email.orEmpty(),
                username = userEntity.username.orEmpty(),
                role = userEntity.role.value().orEmpty(),
                createdAt = userEntity.createdAt?.toString().orEmpty(),
                updatedAt = userEntity.updatedAt?.toString().orEmpty()
            )
        }
    }
}
