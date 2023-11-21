package com.example.ssu_blog.resolver;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J.\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/ssu_blog/resolver/CustomHandlerMethodArgumentResolver;", "Lorg/springframework/web/method/support/HandlerMethodArgumentResolver;", "jwtTokenProvider", "Lcom/example/ssu_blog/auth/JwtTokenProvider;", "(Lcom/example/ssu_blog/auth/JwtTokenProvider;)V", "resolveArgument", "", "parameter", "Lorg/springframework/core/MethodParameter;", "mavContainer", "Lorg/springframework/web/method/support/ModelAndViewContainer;", "webRequest", "Lorg/springframework/web/context/request/NativeWebRequest;", "binderFactory", "Lorg/springframework/web/bind/support/WebDataBinderFactory;", "supportsParameter", "", "ssu_blog"})
@org.springframework.stereotype.Component()
public class CustomHandlerMethodArgumentResolver implements org.springframework.web.method.support.HandlerMethodArgumentResolver {
    private final com.example.ssu_blog.auth.JwtTokenProvider jwtTokenProvider = null;
    
    public CustomHandlerMethodArgumentResolver(@org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.auth.JwtTokenProvider jwtTokenProvider) {
        super();
    }
    
    @java.lang.Override()
    public boolean supportsParameter(@org.jetbrains.annotations.NotNull()
    org.springframework.core.MethodParameter parameter) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object resolveArgument(@org.jetbrains.annotations.NotNull()
    org.springframework.core.MethodParameter parameter, @org.jetbrains.annotations.Nullable()
    org.springframework.web.method.support.ModelAndViewContainer mavContainer, @org.jetbrains.annotations.NotNull()
    org.springframework.web.context.request.NativeWebRequest webRequest, @org.jetbrains.annotations.Nullable()
    org.springframework.web.bind.support.WebDataBinderFactory binderFactory) {
        return null;
    }
}