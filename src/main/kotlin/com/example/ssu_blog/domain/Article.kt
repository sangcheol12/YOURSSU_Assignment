package com.example.ssu_blog.domain

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
@Table(name = "article")
data class Article (
    @Column(nullable = false)
    var content: String,

    @Column(nullable = false)
    var title: String,

    @ManyToOne
    @JoinColumn(name  = "user_id", nullable = false)
    val userId: UserModel
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val articleId: Long? = null

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()

    @Column(nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()
}