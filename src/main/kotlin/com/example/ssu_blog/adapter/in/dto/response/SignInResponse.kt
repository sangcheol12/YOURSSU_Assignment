package com.example.ssu_blog.adapter.`in`.dto.response

import com.example.ssu_blog.adapter.out.persistence.entity.UserEntity

data class SignInResponse (
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
                username = param.nickname,
                role = param.role.value(),
                accessToken = "Bearer " + curAccessToken,
                refreshToken = "Bearer " + param.refreshToken
            )
        }
    }
}