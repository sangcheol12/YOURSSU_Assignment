package com.example.ssu_blog.user.dto.response

import com.example.ssu_blog.user.domain.entity.UserModel

data class SignUpResponse (
    val email: String,
    val username: String
) {
    companion object {
        fun from(param: UserModel): SignUpResponse {
            return SignUpResponse(
                email = param.email,
                username = param.username
            )
        }
    }
}