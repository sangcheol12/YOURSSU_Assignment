package com.example.ssu_blog.article.service

import com.example.ssu_blog.article.domain.entity.Article
import com.example.ssu_blog.article.domain.repository.JpaArticleRepository
import com.example.ssu_blog.comment.domain.repository.JpaCommentRepository
import com.example.ssu_blog.user.domain.entity.UserModel
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class ArticleService (
    private val articleRepository: JpaArticleRepository,
    private val commentRepository: JpaCommentRepository
) {
    fun post(newArticle: Article): Article {
        return articleRepository.save(newArticle)
    }

    fun update(updateArticle: Article): Article {
        return articleRepository.update(updateArticle)
    }

    fun delete(deleteArticleId: Long, accessUser: UserModel) {
        val article = getAuthArticle(deleteArticleId, accessUser)
        articleRepository.delete(article)
        commentRepository.deleteAllByArticle(article)
    }

    fun getArticle(articleId: Long): Article {
        val article = articleRepository.findById(articleId)
            ?: throw NoSuchElementException("게시글이 존재하지 않습니다.")
        return article
    }

    fun getAuthArticle(articleId: Long, accessUser: UserModel): Article {
        val article = getArticle(articleId)
        if(article.userId != accessUser)
            throw IllegalAccessException("게사글을 수정 할 권한이 없습니다.")
        return article
    }
}