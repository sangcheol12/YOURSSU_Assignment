package com.example.ssu_blog.auth

import com.example.ssu_blog.Exception.CustomBadRequestException
import com.example.ssu_blog.Exception.ExceptionResponse
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class ExceptionHandlerFilter : OncePerRequestFilter() {
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        try {
            filterChain.doFilter(request, response)
        } catch (ex: CustomBadRequestException) {
            setExceptionResponse(HttpStatus.FORBIDDEN, response, ex)
        }
    }

    fun setExceptionResponse(status: HttpStatus, response: HttpServletResponse, ex: CustomBadRequestException) {
        response.status = status.value()
        response.contentType = "application/json;charset=UTF-8"
        val exceptionResponse = ExceptionResponse(ex.badRequestCode.status, ex.badRequestCode.message, "sdadasf")
        try {
            val objectMapper = ObjectMapper()
            objectMapper.registerModule(JavaTimeModule())
            val json = objectMapper.writeValueAsString(exceptionResponse)
            response.writer.write(json)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}