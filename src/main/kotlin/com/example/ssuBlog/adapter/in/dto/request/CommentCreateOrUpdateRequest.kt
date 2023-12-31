package com.example.ssuBlog.adapter.`in`.dto.request

import javax.validation.constraints.NotBlank

data class CommentCreateOrUpdateRequest(
    @field:NotBlank(message = "댓글의 내용은 비어 있을 수 없습니다.")
    val content: String
)
