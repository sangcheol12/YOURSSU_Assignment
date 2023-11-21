package com.example.ssu_blog.adapter.in.controller;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\fH\u0017J\u001c\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0017J&\u0010\u0011\u001a\u00020\u000e2\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/ssu_blog/adapter/in/controller/ArticleController;", "", "userService", "Lcom/example/ssu_blog/application/service/UserService;", "articleService", "Lcom/example/ssu_blog/application/service/ArticleService;", "(Lcom/example/ssu_blog/application/service/UserService;Lcom/example/ssu_blog/application/service/ArticleService;)V", "deleteArticle", "", "articleId", "", "authInfo", "Lcom/example/ssu_blog/auth/AuthInfo;", "postArticle", "Lcom/example/ssu_blog/adapter/in/dto/response/ArticleCreateOrUpdateResponse;", "request", "Lcom/example/ssu_blog/adapter/in/dto/request/ArticleCreateOrUpdateRequest;", "updateArticle", "ssu_blog"})
@io.swagger.v3.oas.annotations.tags.Tag(name = "\uac8c\uc2dc\uae00 Api", description = "\uac8c\uc2dc\uae00 \ub4f1\ub85d, \uc218\uc815 \uc0ad\uc81c")
@org.springframework.validation.annotation.Validated()
@org.springframework.web.bind.annotation.RequestMapping(value = {"api/article"})
@org.springframework.web.bind.annotation.RestController()
public class ArticleController {
    private final com.example.ssu_blog.application.service.UserService userService = null;
    private final com.example.ssu_blog.application.service.ArticleService articleService = null;
    
    public ArticleController(@org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.application.service.UserService userService, @org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.application.service.ArticleService articleService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @org.springframework.web.bind.annotation.PostMapping(value = {""})
    @org.springframework.web.bind.annotation.ResponseBody()
    @io.swagger.v3.oas.annotations.Operation(summary = "\uac8c\uc2dc\uae00 \ub4f1\ub85d", description = "\uac8c\uc2dc\uae00 \uc81c\ubaa9\uacfc \ubcf8\ubb38\uc744 \ubc1b\uc544 \uac8c\uc2dc\uae00 \ub4f1\ub85d", tags = {"\uac8c\uc2dc\uae00 Api"}, responses = {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", content = {@io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = com.example.ssu_blog.adapter.in.dto.response.ArticleCreateOrUpdateResponse.class))}, description = "\uac8c\uc2dc\uae00 \ub4f1\ub85d \uc131\uacf5"), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", content = {@io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = com.example.ssu_blog.Exception.ExceptionResponse.class))}, description = "\uc798\ubabb \ub41c \uc811\uadfc")})
    public com.example.ssu_blog.adapter.in.dto.response.ArticleCreateOrUpdateResponse postArticle(@org.jetbrains.annotations.NotNull()
    @com.example.ssu_blog.annotation.Auth()
    com.example.ssu_blog.auth.AuthInfo authInfo, @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.RequestBody()
    @javax.validation.Valid()
    com.example.ssu_blog.adapter.in.dto.request.ArticleCreateOrUpdateRequest request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @org.springframework.web.bind.annotation.PutMapping(value = {"/{articleId}"})
    @org.springframework.web.bind.annotation.ResponseBody()
    @io.swagger.v3.oas.annotations.Operation(summary = "\uac8c\uc2dc\uae00 \uc218\uc815", description = "\ubcc0\uacbd \ub420 \uac8c\uc2dc\uae00 \uc81c\ubaa9\uacfc \ubcf8\ubb38\uc744 \ubc1b\uc544 Path\ub85c \ub4e4\uc5b4\uc628 \uac8c\uc2dc\uae00 \uc218\uc815", tags = {"\uac8c\uc2dc\uae00 Api"}, responses = {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", content = {@io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = com.example.ssu_blog.adapter.in.dto.response.ArticleCreateOrUpdateResponse.class))}, description = "\uac8c\uc2dc\uae00 \uc218\uc815 \uc131\uacf5"), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", content = {@io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = com.example.ssu_blog.Exception.ExceptionResponse.class))}, description = "\uac8c\uc2dc\uae00\uc774 \uc874\uc7ac\ud558\uc9c0 \uc54a\uac70\ub098 \uc798\ubabb \ub41c \uc811\uadfc"), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", content = {@io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = com.example.ssu_blog.Exception.ExceptionResponse.class))}, description = "\uac8c\uc2dc\uae00\uc744 \uc218\uc815 \ud560 \uad8c\ud55c\uc774 \uc5c6\uc74c")})
    public com.example.ssu_blog.adapter.in.dto.response.ArticleCreateOrUpdateResponse updateArticle(@org.springframework.web.bind.annotation.PathVariable(value = "articleId")
    long articleId, @org.jetbrains.annotations.NotNull()
    @com.example.ssu_blog.annotation.Auth()
    com.example.ssu_blog.auth.AuthInfo authInfo, @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.RequestBody()
    @javax.validation.Valid()
    com.example.ssu_blog.adapter.in.dto.request.ArticleCreateOrUpdateRequest request) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @org.springframework.web.bind.annotation.DeleteMapping(value = {"/{articleId}"})
    @org.springframework.web.bind.annotation.ResponseBody()
    @io.swagger.v3.oas.annotations.Operation(summary = "\uac8c\uc2dc\uae00 \uc0ad\uc81c", description = "Path\ub85c \ub4e4\uc5b4\uc628 \uac8c\uc2dc\uae00 \uc0ad\uc81c", tags = {"\uac8c\uc2dc\uae00 Api"}, responses = {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", content = {@io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = com.example.ssu_blog.adapter.in.dto.response.ArticleCreateOrUpdateResponse.class))}, description = "\uac8c\uc2dc\uae00 \uc218\uc815 \uc131\uacf5"), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", content = {@io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = com.example.ssu_blog.Exception.ExceptionResponse.class))}, description = "\uac8c\uc2dc\uae00\uc774 \uc874\uc7ac\ud558\uc9c0 \uc54a\uac70\ub098 \uc798\ubabb \ub41c \uc811\uadfc"), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", content = {@io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = com.example.ssu_blog.Exception.ExceptionResponse.class))}, description = "\uac8c\uc2dc\uae00\uc744 \uc0ad\uc81c \ud560 \uad8c\ud55c\uc774 \uc5c6\uc74c")})
    public void deleteArticle(@org.springframework.web.bind.annotation.PathVariable(value = "articleId")
    long articleId, @org.jetbrains.annotations.NotNull()
    @com.example.ssu_blog.annotation.Auth()
    com.example.ssu_blog.auth.AuthInfo authInfo) {
    }
}