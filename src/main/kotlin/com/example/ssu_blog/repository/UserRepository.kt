package com.example.ssu_blog.repository

import com.example.ssu_blog.domain.UserModel

interface UserRepository {
    fun save(userParam: UserModel): UserModel
    fun findById(id: Long): UserModel?
    fun findByEmail(email: String) : UserModel?
    fun update(userParam: UserModel): UserModel
    fun delete(id: Long): UserModel
}