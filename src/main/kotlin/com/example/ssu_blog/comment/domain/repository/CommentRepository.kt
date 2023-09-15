package com.example.ssu_blog.comment.domain.repository

import com.example.ssu_blog.article.domain.entity.Article
import com.example.ssu_blog.comment.domain.entity.Comment
import com.example.ssu_blog.user.domain.entity.UserModel
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository {
    fun save(commentParam: Comment): Comment
    fun findById(id: Long): Comment?
    fun update(commentParam: Comment): Comment
    fun delete(deleteComment: Comment)
    fun deleteAllByArticle(deleteArticle: Article)
    fun deleteAllByUser(deleteUser: UserModel)
}