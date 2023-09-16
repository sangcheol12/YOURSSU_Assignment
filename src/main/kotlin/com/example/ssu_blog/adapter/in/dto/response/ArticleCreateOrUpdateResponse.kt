package com.example.ssu_blog.adapter.`in`.dto.response

import com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity

class ArticleCreateOrUpdateResponse (
    val articleId: Long?,
    val email: String,
    val title: String,
    val content: String
) {
    companion object {
        fun from(param: ArticleEntity, accessUserEmail: String): ArticleCreateOrUpdateResponse {
            return ArticleCreateOrUpdateResponse(
                articleId = param.articleId,
                email = accessUserEmail,
                title = param.title,
                content = param.content
            )
        }
    }
}