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

    private fun handleException(ex: Exception, status: HttpStatus): ResponseEntity<ExceptionResponse> {
        val requestAttributes = RequestContextHolder.getRequestAttributes() as ServletRequestAttributes
        val requestURI = requestAttributes.request.requestURI

        val errorMessage = ex.message ?: "undefined error"
        val exceptionResponse = ExceptionResponse(status, errorMessage, requestURI)
        return ResponseEntity.status(status).body(exceptionResponse)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationException(ex: MethodArgumentNotValidException): ResponseEntity<ExceptionResponse> {
        val requestAttributes = RequestContextHolder.getRequestAttributes() as ServletRequestAttributes
        val requestURI = requestAttributes.request.requestURI

        val errorMessage = ex.bindingResult.fieldErrors.map {
            "${it.defaultMessage}"
        }.joinToString("\n")

        val exceptionResponse = ExceptionResponse(HttpStatus.UNPROCESSABLE_ENTITY, errorMessage, requestURI)
        return ResponseEntity.status(422).body(exceptionResponse)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(ex: IllegalArgumentException): ResponseEntity<ExceptionResponse> {
        return handleException(ex, HttpStatus.UNAUTHORIZED)
    }

    @ExceptionHandler(IllegalAccessException::class)
    fun handleIllegalAccessException(ex: IllegalAccessException): ResponseEntity<ExceptionResponse> {
        return handleException(ex, HttpStatus.FORBIDDEN)
    }

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNoSuchElementException(ex: NoSuchElementException): ResponseEntity<ExceptionResponse> {
        return handleException(ex, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(IllegalStateException::class)
    fun handleIllegalStateException(ex: IllegalStateException): ResponseEntity<ExceptionResponse> {
        return handleException(ex, HttpStatus.CONFLICT)
    }
}