package com.example.ssuBlog.adapter.`in`.dto.response

import com.example.ssuBlog.adapter.out.persistence.entity.CommentEntity

data class CommentCreateOrUpdateResponse(
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
