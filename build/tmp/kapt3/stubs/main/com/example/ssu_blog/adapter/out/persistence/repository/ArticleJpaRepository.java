package com.example.ssu_blog.adapter.out.persistence.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H&\u00a8\u0006\f"}, d2 = {"Lcom/example/ssu_blog/adapter/out/persistence/repository/ArticleJpaRepository;", "Lorg/springframework/data/jpa/repository/JpaRepository;", "Lcom/example/ssu_blog/adapter/out/persistence/entity/ArticleEntity;", "", "deleteAllByUserEntityId", "", "userEntity", "Lcom/example/ssu_blog/adapter/out/persistence/entity/UserEntity;", "findAllByUserEntityId", "", "findByArticleId", "id", "ssu_blog"})
public abstract interface ArticleJpaRepository extends org.springframework.data.jpa.repository.JpaRepository<com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity, java.lang.Long> {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity findByArticleId(long id);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity> findAllByUserEntityId(@org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.entity.UserEntity userEntity);
    
    public abstract void deleteAllByUserEntityId(@org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.entity.UserEntity userEntity);
}