package com.example.ssuBlog.adapter.`in`.controller

import com.example.ssuBlog.Exception.ExceptionResponse
import com.example.ssuBlog.adapter.`in`.dto.request.SignInRequest
import com.example.ssuBlog.adapter.`in`.dto.request.SignUpRequest
import com.example.ssuBlog.adapter.`in`.dto.response.SignInResponse
import com.example.ssuBlog.adapter.`in`.dto.response.SignUpResponse
import com.example.ssuBlog.adapter.`in`.dto.response.TokenRefreshResponse
import com.example.ssuBlog.adapter.out.persistence.entity.UserEntity
import com.example.ssuBlog.annotation.Auth
import com.example.ssuBlog.application.service.UserService
import com.example.ssuBlog.auth.AuthInfo
import com.example.ssuBlog.auth.JwtTokenProvider
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest
import javax.validation.Valid

@RestController
@RequestMapping("/api/user")
@Validated
@Tag(name = "회원 Api", description = "회원 가입, 로그인, 탈퇴, 토큰 재발급")
class UserController(
    private val userService: UserService,
    private val encoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider
) {
    @ResponseBody
    @GetMapping("/test")
    @ResponseStatus(value = HttpStatus.OK)
    fun testApi() = "Api Test Success"

    @Operation(
        summary = "회원 가입",
        description = "이메일과 패스워드로 회원 가입",
        tags = ["회원 Api"],
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "회원 가입 성공",
                content = [Content(schema = Schema(implementation = SignUpResponse::class))]
            ),
            ApiResponse(
                responseCode = "409",
                description = "이미 존재하는 이메일",
                content = [Content(schema = Schema(implementation = ExceptionResponse::class))]
            )
        ]
    )
    @ResponseBody
    @PostMapping("/signup")
    @ResponseStatus(value = HttpStatus.OK)
    fun signUp(
        @Valid @RequestBody
        request: SignUpRequest
    ): SignUpResponse {
        val user = UserEntity.from(request, encoder)
        return SignUpResponse.from(userService.join(user))
    }

    @Operation(
        summary = "로그인",
        description = "이메일과 패스워드를 입력받아 로그인 후 토큰 발급",
        tags = ["회원 Api"],
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "로그인 성공",
                content = [Content(schema = Schema(implementation = SignInResponse::class))]
            ),
            ApiResponse(
                responseCode = "401",
                description = "Id, 비밀번호가 일치하는 회원이 없음",
                content = [Content(schema = Schema(implementation = ExceptionResponse::class))]
            )
        ]
    )
    @ResponseBody
    @PostMapping("/signin")
    @ResponseStatus(value = HttpStatus.OK)
    fun signIn(
        @Valid @RequestBody
        request: SignInRequest
    ): SignInResponse {
        val user = userService.matchAccount(request.email, request.password)
        val accessToken = jwtTokenProvider.createAccessToken(user.email, user.role.value())
        return SignInResponse.from(user, accessToken)
    }

    @Operation(
        summary = "토큰 재발급",
        description = "리프레쉬 토큰을 헤더로 받아 토큰 재발급",
        tags = ["회원 Api"],
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "토큰 재발급 성공",
                content = [Content(schema = Schema(implementation = TokenRefreshResponse::class))]
            ),
            ApiResponse(
                responseCode = "403",
                description = "유효하지 않은 토큰 혹은 DB 리프레쉬 토큰과 불일치",
                content = [Content(schema = Schema(implementation = TokenRefreshResponse::class))]
            )
        ]
    )
    @ResponseBody
    @PostMapping("/refresh")
    @ResponseStatus(value = HttpStatus.OK)
    fun refreshToken(
        request: HttpServletRequest
    ): TokenRefreshResponse {
        return userService.refreshToken(request)
    }

    @Operation(
        summary = "회원 탈퇴",
        description = "현재 접속 중인 유저 삭제",
        tags = ["회원 Api"],
        responses = [
            ApiResponse(responseCode = "200", description = "회원 탈퇴 성공"),
            ApiResponse(
                responseCode = "404",
                description = "잘못 된 접근",
                content = [Content(schema = Schema(implementation = ExceptionResponse::class))]
            )
        ]
    )
    @ResponseBody
    @DeleteMapping("/signout")
    @ResponseStatus(value = HttpStatus.OK)
    fun signOut(
        @Auth authInfo: AuthInfo
    ) {
        userService.leave(userService.findOneByEmail(authInfo.email))
    }
}
