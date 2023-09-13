package com.example.ssu_blog.controller

import com.example.ssu_blog.domain.UserModel
import com.example.ssu_blog.service.UserService
import com.example.ssu_blog.transfer.ExceptionResponse
import com.example.ssu_blog.transfer.user.SignUpRequest
import com.example.ssu_blog.transfer.user.SignUpResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user")
class UserController (
    private val userService: UserService,
    private val encoder: PasswordEncoder
) {
    @ResponseBody
    @PostMapping("/signup")
    fun signUp(@RequestBody request: SignUpRequest): ResponseEntity<Any> {
        val user = UserModel.from(request, encoder)
        var signUpResponse: SignUpResponse
        try {
            signUpResponse = SignUpResponse.from(userService.join(user))
        } catch(e: IllegalStateException) {
            val exceptionResponse = ExceptionResponse(HttpStatus.CONFLICT, "이미 존재하는 회원입니다.", "/api/user/signup")
            return ResponseEntity.status(409).body(exceptionResponse)
        }
        return ResponseEntity.status(200).body(signUpResponse)
    }
}