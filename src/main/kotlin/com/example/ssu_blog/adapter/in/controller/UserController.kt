package com.example.ssu_blog.adapter.`in`.controller

import com.example.ssu_blog.adapter.out.persistence.entity.UserEntity
import com.example.ssu_blog.application.service.UserService
import com.example.ssu_blog.adapter.`in`.dto.request.SignOutRequest
import com.example.ssu_blog.adapter.`in`.dto.request.SignUpRequest
import com.example.ssu_blog.adapter.`in`.dto.response.SignUpResponse
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/user")
@Validated
class UserController (
    private val userService: UserService,
    private val encoder: PasswordEncoder
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
    @DeleteMapping("/signout")
    @ResponseStatus(value = HttpStatus.OK)
    fun signOut(
        @Valid @RequestBody request: SignOutRequest
    ) {
        userService.leave(userService.matchAccount(request.email, request.password))
    }
}