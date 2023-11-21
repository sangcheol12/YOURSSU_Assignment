package com.example.ssu_blog.adapter.out.persistence.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004JJ\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/ssu_blog/adapter/out/persistence/repository/AdminRepositoryImpl;", "Lcom/example/ssu_blog/adapter/out/persistence/repository/AdminRepository;", "jpaQueryFactory", "Lcom/querydsl/jpa/impl/JPAQueryFactory;", "(Lcom/querydsl/jpa/impl/JPAQueryFactory;)V", "findAllUser", "", "Lcom/example/ssu_blog/adapter/out/persistence/entity/UserEntity;", "username", "", "email", "createdAtStart", "Ljava/time/LocalDateTime;", "createdAtEnd", "updatedAtStart", "updatedAtEnd", "ssu_blog"})
@org.springframework.stereotype.Repository()
public class AdminRepositoryImpl implements com.example.ssu_blog.adapter.out.persistence.repository.AdminRepository {
    private final com.querydsl.jpa.impl.JPAQueryFactory jpaQueryFactory = null;
    
    public AdminRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.querydsl.jpa.impl.JPAQueryFactory jpaQueryFactory) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<com.example.ssu_blog.adapter.out.persistence.entity.UserEntity> findAllUser(@org.jetbrains.annotations.Nullable()
    java.lang.String username, @org.jetbrains.annotations.Nullable()
    java.lang.String email, @org.jetbrains.annotations.Nullable()
    java.time.LocalDateTime createdAtStart, @org.jetbrains.annotations.Nullable()
    java.time.LocalDateTime createdAtEnd, @org.jetbrains.annotations.Nullable()
    java.time.LocalDateTime updatedAtStart, @org.jetbrains.annotations.Nullable()
    java.time.LocalDateTime updatedAtEnd) {
        return null;
    }
}