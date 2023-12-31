package com.example.ssuBlog.application.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004JJ\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/ssuBlog/application/service/AdminUserInfoService;", "", "adminRepository", "Lcom/example/ssuBlog/adapter/out/persistence/repository/AdminRepository;", "(Lcom/example/ssuBlog/adapter/out/persistence/repository/AdminRepository;)V", "queryUserInfo", "", "Lcom/example/ssuBlog/adapter/out/persistence/entity/UserEntity;", "username", "", "email", "createdAtStart", "createdAtEnd", "updatedAtStart", "updatedAtEnd", "ssuBlog"})
@javax.transaction.Transactional()
@org.springframework.stereotype.Service()
public class AdminUserInfoService {
    private final com.example.ssuBlog.adapter.out.persistence.repository.AdminRepository adminRepository = null;
    
    public AdminUserInfoService(@org.jetbrains.annotations.NotNull()
    com.example.ssuBlog.adapter.out.persistence.repository.AdminRepository adminRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.example.ssuBlog.adapter.out.persistence.entity.UserEntity> queryUserInfo(@org.jetbrains.annotations.Nullable()
    java.lang.String username, @org.jetbrains.annotations.Nullable()
    java.lang.String email, @org.jetbrains.annotations.Nullable()
    java.lang.String createdAtStart, @org.jetbrains.annotations.Nullable()
    java.lang.String createdAtEnd, @org.jetbrains.annotations.Nullable()
    java.lang.String updatedAtStart, @org.jetbrains.annotations.Nullable()
    java.lang.String updatedAtEnd) {
        return null;
    }
}