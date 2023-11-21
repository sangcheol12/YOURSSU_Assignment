package com.example.ssuBlog.adapter.in.controller;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017J\u0012\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000b\u001a\u00020\u000fH\u0017J\u0012\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\u0017J\u0012\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u000b\u001a\u00020\u0016H\u0017J\b\u0010\u0017\u001a\u00020\u0018H\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/example/ssuBlog/adapter/in/controller/UserController;", "", "userService", "Lcom/example/ssuBlog/application/service/UserService;", "encoder", "Lorg/springframework/security/crypto/password/PasswordEncoder;", "jwtTokenProvider", "Lcom/example/ssuBlog/auth/JwtTokenProvider;", "(Lcom/example/ssuBlog/application/service/UserService;Lorg/springframework/security/crypto/password/PasswordEncoder;Lcom/example/ssuBlog/auth/JwtTokenProvider;)V", "refreshToken", "Lcom/example/ssuBlog/adapter/in/dto/response/TokenRefreshResponse;", "request", "Ljavax/servlet/http/HttpServletRequest;", "signIn", "Lcom/example/ssuBlog/adapter/in/dto/response/SignInResponse;", "Lcom/example/ssuBlog/adapter/in/dto/request/SignInRequest;", "signOut", "", "authInfo", "Lcom/example/ssuBlog/auth/AuthInfo;", "signUp", "Lcom/example/ssuBlog/adapter/in/dto/response/SignUpResponse;", "Lcom/example/ssuBlog/adapter/in/dto/request/SignUpRequest;", "testApi", "", "ssuBlog"})
@io.swagger.v3.oas.annotations.tags.Tag(name = "\ud68c\uc6d0 Api", description = "\ud68c\uc6d0 \uac00\uc785, \ub85c\uadf8\uc778, \ud0c8\ud1f4, \ud1a0\ud070 \uc7ac\ubc1c\uae09")
@org.springframework.validation.annotation.Validated()
@org.springframework.web.bind.annotation.RequestMapping(value = {"/api/user"})
@org.springframework.web.bind.annotation.RestController()
public class UserController {
    private final com.example.ssuBlog.application.service.UserService userService = null;
    private final org.springframework.security.crypto.password.PasswordEncoder encoder = null;
    private final com.example.ssuBlog.auth.JwtTokenProvider jwtTokenProvider = null;
    
    public UserController(@org.jetbrains.annotations.NotNull()
    com.example.ssuBlog.application.service.UserService userService, @org.jetbrains.annotations.NotNull()
    org.springframework.security.crypto.password.PasswordEncoder encoder, @org.jetbrains.annotations.NotNull()
    com.example.ssuBlog.auth.JwtTokenProvider jwtTokenProvider) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @org.springframework.web.bind.annotation.GetMapping(value = {"/test"})
    @org.springframework.web.bind.annotation.ResponseBody()
    public java.lang.String testApi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @org.springframework.web.bind.annotation.PostMapping(value = {"/signup"})
    @org.springframework.web.bind.annotation.ResponseBody()
    @io.swagger.v3.oas.annotations.Operation(summary = "\ud68c\uc6d0 \uac00\uc785", description = "\uc774\uba54\uc77c\uacfc \ud328\uc2a4\uc6cc\ub4dc\ub85c \ud68c\uc6d0 \uac00\uc785", tags = {"\ud68c\uc6d0 Api"}, responses = {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", content = {@io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = com.example.ssuBlog.adapter.in.dto.response.SignUpResponse.class))}, description = "\ud68c\uc6d0 \uac00\uc785 \uc131\uacf5"), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "409", content = {@io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = com.example.ssuBlog.Exception.ExceptionResponse.class))}, description = "\uc774\ubbf8 \uc874\uc7ac\ud558\ub294 \uc774\uba54\uc77c")})
    public com.example.ssuBlog.adapter.in.dto.response.SignUpResponse signUp(@org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.RequestBody()
    @javax.validation.Valid()
    com.example.ssuBlog.adapter.in.dto.request.SignUpRequest request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @org.springframework.web.bind.annotation.PostMapping(value = {"/signin"})
    @org.springframework.web.bind.annotation.ResponseBody()
    @io.swagger.v3.oas.annotations.Operation(summary = "\ub85c\uadf8\uc778", description = "\uc774\uba54\uc77c\uacfc \ud328\uc2a4\uc6cc\ub4dc\ub97c \uc785\ub825\ubc1b\uc544 \ub85c\uadf8\uc778 \ud6c4 \ud1a0\ud070 \ubc1c\uae09", tags = {"\ud68c\uc6d0 Api"}, responses = {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", content = {@io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = com.example.ssuBlog.adapter.in.dto.response.SignInResponse.class))}, description = "\ub85c\uadf8\uc778 \uc131\uacf5"), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", content = {@io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = com.example.ssuBlog.Exception.ExceptionResponse.class))}, description = "Id, \ube44\ubc00\ubc88\ud638\uac00 \uc77c\uce58\ud558\ub294 \ud68c\uc6d0\uc774 \uc5c6\uc74c")})
    public com.example.ssuBlog.adapter.in.dto.response.SignInResponse signIn(@org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.RequestBody()
    @javax.validation.Valid()
    com.example.ssuBlog.adapter.in.dto.request.SignInRequest request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @org.springframework.web.bind.annotation.PostMapping(value = {"/refresh"})
    @org.springframework.web.bind.annotation.ResponseBody()
    @io.swagger.v3.oas.annotations.Operation(summary = "\ud1a0\ud070 \uc7ac\ubc1c\uae09", description = "\ub9ac\ud504\ub808\uc26c \ud1a0\ud070\uc744 \ud5e4\ub354\ub85c \ubc1b\uc544 \ud1a0\ud070 \uc7ac\ubc1c\uae09", tags = {"\ud68c\uc6d0 Api"}, responses = {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", content = {@io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = com.example.ssuBlog.adapter.in.dto.response.TokenRefreshResponse.class))}, description = "\ud1a0\ud070 \uc7ac\ubc1c\uae09 \uc131\uacf5"), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", content = {@io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = com.example.ssuBlog.adapter.in.dto.response.TokenRefreshResponse.class))}, description = "\uc720\ud6a8\ud558\uc9c0 \uc54a\uc740 \ud1a0\ud070 \ud639\uc740 DB \ub9ac\ud504\ub808\uc26c \ud1a0\ud070\uacfc \ubd88\uc77c\uce58")})
    public com.example.ssuBlog.adapter.in.dto.response.TokenRefreshResponse refreshToken(@org.jetbrains.annotations.NotNull()
    javax.servlet.http.HttpServletRequest request) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @org.springframework.web.bind.annotation.DeleteMapping(value = {"/signout"})
    @org.springframework.web.bind.annotation.ResponseBody()
    @io.swagger.v3.oas.annotations.Operation(summary = "\ud68c\uc6d0 \ud0c8\ud1f4", description = "\ud604\uc7ac \uc811\uc18d \uc911\uc778 \uc720\uc800 \uc0ad\uc81c", tags = {"\ud68c\uc6d0 Api"}, responses = {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "\ud68c\uc6d0 \ud0c8\ud1f4 \uc131\uacf5"), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", content = {@io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = com.example.ssuBlog.Exception.ExceptionResponse.class))}, description = "\uc798\ubabb \ub41c \uc811\uadfc")})
    public void signOut(@org.jetbrains.annotations.NotNull()
    @com.example.ssuBlog.annotation.Auth()
    com.example.ssuBlog.auth.AuthInfo authInfo) {
    }
}