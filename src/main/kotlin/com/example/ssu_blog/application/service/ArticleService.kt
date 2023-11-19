package com.example.ssu_blog.application.service

import com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity
import com.example.ssu_blog.adapter.out.persistence.entity.UserEntity
import com.example.ssu_blog.adapter.out.persistence.repository.ArticleRepository
import com.example.ssu_blog.adapter.out.persistence.repository.CommentRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class ArticleService (
    private val articleRepository: ArticleRepository,
    private val commentRepository: CommentRepository
) {
    fun post(newArticleEntity: ArticleEntity): ArticleEntity {
        return articleRepository.save(newArticleEntity)
    }

    fun delete(deleteArticleId: Long, accessUser: UserEntity) {
        val article = getAuthArticle(deleteArticleId, accessUser)
        commentRepository.deleteAllByArticleEntityId(article)
        articleRepository.delete(article)
    }

    fun getArticle(articleId: Long): ArticleEntity {
        return articleRepository.findById(articleId)
            ?: throw NoSuchElementException("게시글이 존재하지 않습니다.")
    }

    fun getAuthArticle(articleId: Long, accessUser: UserEntity): ArticleEntity {
        val article = getArticle(articleId)
        if(article.userEntityId != accessUser)
            throw IllegalAccessException("게시글을 수정 할 권한이 없습니다.")
        return article
    }
}