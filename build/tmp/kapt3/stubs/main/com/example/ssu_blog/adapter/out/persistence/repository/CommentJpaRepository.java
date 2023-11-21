package com.example.ssu_blog.adapter.out.persistence.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/example/ssu_blog/adapter/out/persistence/repository/CommentJpaRepository;", "Lorg/springframework/data/jpa/repository/JpaRepository;", "Lcom/example/ssu_blog/adapter/out/persistence/entity/CommentEntity;", "", "deleteAllByArticleEntityId", "", "articleEntity", "Lcom/example/ssu_blog/adapter/out/persistence/entity/ArticleEntity;", "deleteAllByUserEntityId", "userEntity", "Lcom/example/ssu_blog/adapter/out/persistence/entity/UserEntity;", "ssu_blog"})
public abstract interface CommentJpaRepository extends org.springframework.data.jpa.repository.JpaRepository<com.example.ssu_blog.adapter.out.persistence.entity.CommentEntity, java.lang.Long> {
    
    public abstract void deleteAllByArticleEntityId(@org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity articleEntity);
    
    public abstract void deleteAllByUserEntityId(@org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.entity.UserEntity userEntity);
}