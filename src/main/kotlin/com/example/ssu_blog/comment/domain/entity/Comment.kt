package com.example.ssu_blog.comment.domain.entity

import com.example.ssu_blog.article.domain.entity.Article
import com.example.ssu_blog.user.domain.entity.UserModel
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "comment")
class Comment (
    content: String,
    articleId: Article,
    userId: UserModel
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val commentId: Long? = null

    @Column(nullable = false)
    var content: String = content

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    val articleId: Article = articleId

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val userId: UserModel = userId

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()

    @Column(nullable = false)
    val updatedAt: LocalDateTime = LocalDateTime.now()
}