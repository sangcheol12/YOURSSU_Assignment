package com.example.ssu_blog.article.controller

import com.example.ssu_blog.article.domain.entity.Article
import com.example.ssu_blog.user.domain.entity.UserModel
import com.example.ssu_blog.article.service.ArticleService
import com.example.ssu_blog.user.service.UserService
import com.example.ssu_blog.article.dto.request.ArticleCreateOrUpdateRequest
import com.example.ssu_blog.article.dto.response.ArticleCreateOrUpdateResponse
import com.example.ssu_blog.Exception.ExceptionResponse
import com.example.ssu_blog.article.dto.request.ArticleDeleteRequest
import javax.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes


@RestController
@RequestMapping("api/article")
@Validated
class ArticleController(
    private val userService: UserService,
    private val articleService: ArticleService
) {
    @ResponseBody
    @PostMapping("")
    fun postArticle(
        @Valid @RequestBody request: ArticleCreateOrUpdateRequest
    ): ResponseEntity<Any> {
        val requestAttributes = RequestContextHolder.getRequestAttributes() as ServletRequestAttributes
        val requestURI = requestAttributes.request.requestURI
        val accessUser: UserModel
        try {
            accessUser = userService.matchAccount(request.email, request.password)
        } catch (e: IllegalArgumentException) {
            val exceptionResponse = ExceptionResponse(HttpStatus.UNAUTHORIZED, e.message.toString(), requestURI)
            return ResponseEntity.status(401).body(exceptionResponse)
        }
        val newArticle = Article(request.content, request.title, accessUser)
        val articleResponse = ArticleCreateOrUpdateResponse.from(articleService.post(newArticle), accessUser.email)
        return ResponseEntity.status(200).body(articleResponse)
    }

    @ResponseBody
    @PutMapping("/{articleId}")
    fun updateArticle(
        @PathVariable("articleId") articleId: Long,
        @Valid @RequestBody request: ArticleCreateOrUpdateRequest
    ): ResponseEntity<Any> {
        val requestAttributes = RequestContextHolder.getRequestAttributes() as ServletRequestAttributes
        val requestURI = requestAttributes.request.requestURI
        val accessUser: UserModel
        try {
            accessUser = userService.matchAccount(request.email, request.password)
        } catch (e: IllegalArgumentException) {
            val exceptionResponse = ExceptionResponse(HttpStatus.UNAUTHORIZED, e.message.toString(), requestURI)
            return ResponseEntity.status(401).body(exceptionResponse)
        }
        var updateArticle: Article
        try {
            updateArticle = articleService.getAuthArticle(articleId, accessUser)
            updateArticle.title = request.title
            updateArticle.content = request.content
        } catch (e: NoSuchElementException) {
            val exceptionResponse = ExceptionResponse(HttpStatus.BAD_REQUEST, e.message.toString(), requestURI)
            return ResponseEntity.status(404).body(exceptionResponse)
        } catch (e: IllegalAccessException) {
            val exceptionResponse = ExceptionResponse(HttpStatus.FORBIDDEN, e.message.toString(), requestURI)
            return ResponseEntity.status(403).body(exceptionResponse)
        }
        val articleResponse = ArticleCreateOrUpdateResponse.from(articleService.update(updateArticle), accessUser.email)
        return ResponseEntity.status(200).body(articleResponse)
    }

    @ResponseBody
    @DeleteMapping("/{articleId}")
    fun deleteArticle(
        @PathVariable("articleId") articleId: Long,
        @RequestBody request: ArticleDeleteRequest
    ): ResponseEntity<Any> {
        val requestAttributes = RequestContextHolder.getRequestAttributes() as ServletRequestAttributes
        val requestURI = requestAttributes.request.requestURI
        val accessUser: UserModel
        try {
            accessUser = userService.matchAccount(request.email, request.password)
        } catch (e: IllegalArgumentException) {
            val exceptionResponse = ExceptionResponse(HttpStatus.UNAUTHORIZED, e.message.toString(), requestURI)
            return ResponseEntity.status(401).body(exceptionResponse)
        }
        try {
            articleService.delete(articleId, accessUser)
        } catch (e: NoSuchElementException) {
            val exceptionResponse = ExceptionResponse(HttpStatus.BAD_REQUEST, e.message.toString(), requestURI)
            return ResponseEntity.status(404).body(exceptionResponse)
        } catch (e: IllegalAccessException) {
            val exceptionResponse = ExceptionResponse(HttpStatus.FORBIDDEN, e.message.toString(), requestURI)
            return ResponseEntity.status(403).body(exceptionResponse)
        }
        return ResponseEntity.status(200).body(null)
    }
}