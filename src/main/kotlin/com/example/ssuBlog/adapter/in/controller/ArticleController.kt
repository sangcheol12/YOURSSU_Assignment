package com.example.ssuBlog.adapter.`in`.controller

import com.example.ssuBlog.Exception.ExceptionResponse
import com.example.ssuBlog.adapter.`in`.dto.request.ArticleCreateOrUpdateRequest
import com.example.ssuBlog.adapter.`in`.dto.response.ArticleCreateOrUpdateResponse
import com.example.ssuBlog.adapter.out.persistence.entity.ArticleEntity
import com.example.ssuBlog.annotation.Auth
import com.example.ssuBlog.application.service.ArticleService
import com.example.ssuBlog.application.service.UserService
import com.example.ssuBlog.auth.AuthInfo
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import javax.validation.Valid

@RestController
@RequestMapping("api/article")
@Validated
@Tag(name = "게시글 Api", description = "게시글 등록, 수정 삭제")
class ArticleController(
    private val userService: UserService,
    private val articleService: ArticleService
) {
    @Operation(
        summary = "게시글 등록",
        description = "게시글 제목과 본문을 받아 게시글 등록",
        tags = ["게시글 Api"],
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "게시글 등록 성공",
                content = [Content(schema = Schema(implementation = ArticleCreateOrUpdateResponse::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "잘못 된 접근",
                content = [Content(schema = Schema(implementation = ExceptionResponse::class))]
            )
        ]
    )
    @ResponseBody
    @PostMapping("")
    @ResponseStatus(value = HttpStatus.OK)
    fun postArticle(
        @Auth authInfo: AuthInfo,
        @Valid @RequestBody
        request: ArticleCreateOrUpdateRequest
    ): ArticleCreateOrUpdateResponse {
        val accessUser = userService.findOneByEmail(authInfo.email)
        val newArticleEntity = ArticleEntity(request.content, request.title, accessUser)
        return ArticleCreateOrUpdateResponse.from(articleService.post(newArticleEntity), accessUser.email)
    }

    @Operation(
        summary = "게시글 수정",
        description = "변경 될 게시글 제목과 본문을 받아 Path로 들어온 게시글 수정",
        tags = ["게시글 Api"],
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "게시글 수정 성공",
                content = [Content(schema = Schema(implementation = ArticleCreateOrUpdateResponse::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "게시글이 존재하지 않거나 잘못 된 접근",
                content = [Content(schema = Schema(implementation = ExceptionResponse::class))]
            ),
            ApiResponse(
                responseCode = "403",
                description = "게시글을 수정 할 권한이 없음",
                content = [Content(schema = Schema(implementation = ExceptionResponse::class))]
            )
        ]
    )
    @ResponseBody
    @PutMapping("/{articleId}")
    @ResponseStatus(value = HttpStatus.OK)
    fun updateArticle(
        @PathVariable("articleId") articleId: Long,
        @Auth authInfo: AuthInfo,
        @Valid @RequestBody
        request: ArticleCreateOrUpdateRequest
    ): ArticleCreateOrUpdateResponse {
        val accessUser = userService.findOneByEmail(authInfo.email)
        var updateArticleEntity = articleService.getAuthArticle(articleId, accessUser)
        updateArticleEntity.updateInfo(request.title, request.content, LocalDateTime.now())
        return ArticleCreateOrUpdateResponse.from(articleService.post(updateArticleEntity), accessUser.email)
    }

    @Operation(
        summary = "게시글 삭제",
        description = "Path로 들어온 게시글 삭제",
        tags = ["게시글 Api"],
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "게시글 수정 성공",
                content = [Content(schema = Schema(implementation = ArticleCreateOrUpdateResponse::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "게시글이 존재하지 않거나 잘못 된 접근",
                content = [Content(schema = Schema(implementation = ExceptionResponse::class))]
            ),
            ApiResponse(
                responseCode = "403",
                description = "게시글을 삭제 할 권한이 없음",
                content = [Content(schema = Schema(implementation = ExceptionResponse::class))]
            )
        ]
    )
    @ResponseBody
    @DeleteMapping("/{articleId}")
    @ResponseStatus(value = HttpStatus.OK)
    fun deleteArticle(
        @PathVariable("articleId") articleId: Long,
        @Auth authInfo: AuthInfo
    ) {
        val accessUser = userService.findOneByEmail(authInfo.email)
        articleService.delete(articleId, accessUser)
    }
}
