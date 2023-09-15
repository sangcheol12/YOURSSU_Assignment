package com.example.ssu_blog.comment.dto.request

import javax.validation.constraints.NotBlank

class CommentCreateOrUpdateRequest (
    val email: String,
    val password: String,
    @NotBlank
    val content: String
)