package com.example.ssu_blog.article.dto.response

import com.example.ssu_blog.article.domain.entity.Article

class ArticleCreateOrUpdateResponse (
    val articleId: Long?,
    val email: String,
    val title: String,
    val content: String
) {
    companion object {
        fun from(param: Article, accessUserEmail: String): ArticleCreateOrUpdateResponse {
            return ArticleCreateOrUpdateResponse(
                articleId = param.articleId,
                email = accessUserEmail,
                title = param.title,
                content = param.content
            )
        }
    }
}