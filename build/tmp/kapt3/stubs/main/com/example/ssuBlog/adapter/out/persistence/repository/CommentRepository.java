package com.example.ssuBlog.adapter.out.persistence.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0010"}, d2 = {"Lcom/example/ssuBlog/adapter/out/persistence/repository/CommentRepository;", "", "delete", "", "commentEntity", "Lcom/example/ssuBlog/adapter/out/persistence/entity/CommentEntity;", "deleteAllByArticleEntityId", "articleEntity", "Lcom/example/ssuBlog/adapter/out/persistence/entity/ArticleEntity;", "deleteAllByUserEntityId", "userEntity", "Lcom/example/ssuBlog/adapter/out/persistence/entity/UserEntity;", "findById", "id", "", "save", "ssuBlog"})
public abstract interface CommentRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.ssuBlog.adapter.out.persistence.entity.CommentEntity save(@org.jetbrains.annotations.NotNull()
    com.example.ssuBlog.adapter.out.persistence.entity.CommentEntity commentEntity);
    
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.example.ssuBlog.adapter.out.persistence.entity.CommentEntity commentEntity);
    
    @org.jetbrains.annotations.Nullable()
    public abstract com.example.ssuBlog.adapter.out.persistence.entity.CommentEntity findById(long id);
    
    public abstract void deleteAllByArticleEntityId(@org.jetbrains.annotations.NotNull()
    com.example.ssuBlog.adapter.out.persistence.entity.ArticleEntity articleEntity);
    
    public abstract void deleteAllByUserEntityId(@org.jetbrains.annotations.NotNull()
    com.example.ssuBlog.adapter.out.persistence.entity.UserEntity userEntity);
}