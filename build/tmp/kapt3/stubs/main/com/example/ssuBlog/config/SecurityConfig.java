package com.example.ssuBlog.config;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0017J\b\u0010\u000f\u001a\u00020\u0010H\u0017J\b\u0010\u0011\u001a\u00020\u0012H\u0017R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0092\u0004\u00a2\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/example/ssuBlog/config/SecurityConfig;", "", "jwtTokenProvider", "Lcom/example/ssuBlog/auth/JwtTokenProvider;", "exceptionHandlerFilter", "Lcom/example/ssuBlog/auth/ExceptionHandlerFilter;", "(Lcom/example/ssuBlog/auth/JwtTokenProvider;Lcom/example/ssuBlog/auth/ExceptionHandlerFilter;)V", "allowedUrls", "", "", "[Ljava/lang/String;", "filterChain", "Lorg/springframework/security/web/SecurityFilterChain;", "http", "Lorg/springframework/security/config/annotation/web/builders/HttpSecurity;", "passwordEncoder", "Lorg/springframework/security/crypto/bcrypt/BCryptPasswordEncoder;", "webSecurityCustomizer", "Lorg/springframework/security/config/annotation/web/configuration/WebSecurityCustomizer;", "ssuBlog"})
@org.springframework.security.config.annotation.web.configuration.EnableWebSecurity()
@org.springframework.context.annotation.Configuration()
public class SecurityConfig {
    private final com.example.ssuBlog.auth.JwtTokenProvider jwtTokenProvider = null;
    private final com.example.ssuBlog.auth.ExceptionHandlerFilter exceptionHandlerFilter = null;
    private final java.lang.String[] allowedUrls = {"/", "/v2/api-docs", "/swagger-resources/**", "/swagger-ui.html", "/swagger-ui/**", "/v3/**", "/api/user/signup", "/api/user/signin", "/api/user/refresh", "/api/user/test"};
    
    public SecurityConfig(@org.jetbrains.annotations.NotNull()
    com.example.ssuBlog.auth.JwtTokenProvider jwtTokenProvider, @org.jetbrains.annotations.NotNull()
    com.example.ssuBlog.auth.ExceptionHandlerFilter exceptionHandlerFilter) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.context.annotation.Bean()
    public org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder passwordEncoder() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.context.annotation.Bean()
    public org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer webSecurityCustomizer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.context.annotation.Bean()
    public org.springframework.security.web.SecurityFilterChain filterChain(@org.jetbrains.annotations.NotNull()
    org.springframework.security.config.annotation.web.builders.HttpSecurity http) {
        return null;
    }
}