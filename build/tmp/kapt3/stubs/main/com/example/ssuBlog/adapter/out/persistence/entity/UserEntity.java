package com.example.ssuBlog.adapter.out.persistence.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000e\u00a8\u0006$"}, d2 = {"Lcom/example/ssuBlog/adapter/out/persistence/entity/UserEntity;", "", "email", "", "password", "username", "role", "Lcom/example/ssuBlog/utils/UserRoleEnum;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/example/ssuBlog/utils/UserRoleEnum;)V", "createdAt", "Ljava/time/LocalDateTime;", "getCreatedAt", "()Ljava/time/LocalDateTime;", "getEmail", "()Ljava/lang/String;", "setEmail", "(Ljava/lang/String;)V", "getPassword", "refreshToken", "getRefreshToken", "setRefreshToken", "getRole", "()Lcom/example/ssuBlog/utils/UserRoleEnum;", "setRole", "(Lcom/example/ssuBlog/utils/UserRoleEnum;)V", "updatedAt", "getUpdatedAt", "setUpdatedAt", "(Ljava/time/LocalDateTime;)V", "userId", "", "getUserId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUsername", "Companion", "ssuBlog"})
@javax.persistence.Table(name = "user")
@com.querydsl.core.annotations.QueryEntity()
@javax.persistence.Entity()
public final class UserEntity {
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Id()
    private final java.lang.Long userId = null;
    @org.jetbrains.annotations.NotNull()
    @javax.persistence.Column(nullable = false)
    private java.lang.String email;
    @org.jetbrains.annotations.NotNull()
    @javax.persistence.Column(nullable = false)
    private final java.lang.String password = null;
    @org.jetbrains.annotations.NotNull()
    @javax.persistence.Column(nullable = false)
    private final java.lang.String username = null;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(nullable = true)
    private java.lang.String refreshToken;
    @org.jetbrains.annotations.NotNull()
    @javax.persistence.Enumerated(value = javax.persistence.EnumType.STRING)
    @javax.persistence.Column(nullable = false)
    private com.example.ssuBlog.utils.UserRoleEnum role;
    @org.jetbrains.annotations.NotNull()
    @javax.persistence.Column(nullable = false)
    private final java.time.LocalDateTime createdAt = null;
    @org.jetbrains.annotations.NotNull()
    @javax.persistence.Column(nullable = false)
    private java.time.LocalDateTime updatedAt;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.ssuBlog.adapter.out.persistence.entity.UserEntity.Companion Companion = null;
    
    public UserEntity(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    com.example.ssuBlog.utils.UserRoleEnum role) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getUserId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEmail() {
        return null;
    }
    
    public final void setEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPassword() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUsername() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRefreshToken() {
        return null;
    }
    
    public final void setRefreshToken(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.ssuBlog.utils.UserRoleEnum getRole() {
        return null;
    }
    
    public final void setRole(@org.jetbrains.annotations.NotNull()
    com.example.ssuBlog.utils.UserRoleEnum p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDateTime getCreatedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDateTime getUpdatedAt() {
        return null;
    }
    
    public final void setUpdatedAt(@org.jetbrains.annotations.NotNull()
    java.time.LocalDateTime p0) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/example/ssuBlog/adapter/out/persistence/entity/UserEntity$Companion;", "", "()V", "from", "Lcom/example/ssuBlog/adapter/out/persistence/entity/UserEntity;", "request", "Lcom/example/ssuBlog/adapter/in/dto/request/SignUpRequest;", "encoder", "Lorg/springframework/security/crypto/password/PasswordEncoder;", "ssuBlog"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.ssuBlog.adapter.out.persistence.entity.UserEntity from(@org.jetbrains.annotations.NotNull()
        com.example.ssuBlog.adapter.in.dto.request.SignUpRequest request, @org.jetbrains.annotations.NotNull()
        org.springframework.security.crypto.password.PasswordEncoder encoder) {
            return null;
        }
    }
}