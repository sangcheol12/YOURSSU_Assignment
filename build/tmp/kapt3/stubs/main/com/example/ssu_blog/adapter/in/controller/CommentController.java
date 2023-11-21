package com.example.ssu_blog.adapter.in.controller;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ&\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0017J&\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\u0017J0\u0010\u0014\u001a\u00020\u00112\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/ssu_blog/adapter/in/controller/CommentController;", "", "userService", "Lcom/example/ssu_blog/application/service/UserService;", "articleService", "Lcom/example/ssu_blog/application/service/ArticleService;", "commentService", "Lcom/example/ssu_blog/application/service/CommentService;", "(Lcom/example/ssu_blog/application/service/UserService;Lcom/example/ssu_blog/application/service/ArticleService;Lcom/example/ssu_blog/application/service/CommentService;)V", "deleteComment", "", "articleId", "", "commentId", "authInfo", "Lcom/example/ssu_blog/auth/AuthInfo;", "postComment", "Lcom/example/ssu_blog/adapter/in/dto/response/CommentCreateOrUpdateResponse;", "request", "Lcom/example/ssu_blog/adapter/in/dto/request/CommentCreateOrUpdateRequest;", "updateComment", "ssu_blog"})
@io.swagger.v3.oas.annotations.tags.Tag(name = "\ub313\uae00 Api", description = "\ub313\uae00 \ub4f1\ub85d, \uc218\uc815 \uc0ad\uc81c")
@org.springframework.validation.annotation.Validated()
@org.springframework.web.bind.annotation.RequestMapping(value = {"api/comment"})
@org.springframework.web.bind.annotation.RestController()
public class CommentController {
    private final com.example.ssu_blog.application.service.UserService userService = null;
    private final com.example.ssu_blog.application.service.ArticleService articleService = null;
    private final com.example.ssu_blog.application.service.CommentService commentService = null;
    
    public CommentController(@org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.application.service.UserService userService, @org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.application.service.ArticleService articleService, @org.jetbrains.annotations.NotNull()
    com.example.ssu_blog.application.service.CommentService commentService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @org.springframework.web.bind.annotation.PostMapping(value = {"/{articleId}"})
    @org.springframework.web.bind.annotation.ResponseBody()
    @io.swagger.v3.oas.annotations.Operation(summary = "\ub313\uae00 \ub4f1\ub85d", description = "\ub313\uae00 \ubcf8\ubb38\uc744 \ubc1b\uc544 \ub313\uae00 \ub4f1\ub85d", tags = {"\ub313\uae00 Api"}, responses = {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", content = {@io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = com.example.ssu_blog.adapter.in.dto.response.CommentCreateOrUpdateResponse.class))}, description = "\ub313\uae00 \ub4f1\ub85d \uc131\uacf5"), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", content = {@io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = com.example.ssu_blog.Exception.ExceptionResponse.class))}, description = "\uac8c\uc0ac\uae00\uc774 \uc874\uc7ac\ud558\uc9c0 \uc54a\uac70\ub098 \uc798\ubabb \ub41c \uc811\uadfc")})
    public com.example.ssu_blog.adapter.in.dto.response.CommentCreateOrUpdateResponse postComment(@org.springframework.web.bind.annotation.PathVariable(value = "articleId")
    long articleId, @org.jetbrains.annotations.NotNull()
    @com.example.ssu_blog.annotation.Auth()
    com.example.ssu_blog.auth.AuthInfo authInfo, @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.RequestBody()
    @javax.validation.Valid()
    com.example.ssu_blog.adapter.in.dto.request.CommentCreateOrUpdateRequest request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @org.springframework.web.bind.annotation.PutMapping(value = {"/{articleId}/{commentId}"})
    @org.springframework.web.bind.annotation.ResponseBody()
    @io.swagger.v3.oas.annotations.Operation(summary = "\ub313\uae00 \uc218\uc815", description = "\ubcc0\uacbd \ub420 \ub313\uae00 \ub0b4\uc6a9\uc744 \ubc1b\uc544 Path\ub85c \ub4e4\uc5b4\uc628 \ub313\uae00 \uc218\uc815", tags = {"\ub313\uae00 Api"}, responses = {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", content = {@io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = com.example.ssu_blog.adapter.in.dto.response.CommentCreateOrUpdateResponse.class))}, description = "\ub313\uae00 \uc218\uc815 \uc131\uacf5"), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", content = {@io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = com.example.ssu_blog.Exception.ExceptionResponse.class))}, description = "\ub313\uae00\uc774 \uc874\uc7ac\ud558\uc9c0 \uc54a\uac70\ub098 \uc798\ubabb \ub41c \uc811\uadfc"), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", content = {@io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = com.example.ssu_blog.Exception.ExceptionResponse.class))}, description = "\ub313\uae00\uc744 \uc218\uc815 \ud560 \uad8c\ud55c\uc774 \uc5c6\uc74c")})
    public com.example.ssu_blog.adapter.in.dto.response.CommentCreateOrUpdateResponse updateComment(@org.springframework.web.bind.annotation.PathVariable(value = "articleId")
    long articleId, @org.springframework.web.bind.annotation.PathVariable(value = "commentId")
    long commentId, @org.jetbrains.annotations.NotNull()
    @com.example.ssu_blog.annotation.Auth()
    com.example.ssu_blog.auth.AuthInfo authInfo, @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.RequestBody()
    @javax.validation.Valid()
    com.example.ssu_blog.adapter.in.dto.request.CommentCreateOrUpdateRequest request) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @org.springframework.web.bind.annotation.DeleteMapping(value = {"/{articleId}/{commentId}"})
    @org.springframework.web.bind.annotation.ResponseBody()
    @io.swagger.v3.oas.annotations.Operation(summary = "\ub313\uae00 \uc0ad\uc81c", description = "Path\ub85c \ub4e4\uc5b4\uc628 \uac8c\uc2dc\uae00 \ubc11\uc5d0 \ub313\uae00 \uc0ad\uc81c", tags = {"\ub313\uae00 Api"}, responses = {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "\ub313\uae00 \uc0ad\uc81c \uc131\uacf5"), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", content = {@io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = com.example.ssu_blog.Exception.ExceptionResponse.class))}, description = "\ub313\uae00\uc774 \uc874\uc7ac\ud558\uc9c0 \uc54a\uac70\ub098 \uc798\ubabb \ub41c \uc811\uadfc"), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", content = {@io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = com.example.ssu_blog.Exception.ExceptionResponse.class))}, description = "\ub313\uae00\uc744 \uc0ad\uc81c \ud560 \uad8c\ud55c\uc774 \uc5c6\uc74c")})
    public void deleteComment(@org.springframework.web.bind.annotation.PathVariable(value = "articleId")
    long articleId, @org.springframework.web.bind.annotation.PathVariable(value = "commentId")
    long commentId, @org.jetbrains.annotations.NotNull()
    @com.example.ssu_blog.annotation.Auth()
    com.example.ssu_blog.auth.AuthInfo authInfo) {
    }
}