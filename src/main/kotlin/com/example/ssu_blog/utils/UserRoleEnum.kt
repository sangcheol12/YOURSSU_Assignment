package com.example.ssu_blog.utils

enum class UserRoleEnum(val role: String) {
    USER("USER"),
    ADMIN("ADMIN");

    fun value(): String {
        return role
    }
}