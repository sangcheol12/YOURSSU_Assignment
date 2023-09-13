package com.example.ssu_blog.transfer.user

import com.example.ssu_blog.domain.UserModel

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