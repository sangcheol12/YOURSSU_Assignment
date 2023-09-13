package com.example.ssu_blog.transfer

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

data class ExceptionResponse (
    val status: HttpStatus,
    val message: String,
    val requestURI: String
) {
    val time: LocalDateTime = LocalDateTime.now()
}