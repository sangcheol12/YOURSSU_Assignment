package com.example.ssu_blog.adapter.`in`.dto.response

import com.example.ssu_blog.adapter.out.persistence.entity.UserEntity

data class SignUpResponse (
    val email: String,
    val username: String
) {
    companion object {
        fun from(param: UserEntity): SignUpResponse {
            return SignUpResponse(
                email = param.email,
                username = param.username
            )
        }
    }
}