package com.example.ssu_blog.adapter.`in`.controller

import com.example.ssu_blog.adapter.`in`.dto.request.SignInRequest
import com.example.ssu_blog.adapter.out.persistence.entity.UserEntity
import com.example.ssu_blog.application.service.UserService
import com.example.ssu_blog.adapter.`in`.dto.request.SignUpRequest
import com.example.ssu_blog.adapter.`in`.dto.response.SignInResponse
import com.example.ssu_blog.adapter.`in`.dto.response.SignUpResponse
import com.example.ssu_blog.annotation.Auth
import com.example.ssu_blog.auth.AuthInfo
import com.example.ssu_blog.auth.JwtTokenProvider
import org.springframework.http.HttpStatus
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/user")
@Validated
class UserController (
    private val userService: UserService,
    private val encoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider
) {
    @ResponseBody
    @PostMapping("/signup")
    @ResponseStatus(value = HttpStatus.OK)
    fun signUp(
        @Valid @RequestBody request: SignUpRequest
    ): SignUpResponse {
        val user = UserEntity.from(request, encoder)
        return SignUpResponse.from(userService.join(user))
    }

    @ResponseBody
    @PostMapping("/signin")
    @ResponseStatus(value = HttpStatus.OK)
    fun signIn(
        @Valid @RequestBody request: SignInRequest
    ): SignInResponse {
        val user = userService.matchAccount(request.email, request.password)
        val accessToken = jwtTokenProvider.createAccessToken(user.email,user.role.value())
        return SignInResponse.from(user, accessToken)
    }

    @ResponseBody
    @DeleteMapping("/signout")
    @ResponseStatus(value = HttpStatus.OK)
    fun signOut(
        @Auth authInfo: AuthInfo
    ) {
        userService.leave(userService.findOneByEmail(authInfo.email))
    }
}