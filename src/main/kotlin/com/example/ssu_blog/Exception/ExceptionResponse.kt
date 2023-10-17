package com.example.ssu_blog.Exception

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import org.springframework.http.HttpStatus
import java.time.LocalDateTime

data class ExceptionResponse (
    val status: HttpStatus,
    val message: String,
    val requestURI: String
) {
    @field:JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    var time: LocalDateTime = LocalDateTime.now()
}