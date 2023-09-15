package com.example.ssu_blog.user.domain.repository

import com.example.ssu_blog.user.domain.entity.UserModel

interface UserRepository {
    fun save(userParam: UserModel): UserModel
    fun findById(id: Long): UserModel?
    fun findByEmail(email: String) : UserModel?
    fun update(userParam: UserModel): UserModel
    fun delete(deleteUser: UserModel)
}