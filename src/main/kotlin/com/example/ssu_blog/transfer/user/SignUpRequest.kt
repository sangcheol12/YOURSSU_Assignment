package com.example.ssu_blog.transfer.user

data class SignUpRequest (
    val email: String,
    val password: String,
    val username: String
)