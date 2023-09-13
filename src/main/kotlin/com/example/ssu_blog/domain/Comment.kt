package com.example.ssu_blog.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "comment")
data class Comment (
    @Column(nullable = false)
    var content: String,

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    val articleId: Article,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val userId: UserModel
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val commentId: Long? = null

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()

    @Column(nullable = false)
    val updatedAt: LocalDateTime = LocalDateTime.now()
}