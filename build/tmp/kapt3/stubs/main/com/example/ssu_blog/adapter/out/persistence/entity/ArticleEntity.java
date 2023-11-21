package com.example.ssu_blog.adapter.out.persistence.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0012R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001e\u0010\u0017\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/example/ssu_blog/adapter/out/persistence/entity/ArticleEntity;", "", "content", "", "title", "userId", "Lcom/example/ssu_blog/adapter/out/persistence/entity/UserEntity;", "(Ljava/lang/String;Ljava/lang/String;Lcom/example/ssu_blog/adapter/out/persistence/entity/UserEntity;)V", "articleId", "", "getArticleId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "createdAt", "Ljava/time/LocalDateTime;", "getCreatedAt", "()Ljava/time/LocalDateTime;", "getTitle", "setTitle", "updatedAt", "getUpdatedAt", "setUpdatedAt", "(Ljava/time/LocalDateTime;)V", "userEntityId", "getUserEntityId", "()Lcom/example/ssu_blog/adapter/out/persistence/entity/UserEntity;", "updateInfo", "", "ssu_blog"})
@javax.persistence.Table(name = "article")
@com.querydsl.core.annotations.QueryEntity()
@javax.persistence.Entity()
public final class ArticleEntity {
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Id()
    private final java.lang.Long articleId = null;
    @org.jetbrains.annotations.NotNull()
    @javax.persistence.Column(nullable = false)
    private java.lang.String content;
    @org.jetbrains.annotations.NotNull()
    @javax.persistence.Column(nullable = false)
    private java.lang.String title;
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
    
    public ArticleEntity(@org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.entity.UserEntity userId) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getArticleId() {
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
    public final java.lang.String getTitle() {
        return null;
    }
    
    public final void setTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
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
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    java.time.LocalDateTime updatedAt) {
    }
}