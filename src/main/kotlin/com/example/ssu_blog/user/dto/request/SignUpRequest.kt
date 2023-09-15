package com.example.ssu_blog.user.dto.request

data class SignUpRequest (
    val email: String,
    val password: String,
    val username: String
)