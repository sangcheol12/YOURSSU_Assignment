package com.example.ssu_blog.adapter.out.persistence.repository

import com.example.ssu_blog.adapter.out.persistence.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

interface UserJpaRepository: JpaRepository<UserEntity, Long> {
    fun findByEmail(email: String): UserEntity?
}

interface UserRepository {
    fun save(userEntity: UserEntity): UserEntity
    fun delete(userEntity: UserEntity)
    fun findByEmail(email: String): UserEntity?
}

@Repository
class UserRepositoryImpl(
    private val userJpaRepository: UserJpaRepository
): UserRepository {
    override fun save(userEntity: UserEntity): UserEntity {
        return userJpaRepository.save(userEntity)
    }

    override fun delete(userEntity: UserEntity) {
        userJpaRepository.delete(userEntity)
    }

    override fun findByEmail(email: String): UserEntity? {
        return userJpaRepository.findByEmail(email)
    }
}