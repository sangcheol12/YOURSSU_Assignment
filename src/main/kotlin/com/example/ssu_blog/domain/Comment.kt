package com.example.ssu_blog.domain

public data class Comment(
    val commentId: Long,
    val content: Long,
    val articleId: Article,
    val userId: User,
)
