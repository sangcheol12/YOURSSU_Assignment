package com.example.ssu_blog.adapter.`in`.dto.request

import javax.validation.constraints.NotBlank


data class ArticleCreateOrUpdateRequest (
    @field:NotBlank(message = "게시글의 제목은 비어 있을 수 없습니다.")
    val title: String,
    @field:NotBlank(message = "게시글의 내용은 비어 있을 수 없습니다.")
    val content: String
)