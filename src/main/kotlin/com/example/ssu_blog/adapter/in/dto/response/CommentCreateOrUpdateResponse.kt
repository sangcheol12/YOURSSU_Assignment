package com.example.ssu_blog.adapter.`in`.dto.response

import com.example.ssu_blog.adapter.out.persistence.entity.CommentEntity

class CommentCreateOrUpdateResponse (
    val commentId: Long?,
    val email: String,
    val content: String
) {
    companion object {
        fun from(param: CommentEntity, accessUserEmail: String): CommentCreateOrUpdateResponse {
            return CommentCreateOrUpdateResponse(
                commentId = param.commentId,
                email = accessUserEmail,
                content = param.content
            )
        }
    }
}