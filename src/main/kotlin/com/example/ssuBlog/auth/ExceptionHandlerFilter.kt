package com.example.ssuBlog.auth

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class ExceptionHandlerFilter : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (ex: com.example.ssuBlog.Exception.CustomBadRequestException) {
            setExceptionResponse(HttpStatus.FORBIDDEN, response, ex)
        }
    }

    fun setExceptionResponse(
        status: HttpStatus,
        response: HttpServletResponse,
        ex: com.example.ssuBlog.Exception.CustomBadRequestException
    ) {
        val requestAttributes = RequestContextHolder.getRequestAttributes() as ServletRequestAttributes
        val requestURI = requestAttributes.request.requestURI

        response.status = status.value()
        response.contentType = "application/json;charset=UTF-8"
        val exceptionResponse = com.example.ssuBlog.Exception.ExceptionResponse(
            ex.badRequestCode.status,
            ex.badRequestCode.message,
            requestURI
        )
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
