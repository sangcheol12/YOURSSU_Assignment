package com.example.ssuBlog.Exception

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.http.HttpStatus
import java.time.LocalDateTime

data class ExceptionResponse(
    val status: HttpStatus,
    val message: String,
    val requestURI: String
) {
    @field:JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    var time: LocalDateTime = LocalDateTime.now()
}
