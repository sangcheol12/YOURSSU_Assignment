package com.example.ssu_blog.comment.dto.response

import com.example.ssu_blog.comment.domain.entity.Comment

class CommentCreateOrUpdateResponse (
    val commentId: Long?,
    val email: String,
    val content: String
) {
    companion object {
        fun from(param: Comment, accessUserEmail: String): CommentCreateOrUpdateResponse {
            return CommentCreateOrUpdateResponse(
                commentId = param.commentId,
                email = accessUserEmail,
                content = param.content
            )
        }
    }
}