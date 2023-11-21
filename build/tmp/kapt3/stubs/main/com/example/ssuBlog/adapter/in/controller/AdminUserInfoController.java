package com.example.ssuBlog.adapter.in.controller;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J`\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/ssuBlog/adapter/in/controller/AdminUserInfoController;", "", "userInfoService", "Lcom/example/ssuBlog/application/service/AdminUserInfoService;", "(Lcom/example/ssuBlog/application/service/AdminUserInfoService;)V", "getUserList", "", "Lcom/example/ssuBlog/adapter/in/dto/response/UserInfoResponse;", "authInfo", "Lcom/example/ssuBlog/auth/AuthInfo;", "username", "", "email", "createdAtStart", "createdAtEnd", "updatedAtStart", "updatedAtEnd", "ssuBlog"})
@org.springframework.web.bind.annotation.RestController()
public class AdminUserInfoController {
    private final com.example.ssuBlog.application.service.AdminUserInfoService userInfoService = null;
    
    public AdminUserInfoController(@org.jetbrains.annotations.NotNull()
    com.example.ssuBlog.application.service.AdminUserInfoService userInfoService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.GetMapping(value = {"/show"})
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @org.springframework.web.bind.annotation.ResponseBody()
    public java.util.List<com.example.ssuBlog.adapter.in.dto.response.UserInfoResponse> getUserList(@org.jetbrains.annotations.NotNull()
    @com.example.ssuBlog.annotation.Auth()
    com.example.ssuBlog.auth.AuthInfo authInfo, @org.jetbrains.annotations.Nullable()
    @org.springframework.web.bind.annotation.RequestParam(required = false)
    java.lang.String username, @org.jetbrains.annotations.Nullable()
    @org.springframework.web.bind.annotation.RequestParam(required = false)
    java.lang.String email, @org.jetbrains.annotations.Nullable()
    @org.springframework.web.bind.annotation.RequestParam(required = false)
    java.lang.String createdAtStart, @org.jetbrains.annotations.Nullable()
    @org.springframework.web.bind.annotation.RequestParam(required = false)
    java.lang.String createdAtEnd, @org.jetbrains.annotations.Nullable()
    @org.springframework.web.bind.annotation.RequestParam(required = false)
    java.lang.String updatedAtStart, @org.jetbrains.annotations.Nullable()
    @org.springframework.web.bind.annotation.RequestParam(required = false)
    java.lang.String updatedAtEnd) {
        return null;
    }
}