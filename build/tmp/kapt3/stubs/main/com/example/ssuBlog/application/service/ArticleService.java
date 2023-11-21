package com.example.ssuBlog.application.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/example/ssuBlog/application/service/ArticleService;", "", "articleRepository", "Lcom/example/ssuBlog/adapter/out/persistence/repository/ArticleRepository;", "commentRepository", "Lcom/example/ssuBlog/adapter/out/persistence/repository/CommentRepository;", "(Lcom/example/ssuBlog/adapter/out/persistence/repository/ArticleRepository;Lcom/example/ssuBlog/adapter/out/persistence/repository/CommentRepository;)V", "delete", "", "deleteArticleId", "", "accessUser", "Lcom/example/ssuBlog/adapter/out/persistence/entity/UserEntity;", "getArticle", "Lcom/example/ssuBlog/adapter/out/persistence/entity/ArticleEntity;", "articleId", "getAuthArticle", "post", "newArticleEntity", "ssuBlog"})
@javax.transaction.Transactional()
@org.springframework.stereotype.Service()
public class ArticleService {
    private final com.example.ssuBlog.adapter.out.persistence.repository.ArticleRepository articleRepository = null;
    private final com.example.ssuBlog.adapter.out.persistence.repository.CommentRepository commentRepository = null;
    
    public ArticleService(@org.jetbrains.annotations.NotNull()
    com.example.ssuBlog.adapter.out.persistence.repository.ArticleRepository articleRepository, @org.jetbrains.annotations.NotNull()
    com.example.ssuBlog.adapter.out.persistence.repository.CommentRepository commentRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.example.ssuBlog.adapter.out.persistence.entity.ArticleEntity post(@org.jetbrains.annotations.NotNull()
    com.example.ssuBlog.adapter.out.persistence.entity.ArticleEntity newArticleEntity) {
        return null;
    }
    
    public void delete(long deleteArticleId, @org.jetbrains.annotations.NotNull()
    com.example.ssuBlog.adapter.out.persistence.entity.UserEntity accessUser) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.example.ssuBlog.adapter.out.persistence.entity.ArticleEntity getArticle(long articleId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.example.ssuBlog.adapter.out.persistence.entity.ArticleEntity getAuthArticle(long articleId, @org.jetbrains.annotations.NotNull()
    com.example.ssuBlog.adapter.out.persistence.entity.UserEntity accessUser) {
        return null;
    }
}