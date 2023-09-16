package com.example.ssu_blog.user.controller

import com.example.ssu_blog.user.domain.entity.UserModel
import com.example.ssu_blog.user.service.UserService
import com.example.ssu_blog.Exception.ExceptionResponse
import com.example.ssu_blog.user.dto.request.SignOutRequest
import com.example.ssu_blog.user.dto.request.SignUpRequest
import com.example.ssu_blog.user.dto.response.SignUpResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

@RestController
@RequestMapping("/api/user")
class UserController (
    private val userService: UserService,
    private val encoder: PasswordEncoder
) {
    @ResponseBody
    @PostMapping("/signup")
    fun signUp(@RequestBody request: SignUpRequest): ResponseEntity<Any> {
        val requestAttributes = RequestContextHolder.getRequestAttributes() as ServletRequestAttributes
        val requestURI = requestAttributes.request.requestURI
        val user = UserModel.from(request, encoder)
        var signUpResponse: SignUpResponse
        try {
            signUpResponse = SignUpResponse.from(userService.join(user))
        } catch(e: IllegalStateException) {
            val exceptionResponse = ExceptionResponse(HttpStatus.CONFLICT, e.message.toString(), requestURI)
            return ResponseEntity.status(409).body(exceptionResponse)
        }
        return ResponseEntity.status(200).body(signUpResponse)
    }

    @ResponseBody
    @DeleteMapping("/signout")
    fun signOut(@RequestBody request: SignOutRequest): ResponseEntity<Any> {
        val requestAttributes = RequestContextHolder.getRequestAttributes() as ServletRequestAttributes
        val requestURI = requestAttributes.request.requestURI
        val deleteUser: UserModel
        try {
            deleteUser = userService.matchAccount(request.email, request.password)
        } catch (e: IllegalArgumentException) {
            val exceptionResponse = ExceptionResponse(HttpStatus.UNAUTHORIZED, e.message.toString(), requestURI)
            return ResponseEntity.status(401).body(exceptionResponse)
        }
        userService.leave(deleteUser)
        return ResponseEntity.status(200).body(null)
    }
}