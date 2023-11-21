package com.example.ssuBlog.utils

enum class UserRoleEnum(val role: String) {
    USER("USER"),
    ADMIN("ADMIN");

    fun value(): String {
        return role
    }
}
