package com.example.ssu_blog.adapter.`in`.controller

import com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity
import com.example.ssu_blog.application.service.ArticleService
import com.example.ssu_blog.application.service.UserService
import com.example.ssu_blog.adapter.`in`.dto.request.ArticleCreateOrUpdateRequest
import com.example.ssu_blog.adapter.`in`.dto.response.ArticleCreateOrUpdateResponse
import com.example.ssu_blog.adapter.`in`.dto.request.ArticleDeleteRequest
import javax.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

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
        val accessUser = userService.matchAccount(request.email, request.password)
        val newArticleEntity = ArticleEntity(request.content, request.title, accessUser)
        val articleResponse = ArticleCreateOrUpdateResponse.from(articleService.post(newArticleEntity), accessUser.email)
        return ResponseEntity.status(200).body(articleResponse)
    }

    @ResponseBody
    @PutMapping("/{articleId}")
    fun updateArticle(
        @PathVariable("articleId") articleId: Long,
        @Valid @RequestBody request: ArticleCreateOrUpdateRequest
    ): ResponseEntity<Any> {
        val accessUser = userService.matchAccount(request.email, request.password)
        var updateArticleEntity = articleService.getAuthArticle(articleId, accessUser)
        updateArticleEntity.updateInfo(request.title, request.content, LocalDateTime.now())
        val articleResponse = ArticleCreateOrUpdateResponse.from(articleService.post(updateArticleEntity), accessUser.email)
        return ResponseEntity.status(200).body(articleResponse)
    }

    @ResponseBody
    @DeleteMapping("/{articleId}")
    fun deleteArticle(
        @PathVariable("articleId") articleId: Long,
        @Valid @RequestBody request: ArticleDeleteRequest
    ): ResponseEntity<Any> {
        val accessUser = userService.matchAccount(request.email, request.password)
        articleService.delete(articleId, accessUser)
        return ResponseEntity.status(200).body(null)
    }
}