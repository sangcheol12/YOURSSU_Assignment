package com.example.ssu_blog.adapter.`in`.controller

import com.example.ssu_blog.adapter.`in`.dto.response.UserInfoResponse
import com.example.ssu_blog.annotation.Auth
import com.example.ssu_blog.application.service.AdminUserInfoService
import com.example.ssu_blog.auth.AuthInfo
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class AdminUserInfoController (
    private val userInfoService: AdminUserInfoService
) {
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/show")
    fun getUserList(
        @Auth authInfo: AuthInfo,
        @RequestParam(required = false) username: String? = null,
        @RequestParam(required = false) email: String? = null,
        @RequestParam(required = false) createdAtStart: String? = null,
        @RequestParam(required = false) createdAtEnd: String? = null,
        @RequestParam(required = false) updatedAtStart: String? = null,
        @RequestParam(required = false) updatedAtEnd: String? = null
    ): List<UserInfoResponse> {
        if(!authInfo.role.equals("ADMIN")) throw IllegalAccessException("메소드에 접근 할 권한이 없습니다.")
        val userEntities = userInfoService.queryUserInfo(username, email, createdAtStart, createdAtEnd, updatedAtStart, updatedAtEnd)
        return userEntities.map { UserInfoResponse.from(it) }
    }
}