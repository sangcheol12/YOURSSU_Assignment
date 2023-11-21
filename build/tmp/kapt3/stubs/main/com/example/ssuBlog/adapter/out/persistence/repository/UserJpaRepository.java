package com.example.ssuBlog.adapter.out.persistence.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/ssuBlog/adapter/out/persistence/repository/UserJpaRepository;", "Lorg/springframework/data/jpa/repository/JpaRepository;", "Lcom/example/ssuBlog/adapter/out/persistence/entity/UserEntity;", "", "findByEmail", "email", "", "ssuBlog"})
public abstract interface UserJpaRepository extends org.springframework.data.jpa.repository.JpaRepository<com.example.ssuBlog.adapter.out.persistence.entity.UserEntity, java.lang.Long> {
    
    @org.jetbrains.annotations.Nullable()
    public abstract com.example.ssuBlog.adapter.out.persistence.entity.UserEntity findByEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String email);
}