package com.example.ssu_blog.comment.dto.request

import javax.validation.constraints.NotBlank

class CommentCreateOrUpdateRequest (
    val email: String,
    val password: String,
    @field:NotBlank(message = "댓글의 내용은 비어 있을 수 없습니다.")
    val content: String
)