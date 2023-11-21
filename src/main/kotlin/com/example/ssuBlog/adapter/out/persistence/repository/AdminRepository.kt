package com.example.ssuBlog.adapter.out.persistence.repository

import com.example.ssuBlog.adapter.out.persistence.entity.QUserEntity
import com.example.ssuBlog.adapter.out.persistence.entity.UserEntity
import com.example.ssuBlog.utils.UserRoleEnum
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

interface AdminRepository {
    fun findAllUser(
        username: String?,
        email: String?,
        createdAtStart: LocalDateTime?,
        createdAtEnd: LocalDateTime?,
        updatedAtStart: LocalDateTime?,
        updatedAtEnd: LocalDateTime?
    ): List<UserEntity>
}

@Repository
class AdminRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : AdminRepository {
    override fun findAllUser(
        username: String?,
        email: String?,
        createdAtStart: LocalDateTime?,
        createdAtEnd: LocalDateTime?,
        updatedAtStart: LocalDateTime?,
        updatedAtEnd: LocalDateTime?
    ): List<UserEntity> {
        val user = QUserEntity.userEntity
        val query = jpaQueryFactory.selectFrom(user)
            .where(user.role.eq(UserRoleEnum.USER))

        username?.let { query.where(user.username.eq(it)) }
        email?.let { query.where(user.email.eq(it)) }

        createdAtStart?.let { query.where(user.createdAt.goe(it)) }
        createdAtEnd?.let { query.where(user.createdAt.loe(it)) }

        updatedAtStart?.let { query.where(user.updatedAt.goe(it)) }
        updatedAtEnd?.let { query.where(user.updatedAt.loe(it)) }

        return query
            .orderBy(user.userId.desc())
            .fetch()
    }
}
