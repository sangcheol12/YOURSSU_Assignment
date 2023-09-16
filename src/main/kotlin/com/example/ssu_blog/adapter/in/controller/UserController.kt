package com.example.ssu_blog.adapter.`in`.controller

import com.example.ssu_blog.adapter.out.persistence.entity.UserEntity
import com.example.ssu_blog.application.service.UserService
import com.example.ssu_blog.adapter.`in`.dto.request.SignOutRequest
import com.example.ssu_blog.adapter.`in`.dto.request.SignUpRequest
import com.example.ssu_blog.adapter.`in`.dto.response.SignUpResponse
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/user")
class UserController (
    private val userService: UserService,
    private val encoder: PasswordEncoder
) {
    @ResponseBody
    @PostMapping("/signup")
    fun signUp(
        @Valid @RequestBody request: SignUpRequest
    ): ResponseEntity<Any> {
        val user = UserEntity.from(request, encoder)
        val signUpResponse = SignUpResponse.from(userService.join(user))
        return ResponseEntity.status(200).body(signUpResponse)
    }

    @ResponseBody
    @DeleteMapping("/signout")
    fun signOut(
        @Valid @RequestBody request: SignOutRequest
    ): ResponseEntity<Any> {
        val deleteUser = userService.matchAccount(request.email, request.password)
        userService.leave(deleteUser)
        return ResponseEntity.status(200).body(null)
    }
}