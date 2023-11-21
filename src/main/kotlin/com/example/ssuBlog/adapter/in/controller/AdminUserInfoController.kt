package com.example.ssuBlog.adapter.`in`.controller

import com.example.ssuBlog.adapter.`in`.dto.response.UserInfoResponse
import com.example.ssuBlog.annotation.Auth
import com.example.ssuBlog.application.service.AdminUserInfoService
import com.example.ssuBlog.auth.AuthInfo
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class AdminUserInfoController(
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
        if (!authInfo.role.equals("ADMIN")) throw IllegalAccessException("메소드에 접근 할 권한이 없습니다.")
        val userEntities = userInfoService.queryUserInfo(
            username,
            email,
            createdAtStart,
            createdAtEnd,
            updatedAtStart,
            updatedAtEnd
        )
        return userEntities.map { UserInfoResponse.from(it) }
    }
}
