package com.example.ssuBlog.adapter.out.persistence.entity

import com.querydsl.core.annotations.QueryEntity
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@QueryEntity
@Table(name = "article")
class ArticleEntity(
    content: String,
    title: String,
    userId: UserEntity
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val articleId: Long? = null

    @Column(nullable = false)
    var content: String = content

    @Column(nullable = false)
    var title: String = title

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val userEntityId: UserEntity = userId

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()

    @Column(nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()

    fun updateInfo(title: String, content: String, updatedAt: LocalDateTime) {
        this.title = title; this.content = content; this.updatedAt = updatedAt
    }
}
