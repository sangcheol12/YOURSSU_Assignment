package com.example.ssu_blog.adapter.out.persistence.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/example/ssu_blog/adapter/out/persistence/repository/CommentRepositoryImpl;", "Lcom/example/ssu_blog/adapter/out/persistence/repository/CommentRepository;", "commentJpaRepository", "Lcom/example/ssu_blog/adapter/out/persistence/repository/CommentJpaRepository;", "(Lcom/example/ssu_blog/adapter/out/persistence/repository/CommentJpaRepository;)V", "delete", "", "commentEntity", "Lcom/example/ssu_blog/adapter/out/persistence/entity/CommentEntity;", "deleteAllByArticleEntityId", "articleEntity", "Lcom/example/ssu_blog/adapter/out/persistence/entity/ArticleEntity;", "deleteAllByUserEntityId", "userEntity", "Lcom/example/ssu_blog/adapter/out/persistence/entity/UserEntity;", "findById", "id", "", "save", "ssu_blog"})
@org.springframework.stereotype.Repository()
public class CommentRepositoryImpl implements com.example.ssu_blog.adapter.out.persistence.repository.CommentRepository {
    private final com.example.ssu_blog.adapter.out.persistence.repository.CommentJpaRepository commentJpaRepository = null;
    
    public CommentRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.repository.CommentJpaRepository commentJpaRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.ssu_blog.adapter.out.persistence.entity.CommentEntity save(@org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.entity.CommentEntity commentEntity) {
        return null;
    }
    
    @java.lang.Override()
    public void delete(@org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.entity.CommentEntity commentEntity) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public com.example.ssu_blog.adapter.out.persistence.entity.CommentEntity findById(long id) {
        return null;
    }
    
    @java.lang.Override()
    public void deleteAllByArticleEntityId(@org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity articleEntity) {
    }
    
    @java.lang.Override()
    public void deleteAllByUserEntityId(@org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.entity.UserEntity userEntity) {
    }
}