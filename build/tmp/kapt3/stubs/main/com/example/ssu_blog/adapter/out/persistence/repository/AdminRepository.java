package com.example.ssu_blog.adapter.out.persistence.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JJ\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\r"}, d2 = {"Lcom/example/ssu_blog/adapter/out/persistence/repository/AdminRepository;", "", "findAllUser", "", "Lcom/example/ssu_blog/adapter/out/persistence/entity/UserEntity;", "username", "", "email", "createdAtStart", "Ljava/time/LocalDateTime;", "createdAtEnd", "updatedAtStart", "updatedAtEnd", "ssu_blog"})
public abstract interface AdminRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.ssu_blog.adapter.out.persistence.entity.UserEntity> findAllUser(@org.jetbrains.annotations.Nullable()
    java.lang.String username, @org.jetbrains.annotations.Nullable()
    java.lang.String email, @org.jetbrains.annotations.Nullable()
    java.time.LocalDateTime createdAtStart, @org.jetbrains.annotations.Nullable()
    java.time.LocalDateTime createdAtEnd, @org.jetbrains.annotations.Nullable()
    java.time.LocalDateTime updatedAtStart, @org.jetbrains.annotations.Nullable()
    java.time.LocalDateTime updatedAtEnd);
}