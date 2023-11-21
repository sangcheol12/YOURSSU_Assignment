package com.example.ssuBlog.Exception;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/example/ssuBlog/Exception/CustomBadRequestException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "badRequestCode", "Lcom/example/ssuBlog/Exception/BadRequestCode;", "(Lcom/example/ssuBlog/Exception/BadRequestCode;)V", "getBadRequestCode", "()Lcom/example/ssuBlog/Exception/BadRequestCode;", "ssuBlog"})
public final class CustomBadRequestException extends java.lang.RuntimeException {
    @org.jetbrains.annotations.NotNull()
    private final com.example.ssuBlog.Exception.BadRequestCode badRequestCode = null;
    
    public CustomBadRequestException(@org.jetbrains.annotations.NotNull()
    com.example.ssuBlog.Exception.BadRequestCode badRequestCode) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.ssuBlog.Exception.BadRequestCode getBadRequestCode() {
        return null;
    }
}