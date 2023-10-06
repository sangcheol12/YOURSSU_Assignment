package com.example.ssu_blog.adapter.out.persistence.repository

import com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity
import com.example.ssu_blog.adapter.out.persistence.entity.CommentEntity
import com.example.ssu_blog.adapter.out.persistence.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository: JpaRepository<CommentEntity, Long> {
    fun deleteAllByArticleEntityId(articleEntity: ArticleEntity)
    fun deleteAllByUserEntityId(userEntity: UserEntity)

}