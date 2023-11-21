package com.example.ssuBlog.auth;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/ssuBlog/auth/JwtAuthFilter;", "Lorg/springframework/web/filter/OncePerRequestFilter;", "jwtTokenProvider", "Lcom/example/ssuBlog/auth/JwtTokenProvider;", "(Lcom/example/ssuBlog/auth/JwtTokenProvider;)V", "doFilterInternal", "", "request", "Ljavax/servlet/http/HttpServletRequest;", "response", "Ljavax/servlet/http/HttpServletResponse;", "filterChain", "Ljavax/servlet/FilterChain;", "setAuthentication", "token", "", "ssuBlog"})
public final class JwtAuthFilter extends org.springframework.web.filter.OncePerRequestFilter {
    private final com.example.ssuBlog.auth.JwtTokenProvider jwtTokenProvider = null;
    
    public JwtAuthFilter(@org.jetbrains.annotations.NotNull()
    com.example.ssuBlog.auth.JwtTokenProvider jwtTokenProvider) {
        super();
    }
    
    @java.lang.Override()
    protected void doFilterInternal(@org.jetbrains.annotations.NotNull()
    javax.servlet.http.HttpServletRequest request, @org.jetbrains.annotations.NotNull()
    javax.servlet.http.HttpServletResponse response, @org.jetbrains.annotations.NotNull()
    javax.servlet.FilterChain filterChain) {
    }
    
    public final void setAuthentication(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    javax.servlet.http.HttpServletRequest request) {
    }
}