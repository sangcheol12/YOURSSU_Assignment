package com.example.ssuBlog.adapter.`in`.dto.response

import com.example.ssuBlog.adapter.out.persistence.entity.UserEntity

data class SignInResponse(
    val email: String,
    val username: String,
    val role: String,
    val accessToken: String,
    val refreshToken: String?
) {
    companion object {
        fun from(param: UserEntity, curAccessToken: String): SignInResponse {
            return SignInResponse(
                email = param.email,
                username = param.username,
                role = param.role.value(),
                accessToken = "Bearer " + curAccessToken,
                refreshToken = "Bearer " + param.refreshToken
            )
        }
    }
}
