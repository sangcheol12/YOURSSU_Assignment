package com.example.ssuBlog.config;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/ssuBlog/config/WebConfig;", "Lorg/springframework/web/servlet/config/annotation/WebMvcConfigurer;", "customHandlerMethodArgumentResolver", "Lcom/example/ssuBlog/resolver/CustomHandlerMethodArgumentResolver;", "(Lcom/example/ssuBlog/resolver/CustomHandlerMethodArgumentResolver;)V", "addArgumentResolvers", "", "argumentResolvers", "", "Lorg/springframework/web/method/support/HandlerMethodArgumentResolver;", "ssuBlog"})
@org.springframework.context.annotation.Configuration()
public class WebConfig implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer {
    private final com.example.ssuBlog.resolver.CustomHandlerMethodArgumentResolver customHandlerMethodArgumentResolver = null;
    
    @org.springframework.beans.factory.annotation.Autowired()
    public WebConfig(@org.jetbrains.annotations.NotNull()
    com.example.ssuBlog.resolver.CustomHandlerMethodArgumentResolver customHandlerMethodArgumentResolver) {
        super();
    }
    
    @java.lang.Override()
    public void addArgumentResolvers(@org.jetbrains.annotations.NotNull()
    java.util.List<org.springframework.web.method.support.HandlerMethodArgumentResolver> argumentResolvers) {
    }
}