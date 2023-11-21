package com.example.ssuBlog.Exception;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/example/ssuBlog/Exception/BadRequestCode;", "", "status", "Lorg/springframework/http/HttpStatus;", "message", "", "(Ljava/lang/String;ILorg/springframework/http/HttpStatus;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getStatus", "()Lorg/springframework/http/HttpStatus;", "EXPIRED_TOKEN", "INVALID_TOKEN", "EMPTY_TOKEN", "ssuBlog"})
public enum BadRequestCode {
    /*public static final*/ EXPIRED_TOKEN /* = new EXPIRED_TOKEN(null, null) */,
    /*public static final*/ INVALID_TOKEN /* = new INVALID_TOKEN(null, null) */,
    /*public static final*/ EMPTY_TOKEN /* = new EMPTY_TOKEN(null, null) */;
    @org.jetbrains.annotations.NotNull()
    private final org.springframework.http.HttpStatus status = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String message = null;
    
    BadRequestCode(org.springframework.http.HttpStatus status, java.lang.String message) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.springframework.http.HttpStatus getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMessage() {
        return null;
    }
}