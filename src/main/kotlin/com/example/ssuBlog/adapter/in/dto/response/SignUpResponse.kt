package com.example.ssuBlog.adapter.`in`.dto.response

import com.example.ssuBlog.adapter.out.persistence.entity.UserEntity

data class SignUpResponse(
    val email: String,
    val username: String,
    val role: String
) {
    companion object {
        fun from(param: UserEntity): SignUpResponse {
            return SignUpResponse(
                email = param.email,
                username = param.username,
                role = param.role.value()
            )
        }
    }
}
