package com.example.ssu_blog.adapter.`in`.controller

import com.example.ssu_blog.Exception.ExceptionResponse
import com.example.ssu_blog.application.service.ArticleService
import com.example.ssu_blog.adapter.out.persistence.entity.CommentEntity
import com.example.ssu_blog.adapter.`in`.dto.request.CommentCreateOrUpdateRequest
import com.example.ssu_blog.adapter.`in`.dto.response.CommentCreateOrUpdateResponse
import com.example.ssu_blog.annotation.Auth
import com.example.ssu_blog.application.service.CommentService
import com.example.ssu_blog.application.service.UserService
import com.example.ssu_blog.auth.AuthInfo
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import javax.validation.Valid
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("api/comment")
@Validated
@Tag(name = "댓글 Api", description = "댓글 등록, 수정 삭제")
class CommentController(
    private val userService: UserService,
    private val articleService: ArticleService,
    private val commentService: CommentService
) {
    @Operation(summary = "댓글 등록", description = "댓글 본문을 받아 댓글 등록", tags = ["댓글 Api"],
        responses = [
            ApiResponse(responseCode = "200", description = "댓글 등록 성공", content = [Content(schema = Schema(implementation = CommentCreateOrUpdateResponse::class))]),
            ApiResponse(responseCode = "404", description = "게사글이 존재하지 않거나 잘못 된 접근", content = [Content(schema = Schema(implementation = ExceptionResponse::class))])
        ])
    @ResponseBody
    @PostMapping("/{articleId}")
    @ResponseStatus(value = HttpStatus.OK)
    fun postComment(
        @PathVariable("articleId") articleId: Long,
        @Auth authInfo: AuthInfo,
        @Valid @RequestBody request: CommentCreateOrUpdateRequest
    ): CommentCreateOrUpdateResponse {
        val accessUser = userService.findOneByEmail(authInfo.email)
        val curArticleEntity = articleService.getArticle(articleId)
        val newCommentEntity = CommentEntity(request.content, curArticleEntity, accessUser)
        return CommentCreateOrUpdateResponse.from(commentService.post(newCommentEntity), accessUser.email)
    }

    @Operation(summary = "댓글 수정", description = "변경 될 댓글 내용을 받아 Path로 들어온 댓글 수정", tags = ["댓글 Api"],
        responses = [
            ApiResponse(responseCode = "200", description = "댓글 수정 성공", content = [Content(schema = Schema(implementation = CommentCreateOrUpdateResponse::class))]),
            ApiResponse(responseCode = "404", description = "댓글이 존재하지 않거나 잘못 된 접근", content = [Content(schema = Schema(implementation = ExceptionResponse::class))]),
            ApiResponse(responseCode = "403", description = "댓글을 수정 할 권한이 없음", content = [Content(schema = Schema(implementation = ExceptionResponse::class))])
        ])
    @ResponseBody
    @PutMapping("/{articleId}/{commentId}")
    @ResponseStatus(value = HttpStatus.OK)
    fun updateComment(
        @PathVariable("articleId") articleId: Long,
        @PathVariable("commentId") commentId: Long,
        @Auth authInfo: AuthInfo,
        @Valid @RequestBody request: CommentCreateOrUpdateRequest
    ): CommentCreateOrUpdateResponse {
        val accessUser = userService.findOneByEmail(authInfo.email)
        val curArticleEntity = articleService.getArticle(articleId)
        val updateCommentEntity = commentService.getAuthComment(commentId, accessUser, curArticleEntity)
        updateCommentEntity.updateInfo(request.content, LocalDateTime.now())
        return CommentCreateOrUpdateResponse.from(commentService.update(updateCommentEntity), accessUser.email)
    }
    @Operation(summary = "댓글 삭제", description = "Path로 들어온 게시글 밑에 댓글 삭제", tags = ["댓글 Api"],
        responses = [
            ApiResponse(responseCode = "200", description = "댓글 삭제 성공"),
            ApiResponse(responseCode = "404", description = "댓글이 존재하지 않거나 잘못 된 접근", content = [Content(schema = Schema(implementation = ExceptionResponse::class))]),
            ApiResponse(responseCode = "403", description = "댓글을 삭제 할 권한이 없음", content = [Content(schema = Schema(implementation = ExceptionResponse::class))])
        ])
    @ResponseBody
    @DeleteMapping("/{articleId}/{commentId}")
    @ResponseStatus(value = HttpStatus.OK)
    fun deleteComment(
        @PathVariable("articleId") articleId: Long,
        @PathVariable("commentId") commentId: Long,
        @Auth authInfo: AuthInfo
    ) {
        val accessUser = userService.findOneByEmail(authInfo.email)
        val curArticleEntity = articleService.getArticle(articleId)
        commentService.delete(commentId, accessUser, curArticleEntity)
    }
}