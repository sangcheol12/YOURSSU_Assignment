package com.example.ssu_blog.adapter.out.persistence.repository

import com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity
import com.example.ssu_blog.adapter.out.persistence.entity.CommentEntity
import com.example.ssu_blog.adapter.out.persistence.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

interface CommentJpaRepository: JpaRepository<CommentEntity, Long> {
    fun deleteAllByArticleEntityId(articleEntity: ArticleEntity)
    fun deleteAllByUserEntityId(userEntity: UserEntity)
}

interface CommentRepository {
    fun save(commentEntity: CommentEntity): CommentEntity
    fun delete(commentEntity: CommentEntity)
    fun findById(id: Long): CommentEntity?
    fun deleteAllByArticleEntityId(articleEntity: ArticleEntity)
    fun deleteAllByUserEntityId(userEntity: UserEntity)
}

@Repository
class CommentRepositoryImpl(
    private val commentJpaRepository: CommentJpaRepository
): CommentRepository {
    override fun save(commentEntity: CommentEntity): CommentEntity {
        return commentJpaRepository.save(commentEntity)
    }

    override fun delete(commentEntity: CommentEntity) {
        commentJpaRepository.delete(commentEntity)
    }

    override fun findById(id: Long): CommentEntity? {
        return commentJpaRepository.findByIdOrNull(id)
    }

    override fun deleteAllByArticleEntityId(articleEntity: ArticleEntity) {
        deleteAllByArticleEntityId(articleEntity)
    }

    override fun deleteAllByUserEntityId(userEntity: UserEntity) {
        deleteAllByUserEntityId(userEntity)
    }
}