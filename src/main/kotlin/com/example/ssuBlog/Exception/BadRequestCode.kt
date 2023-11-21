package com.example.ssuBlog.Exception

import org.springframework.http.HttpStatus

enum class BadRequestCode(status: HttpStatus, message: String) {
    EXPIRED_TOKEN(HttpStatus.BAD_REQUEST, "만료된 토큰입니다."),
    INVALID_TOKEN(HttpStatus.FORBIDDEN, "유효하지 않은 토큰입니다."),
    EMPTY_TOKEN(HttpStatus.BAD_REQUEST, "토큰이 존재하지 않습니다.");

    public val status: HttpStatus = status
    public val message: String = message
}
