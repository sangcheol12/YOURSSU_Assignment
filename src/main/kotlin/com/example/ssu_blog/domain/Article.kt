package com.example.ssu_blog.domain

import com.example.ssu_blog.adapter.out.persistence.entity.UserEntity


public data class Article(
    val articleId: Long,
    var content: String,
    var title: String,
    val userEntityId: UserEntity,
)
