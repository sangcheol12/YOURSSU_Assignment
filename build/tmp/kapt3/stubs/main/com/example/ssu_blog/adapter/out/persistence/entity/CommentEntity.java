package com.example.ssu_blog.adapter.out.persistence.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0015R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0017\"\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006!"}, d2 = {"Lcom/example/ssu_blog/adapter/out/persistence/entity/CommentEntity;", "", "content", "", "articleEntityId", "Lcom/example/ssu_blog/adapter/out/persistence/entity/ArticleEntity;", "userId", "Lcom/example/ssu_blog/adapter/out/persistence/entity/UserEntity;", "(Ljava/lang/String;Lcom/example/ssu_blog/adapter/out/persistence/entity/ArticleEntity;Lcom/example/ssu_blog/adapter/out/persistence/entity/UserEntity;)V", "getArticleEntityId", "()Lcom/example/ssu_blog/adapter/out/persistence/entity/ArticleEntity;", "commentId", "", "getCommentId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "createdAt", "Ljava/time/LocalDateTime;", "getCreatedAt", "()Ljava/time/LocalDateTime;", "updatedAt", "getUpdatedAt", "setUpdatedAt", "(Ljava/time/LocalDateTime;)V", "userEntityId", "getUserEntityId", "()Lcom/example/ssu_blog/adapter/out/persistence/entity/UserEntity;", "updateInfo", "", "ssu_blog"})
@javax.persistence.Table(name = "comment")
@com.querydsl.core.annotations.QueryEntity()
@javax.persistence.Entity()
public final class CommentEntity {
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Id()
    private final java.lang.Long commentId = null;
    @org.jetbrains.annotations.NotNull()
    @javax.persistence.Column(nullable = false)
    private java.lang.String content;
    @org.jetbrains.annotations.NotNull()
    @javax.persistence.JoinColumn(name = "article_id", nullable = false)
    @javax.persistence.ManyToOne()
    private final com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity articleEntityId = null;
    @org.jetbrains.annotations.NotNull()
    @javax.persistence.JoinColumn(name = "user_id", nullable = false)
    @javax.persistence.ManyToOne()
    private final com.example.ssu_blog.adapter.out.persistence.entity.UserEntity userEntityId = null;
    @org.jetbrains.annotations.NotNull()
    @javax.persistence.Column(nullable = false)
    private final java.time.LocalDateTime createdAt = null;
    @org.jetbrains.annotations.NotNull()
    @javax.persistence.Column(nullable = false)
    private java.time.LocalDateTime updatedAt;
    
    public CommentEntity(@org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity articleEntityId, @org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.entity.UserEntity userId) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getCommentId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContent() {
        return null;
    }
    
    public final void setContent(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity getArticleEntityId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.ssu_blog.adapter.out.persistence.entity.UserEntity getUserEntityId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDateTime getCreatedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDateTime getUpdatedAt() {
        return null;
    }
    
    public final void setUpdatedAt(@org.jetbrains.annotations.NotNull()
    java.time.LocalDateTime p0) {
    }
    
    public final void updateInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    java.time.LocalDateTime updatedAt) {
    }
}