package com.example.ssuBlog.Exception;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\u0010\u0006\u001a\u00060\tj\u0002`\n2\u0006\u0010\u000b\u001a\u00020\fH\u0012J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u000eH\u0017J\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\u0010\u0006\u001a\u00060\u0010j\u0002`\u0011H\u0017J\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\u0010\u0006\u001a\u00060\u0013j\u0002`\u0014H\u0017J\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\u0010\u0006\u001a\u00060\u0016j\u0002`\u0017H\u0017J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0019H\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/example/ssuBlog/Exception/GlobalExceptionHandler;", "", "()V", "handleCustomBadRequsetException", "Lorg/springframework/http/ResponseEntity;", "Lcom/example/ssuBlog/Exception/ExceptionResponse;", "ex", "Lcom/example/ssuBlog/Exception/CustomBadRequestException;", "handleException", "Ljava/lang/Exception;", "Lkotlin/Exception;", "status", "Lorg/springframework/http/HttpStatus;", "handleIllegalAccessException", "Ljava/lang/IllegalAccessException;", "handleIllegalArgumentException", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "handleIllegalStateException", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "handleNoSuchElementException", "Ljava/util/NoSuchElementException;", "Lkotlin/NoSuchElementException;", "handleValidationException", "Lorg/springframework/web/bind/MethodArgumentNotValidException;", "ssuBlog"})
@org.springframework.web.bind.annotation.ControllerAdvice()
public class GlobalExceptionHandler {
    
    public GlobalExceptionHandler() {
        super();
    }
    
    private org.springframework.http.ResponseEntity<com.example.ssuBlog.Exception.ExceptionResponse> handleException(java.lang.Exception ex, org.springframework.http.HttpStatus status) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {org.springframework.web.bind.MethodArgumentNotValidException.class})
    public org.springframework.http.ResponseEntity<com.example.ssuBlog.Exception.ExceptionResponse> handleValidationException(@org.jetbrains.annotations.NotNull()
    org.springframework.web.bind.MethodArgumentNotValidException ex) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {java.lang.IllegalArgumentException.class})
    public org.springframework.http.ResponseEntity<com.example.ssuBlog.Exception.ExceptionResponse> handleIllegalArgumentException(@org.jetbrains.annotations.NotNull()
    java.lang.IllegalArgumentException ex) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {java.lang.IllegalAccessException.class})
    public org.springframework.http.ResponseEntity<com.example.ssuBlog.Exception.ExceptionResponse> handleIllegalAccessException(@org.jetbrains.annotations.NotNull()
    java.lang.IllegalAccessException ex) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {java.util.NoSuchElementException.class})
    public org.springframework.http.ResponseEntity<com.example.ssuBlog.Exception.ExceptionResponse> handleNoSuchElementException(@org.jetbrains.annotations.NotNull()
    java.util.NoSuchElementException ex) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {java.lang.IllegalStateException.class})
    public org.springframework.http.ResponseEntity<com.example.ssuBlog.Exception.ExceptionResponse> handleIllegalStateException(@org.jetbrains.annotations.NotNull()
    java.lang.IllegalStateException ex) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {com.example.ssuBlog.Exception.CustomBadRequestException.class})
    public org.springframework.http.ResponseEntity<com.example.ssuBlog.Exception.ExceptionResponse> handleCustomBadRequsetException(@org.jetbrains.annotations.NotNull()
    com.example.ssuBlog.Exception.CustomBadRequestException ex) {
        return null;
    }
}