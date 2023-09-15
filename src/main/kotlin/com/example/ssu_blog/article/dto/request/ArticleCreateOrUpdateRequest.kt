package com.example.ssu_blog.article.dto.request

import javax.validation.constraints.NotBlank

class ArticleCreateOrUpdateRequest (
    val email: String,
    val password: String,
    @NotBlank
    val title: String,
    @NotBlank
    val content: String
)