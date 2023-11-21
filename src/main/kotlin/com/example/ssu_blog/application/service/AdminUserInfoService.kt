package com.example.ssu_blog.application.service

import com.example.ssu_blog.adapter.out.persistence.entity.UserEntity
import com.example.ssu_blog.adapter.out.persistence.repository.AdminRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import javax.transaction.Transactional

@Service
@Transactional
class AdminUserInfoService (
    private val adminRepository: AdminRepository
) {
    fun queryUserInfo (
        username: String?,
        email: String?,
        createdAtStart: String?,
        createdAtEnd: String?,
        updatedAtStart: String?,
        updatedAtEnd:
        String?): List<UserEntity> {
        val createdAtStartDateTime = createdAtStart?.let { LocalDateTime.parse(it + "T00:00:00") }
        val createdAtEndDateTime = createdAtEnd?.let { LocalDateTime.parse(it + "T23:59:59") }
        val updatedAtStartDateTime = updatedAtStart?.let { LocalDateTime.parse(it + "T00:00:00") }
        val updatedAtEndDateTime = updatedAtEnd?.let { LocalDateTime.parse(it + "T23:59:59") }

        return adminRepository.findAllUser(username, email, createdAtStartDateTime, createdAtEndDateTime, updatedAtStartDateTime, updatedAtEndDateTime)
    }
}