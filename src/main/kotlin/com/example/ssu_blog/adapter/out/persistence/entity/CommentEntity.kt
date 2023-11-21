package com.example.ssu_blog.adapter.out.persistence.entity

import com.querydsl.core.annotations.QueryEntity
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@QueryEntity
@Table(name = "comment")
class CommentEntity (
    content: String,
    articleEntityId: ArticleEntity,
    userId: UserEntity
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val commentId: Long? = null

    @Column(nullable = false)
    var content: String = content

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    val articleEntityId: ArticleEntity = articleEntityId

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val userEntityId: UserEntity = userId

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()

    @Column(nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()

    fun updateInfo(content: String, updatedAt: LocalDateTime) {
        this.content = content; this.updatedAt = updatedAt
    }
}