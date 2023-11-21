package com.example.ssu_blog.adapter.out.persistence.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0010"}, d2 = {"Lcom/example/ssu_blog/adapter/out/persistence/repository/ArticleRepository;", "", "delete", "", "articleEntity", "Lcom/example/ssu_blog/adapter/out/persistence/entity/ArticleEntity;", "deleteAllByUserEntityId", "userEntity", "Lcom/example/ssu_blog/adapter/out/persistence/entity/UserEntity;", "findAllByUserEntityId", "", "findByArticleId", "id", "", "findById", "save", "ssu_blog"})
public abstract interface ArticleRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity save(@org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity articleEntity);
    
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity articleEntity);
    
    @org.jetbrains.annotations.Nullable()
    public abstract com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity findById(long id);
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity findByArticleId(long id);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity> findAllByUserEntityId(@org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.entity.UserEntity userEntity);
    
    public abstract void deleteAllByUserEntityId(@org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.entity.UserEntity userEntity);
}