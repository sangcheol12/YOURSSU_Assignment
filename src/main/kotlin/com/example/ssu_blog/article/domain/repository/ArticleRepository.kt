package com.example.ssu_blog.article.domain.repository

import com.example.ssu_blog.article.domain.entity.Article
import com.example.ssu_blog.user.domain.entity.UserModel

interface ArticleRepository {
    fun save(articleParam: Article): Article
    fun findById(id: Long): Article?
    fun update(articleParam: Article): Article
    fun delete(deleteArticle: Article): Article
    fun deleteAllByUser(deleteUser: UserModel)
}