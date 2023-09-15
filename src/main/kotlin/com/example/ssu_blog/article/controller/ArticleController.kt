package com.example.ssu_blog.article.controller

import com.example.ssu_blog.article.domain.entity.Article
import com.example.ssu_blog.user.domain.entity.UserModel
import com.example.ssu_blog.article.service.ArticleService
import com.example.ssu_blog.user.service.UserService
import com.example.ssu_blog.article.dto.request.ArticleCreateOrUpdateRequest
import com.example.ssu_blog.article.dto.response.ArticleCreateOrUpdateResponse
import com.example.ssu_blog.Exception.ExceptionResponse
import com.example.ssu_blog.article.dto.request.ArticleDeleteRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/article")
class ArticleController(
    private val userService: UserService,
    private val articleService: ArticleService
) {
    @ResponseBody
    @PostMapping("")
    fun postArticle(@RequestBody request: ArticleCreateOrUpdateRequest): ResponseEntity<Any> {
        val requestURI = "/api/article"
        if(request.title == null || request.title.trim().isEmpty()
            || request.content == null || request.content.trim().isEmpty()) {
            val exceptionResponse = ExceptionResponse(HttpStatus.UNPROCESSABLE_ENTITY, "게시글의 제목과 본문은 공백일 수 없습니다.", requestURI)
            return ResponseEntity.status(422).body(exceptionResponse)
        } // 어노테이션을 사용한 유효성 검사 방식으로 변경할 것
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
    fun updateArticle(@PathVariable("articleId") articleId: Long ,@RequestBody request: ArticleCreateOrUpdateRequest): ResponseEntity<Any> {
        val requestURI = "/api/article/" + articleId.toString()
        if(request.title == null || request.title.trim().isEmpty()
            || request.content == null || request.content.trim().isEmpty()) {
            val exceptionResponse = ExceptionResponse(HttpStatus.UNPROCESSABLE_ENTITY, "게시글의 제목과 본문은 공백일 수 없습니다.", requestURI)
            return ResponseEntity.status(422).body(exceptionResponse)
        } // 어노테이션을 사용한 유효성 검사 방식으로 변경할 것2
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
    fun deleteArticle(@PathVariable("articleId") articleId: Long ,@RequestBody request: ArticleDeleteRequest): ResponseEntity<Any> {
        val requestURI = "/api/article/" + articleId.toString()
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