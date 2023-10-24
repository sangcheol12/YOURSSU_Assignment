package com.example.ssu_blog.adapter.`in`.controller

import com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity
import com.example.ssu_blog.application.service.ArticleService
import com.example.ssu_blog.application.service.UserService
import com.example.ssu_blog.adapter.`in`.dto.request.ArticleCreateOrUpdateRequest
import com.example.ssu_blog.adapter.`in`.dto.response.ArticleCreateOrUpdateResponse
import com.example.ssu_blog.annotation.Auth
import com.example.ssu_blog.auth.AuthInfo
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
@Validated
class ArticleController(
    private val userService: UserService,
    private val articleService: ArticleService
) {
    @ResponseBody
    @PostMapping("")
    @ResponseStatus(value = HttpStatus.OK)
    fun postArticle(
        @Auth authInfo: AuthInfo,
        @Valid @RequestBody request: ArticleCreateOrUpdateRequest
    ): ArticleCreateOrUpdateResponse {
        val accessUser = userService.findOneByEmail("sangchepa1@urssu.com")
        val newArticleEntity = ArticleEntity(request.content, request.title, accessUser)
        return ArticleCreateOrUpdateResponse.from(articleService.post(newArticleEntity), accessUser.email)
    }

    @ResponseBody
    @PutMapping("/{articleId}")
    @ResponseStatus(value = HttpStatus.OK)
    fun updateArticle(
        @PathVariable("articleId") articleId: Long,
        @Auth authInfo: AuthInfo,
        @Valid @RequestBody request: ArticleCreateOrUpdateRequest
    ): ArticleCreateOrUpdateResponse {
        val accessUser = userService.findOneByEmail("sangchepa1@urssu.com")
        var updateArticleEntity = articleService.getAuthArticle(articleId, accessUser)
        updateArticleEntity.updateInfo(request.title, request.content, LocalDateTime.now())
        return ArticleCreateOrUpdateResponse.from(articleService.post(updateArticleEntity), accessUser.email)
    }

    @ResponseBody
    @DeleteMapping("/{articleId}")
    @ResponseStatus(value = HttpStatus.OK)
    fun deleteArticle(
        @PathVariable("articleId") articleId: Long,
        @Auth authInfo: AuthInfo
    ) {
        val accessUser = userService.findOneByEmail("sangchepa1@urssu.com")
        articleService.delete(articleId, accessUser)
    }
}