package com.example.ssu_blog.auth;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u0001B?\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J(\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u001c\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001e\u0018\u00010\u001d2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003H\u0016J\u0018\u0010\'\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010(\u001a\u00020\u0003H\u0016J\u0010\u0010)\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010*\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0018\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/example/ssu_blog/auth/JwtTokenProvider;", "", "accessTokenKey", "", "refreshTokenKey", "accessTokenExpirationHours", "", "refreshTokenExpirationHours", "issuer", "userRepository", "Lcom/example/ssu_blog/adapter/out/persistence/repository/UserRepository;", "(Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Lcom/example/ssu_blog/adapter/out/persistence/repository/UserRepository;)V", "compareRefreshToken", "", "token", "createAccessToken", "email", "role", "createRefreshToken", "createToken", "tokenKey", "expirationHours", "getAccessToken", "request", "Ljavax/servlet/http/HttpServletRequest;", "getAuthentication", "Lorg/springframework/security/core/userdetails/User;", "getRefreshToken", "getRole", "", "Lorg/springframework/security/core/GrantedAuthority;", "getRoleByRefresh", "getUserEmail", "getUserEmailByRefresh", "setHeaderAccessToken", "", "response", "Ljavax/servlet/http/HttpServletResponse;", "accessToken", "setHeaderRefreshToken", "refreshToken", "validateAccessToken", "validateRefreshToken", "validateToken", "jwtToken", "secretKey", "ssu_blog"})
@org.springframework.stereotype.Component()
public class JwtTokenProvider {
    private final java.lang.String accessTokenKey = null;
    private final java.lang.String refreshTokenKey = null;
    private final long accessTokenExpirationHours = 0L;
    private final long refreshTokenExpirationHours = 0L;
    private final java.lang.String issuer = null;
    private final com.example.ssu_blog.adapter.out.persistence.repository.UserRepository userRepository = null;
    
    public JwtTokenProvider(@org.jetbrains.annotations.NotNull()
    @org.springframework.beans.factory.annotation.Value(value = "${accessTokenKey}")
    java.lang.String accessTokenKey, @org.jetbrains.annotations.NotNull()
    @org.springframework.beans.factory.annotation.Value(value = "${refreshTokenKey}")
    java.lang.String refreshTokenKey, @org.springframework.beans.factory.annotation.Value(value = "${accessTokenExpirationHours}")
    long accessTokenExpirationHours, @org.springframework.beans.factory.annotation.Value(value = "${refreshTokenExpirationHours}")
    long refreshTokenExpirationHours, @org.jetbrains.annotations.NotNull()
    @org.springframework.beans.factory.annotation.Value(value = "${issuer}")
    java.lang.String issuer, @org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.adapter.out.persistence.repository.UserRepository userRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String createAccessToken(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String role) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String createRefreshToken(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String role) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String createToken(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String role, @org.jetbrains.annotations.NotNull()
    java.lang.String tokenKey, long expirationHours) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getAccessToken(@org.jetbrains.annotations.NotNull()
    javax.servlet.http.HttpServletRequest request) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getRefreshToken(@org.jetbrains.annotations.NotNull()
    javax.servlet.http.HttpServletRequest request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public org.springframework.security.core.userdetails.User getAuthentication(@org.jetbrains.annotations.NotNull()
    java.lang.String token) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getUserEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String token) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getUserEmailByRefresh(@org.jetbrains.annotations.NotNull()
    java.lang.String token) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.util.Collection<? extends org.springframework.security.core.GrantedAuthority> getRole(@org.jetbrains.annotations.NotNull()
    java.lang.String token) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getRoleByRefresh(@org.jetbrains.annotations.NotNull()
    java.lang.String token) {
        return null;
    }
    
    public boolean validateAccessToken(@org.jetbrains.annotations.NotNull()
    java.lang.String token) {
        return false;
    }
    
    public boolean validateRefreshToken(@org.jetbrains.annotations.NotNull()
    java.lang.String token) {
        return false;
    }
    
    public boolean validateToken(@org.jetbrains.annotations.NotNull()
    java.lang.String jwtToken, @org.jetbrains.annotations.NotNull()
    java.lang.String secretKey) {
        return false;
    }
    
    public void setHeaderAccessToken(@org.jetbrains.annotations.NotNull()
    javax.servlet.http.HttpServletResponse response, @org.jetbrains.annotations.NotNull()
    java.lang.String accessToken) {
    }
    
    public void setHeaderRefreshToken(@org.jetbrains.annotations.NotNull()
    javax.servlet.http.HttpServletResponse response, @org.jetbrains.annotations.NotNull()
    java.lang.String refreshToken) {
    }
    
    public boolean compareRefreshToken(@org.jetbrains.annotations.NotNull()
    java.lang.String token) {
        return false;
    }
}