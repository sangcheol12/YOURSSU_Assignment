package com.example.ssu_blog.adapter.`in`.controller

import com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity
import com.example.ssu_blog.application.service.ArticleService
import com.example.ssu_blog.application.service.UserService
import com.example.ssu_blog.adapter.`in`.dto.request.ArticleCreateOrUpdateRequest
import com.example.ssu_blog.adapter.`in`.dto.response.ArticleCreateOrUpdateResponse
import org.springframework.http.HttpStatus
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import javax.validation.Valid
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("api/article")
@PreAuthorize("hasAuthority(('USER'))")
@Validated
class ArticleController(
    private val userService: UserService,
    private val articleService: ArticleService
) {
    @ResponseBody
    @PostMapping("")
    @ResponseStatus(value = HttpStatus.OK)
    fun postArticle(
        @AuthenticationPrincipal userDetails: UserDetails,
        @Valid @RequestBody request: ArticleCreateOrUpdateRequest
    ): ArticleCreateOrUpdateResponse {
        val accessUser = userService.findOneByEmail(userDetails.username)
        val newArticleEntity = ArticleEntity(request.content, request.title, accessUser)
        return ArticleCreateOrUpdateResponse.from(articleService.post(newArticleEntity), accessUser.email)
    }

    @ResponseBody
    @PutMapping("/{articleId}")
    @ResponseStatus(value = HttpStatus.OK)
    fun updateArticle(
        @AuthenticationPrincipal userDetails: UserDetails,
        @PathVariable("articleId") articleId: Long,
        @Valid @RequestBody request: ArticleCreateOrUpdateRequest
    ): ArticleCreateOrUpdateResponse {
        val accessUser = userService.findOneByEmail(userDetails.username)
        var updateArticleEntity = articleService.getAuthArticle(articleId, accessUser)
        updateArticleEntity.updateInfo(request.title, request.content, LocalDateTime.now())
        return ArticleCreateOrUpdateResponse.from(articleService.post(updateArticleEntity), accessUser.email)
    }

    @ResponseBody
    @DeleteMapping("/{articleId}")
    @ResponseStatus(value = HttpStatus.OK)
    fun deleteArticle(
        @AuthenticationPrincipal userDetails: UserDetails,
        @PathVariable("articleId") articleId: Long
    ) {
        val accessUser = userService.findOneByEmail(userDetails.username)
        articleService.delete(articleId, accessUser)
    }
}