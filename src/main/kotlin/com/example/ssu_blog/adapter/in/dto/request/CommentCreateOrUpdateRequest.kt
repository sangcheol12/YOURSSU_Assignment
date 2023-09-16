package com.example.ssu_blog.adapter.`in`.dto.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

class CommentCreateOrUpdateRequest (
    @field:NotBlank(message = "이메일은 비어 있을 수 없습니다.")
    val email: String,
    @field:NotBlank(message = "비밀번호는 비어 있을 수 없습니다.")
    val password: String,
    @field:NotBlank(message = "댓글의 내용은 비어 있을 수 없습니다.")
    val content: String
)