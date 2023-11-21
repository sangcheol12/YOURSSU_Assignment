package com.example.ssuBlog.adapter.out.persistence.repository

import com.example.ssuBlog.adapter.out.persistence.entity.ArticleEntity
import com.example.ssuBlog.adapter.out.persistence.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

interface ArticleJpaRepository : JpaRepository<ArticleEntity, Long> {
    fun findByArticleId(id: Long): ArticleEntity
    fun findAllByUserEntityId(userEntity: UserEntity): List<ArticleEntity>
    fun deleteAllByUserEntityId(userEntity: UserEntity)
}

interface ArticleRepository {
    fun save(articleEntity: ArticleEntity): ArticleEntity
    fun delete(articleEntity: ArticleEntity)
    fun findById(id: Long): ArticleEntity?
    fun findByArticleId(id: Long): ArticleEntity
    fun findAllByUserEntityId(userEntity: UserEntity): List<ArticleEntity>
    fun deleteAllByUserEntityId(userEntity: UserEntity)
}

@Repository
class ArticleRepositoryImpl(
    private val articleJpaRepository: ArticleJpaRepository
) : ArticleRepository {
    override fun save(articleEntity: ArticleEntity): ArticleEntity {
        return articleJpaRepository.save(articleEntity)
    }

    override fun delete(articleEntity: ArticleEntity) {
        articleJpaRepository.delete(articleEntity)
    }

    override fun findById(id: Long): ArticleEntity? {
        return articleJpaRepository.findByIdOrNull(id)
    }

    override fun findByArticleId(id: Long): ArticleEntity {
        return articleJpaRepository.findByArticleId(id)
    }

    override fun findAllByUserEntityId(userEntity: UserEntity): List<ArticleEntity> {
        return articleJpaRepository.findAllByUserEntityId(userEntity)
    }

    override fun deleteAllByUserEntityId(userEntity: UserEntity) {
        articleJpaRepository.deleteAllByUserEntityId(userEntity)
    }
}
