package com.example.ssu_blog.application.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/example/ssu_blog/application/service/UserService;", "", "userRepository", "Lcom/example/ssu_blog/adapter/out/persistence/repository/UserRepository;", "articleRepository", "Lcom/example/ssu_blog/adapter/out/persistence/repository/ArticleRepository;", "commentRepository", "Lcom/example/ssu_blog/adapter/out/persistence/repository/CommentRepository;", "jwtTokenProvider", "Lcom/example/ssu_blog/auth/JwtTokenProvider;", "encoder", "Lorg/springframework/security/crypto/password/PasswordEncoder;", "(Lcom/example/ssu_blog/adapter/out/persistence/repository/UserRepository;Lcom/example/ssu_blog/adapter/out/persistence/repository/ArticleRepository;Lcom/example/ssu_blog/adapter/out/persistence/repository/CommentRepository;Lcom/example/ssu_blog/auth/JwtTokenProvider;Lorg/springframework/security/crypto/password/PasswordEncoder;)V", "findOneByEmail", "Lcom/example/ssu_blog/adapter/out/persistence/entity/UserEntity;", "email", "", "join", "user", "leave", "", "leaveUser", "matchAccount", "password", "refreshToken", "Lcom/example/ssu_blog/adapter/in/dto/response/TokenRefreshResponse;", "request", "Ljavax/servlet/http/HttpServletRequest;", "validateDuplicateUser", "ssu_blog"})
@javax.transaction.Transactional()
@org.springframework.stereotype.Service()
public class UserService {
    private final com.example.ssu_blog.adapter.out.persistence.repository.UserRepository userRepository = null;
    private final com.example.ssu_blog.adapter.out.persistence.repository.ArticleRepository articleRepository = null;
    private final com.example.ssu_blog.adapter.out.persistence.repository.CommentRepository commentRepository = null;
    private final com.example.ssu_blog.auth.JwtTokenProvider jwtTokenProvider = null;
    private final org.springframework.security.crypto.password.PasswordEncoder encoder = null;
    
    public UserService(@org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.repository.UserRepository userRepository, @org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.repository.ArticleRepository articleRepository, @org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.repository.CommentRepository commentRepository, @org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.auth.JwtTokenProvider jwtTokenProvider, @org.jetbrains.annotations.NotNull()
    org.springframework.security.crypto.password.PasswordEncoder encoder) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.example.ssu_blog.adapter.out.persistence.entity.UserEntity join(@org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.entity.UserEntity user) {
        return null;
    }
    
    public void validateDuplicateUser(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.example.ssu_blog.adapter.out.persistence.entity.UserEntity findOneByEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.example.ssu_blog.adapter.out.persistence.entity.UserEntity matchAccount(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.example.ssu_blog.adapter.in.dto.response.TokenRefreshResponse refreshToken(@org.jetbrains.annotations.NotNull()
    javax.servlet.http.HttpServletRequest request) {
        return null;
    }
    
    public void leave(@org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.entity.UserEntity leaveUser) {
    }
}