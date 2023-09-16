package com.example.ssu_blog.Exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationException(ex: MethodArgumentNotValidException): ResponseEntity<ExceptionResponse> {
        // Obtain the current request attributes
        val requestAttributes = RequestContextHolder.getRequestAttributes() as ServletRequestAttributes
        val requestURI = requestAttributes.request.requestURI

        val errorMessage = ex.bindingResult.fieldErrors.map {
            "${it.defaultMessage}"
        }.joinToString("\n")

        val exceptionResponse = ExceptionResponse(HttpStatus.UNPROCESSABLE_ENTITY, errorMessage, requestURI)
        return ResponseEntity.status(422).body(exceptionResponse)
    }
}