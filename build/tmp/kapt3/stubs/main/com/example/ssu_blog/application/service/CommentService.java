package com.example.ssu_blog.application.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/example/ssu_blog/application/service/CommentService;", "", "commentRepository", "Lcom/example/ssu_blog/adapter/out/persistence/repository/CommentRepository;", "(Lcom/example/ssu_blog/adapter/out/persistence/repository/CommentRepository;)V", "delete", "", "deleteCommentId", "", "accessUser", "Lcom/example/ssu_blog/adapter/out/persistence/entity/UserEntity;", "curAricle", "Lcom/example/ssu_blog/adapter/out/persistence/entity/ArticleEntity;", "getAuthComment", "Lcom/example/ssu_blog/adapter/out/persistence/entity/CommentEntity;", "commentId", "curArticleEntity", "getComment", "post", "newCommentEntity", "update", "updateCommentEntity", "ssu_blog"})
@javax.transaction.Transactional()
@org.springframework.stereotype.Service()
public class CommentService {
    private final com.example.ssu_blog.adapter.out.persistence.repository.CommentRepository commentRepository = null;
    
    public CommentService(@org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.repository.CommentRepository commentRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.example.ssu_blog.adapter.out.persistence.entity.CommentEntity post(@org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.entity.CommentEntity newCommentEntity) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.example.ssu_blog.adapter.out.persistence.entity.CommentEntity update(@org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.entity.CommentEntity updateCommentEntity) {
        return null;
    }
    
    public void delete(long deleteCommentId, @org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.entity.UserEntity accessUser, @org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity curAricle) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.example.ssu_blog.adapter.out.persistence.entity.CommentEntity getComment(long commentId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.example.ssu_blog.adapter.out.persistence.entity.CommentEntity getAuthComment(long commentId, @org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.entity.UserEntity accessUser, @org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity curArticleEntity) {
        return null;
    }
}