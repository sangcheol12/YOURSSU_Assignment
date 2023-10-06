package com.example.ssu_blog.adapter.`in`.controller

import com.example.ssu_blog.application.service.ArticleService
import com.example.ssu_blog.adapter.out.persistence.entity.CommentEntity
import com.example.ssu_blog.adapter.`in`.dto.request.CommentCreateOrUpdateRequest
import com.example.ssu_blog.adapter.`in`.dto.request.CommentDeleteRequest
import com.example.ssu_blog.adapter.`in`.dto.response.CommentCreateOrUpdateResponse
import com.example.ssu_blog.application.service.CommentService
import com.example.ssu_blog.application.service.UserService
import org.springframework.http.HttpStatus
import javax.validation.Valid
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("api/comment")
@Validated
class CommentController(
    private val userService: UserService,
    private val articleService: ArticleService,
    private val commentService: CommentService
) {
    @ResponseBody
    @PostMapping("/{articleId}")
    @ResponseStatus(value = HttpStatus.OK)
    fun postComment(
        @PathVariable("articleId") articleId: Long,
        @Valid @RequestBody request: CommentCreateOrUpdateRequest
    ): CommentCreateOrUpdateResponse {
        val accessUser = userService.matchAccount(request.email, request.password)
        val curArticleEntity = articleService.getArticle(articleId)
        val newCommentEntity = CommentEntity(request.content, curArticleEntity, accessUser)
        return CommentCreateOrUpdateResponse.from(commentService.post(newCommentEntity), request.email)
    }

    @ResponseBody
    @PutMapping("/{articleId}/{commentId}")
    @ResponseStatus(value = HttpStatus.OK)
    fun updateComment(
        @PathVariable("articleId") articleId: Long,
        @PathVariable("commentId") commentId: Long,
        @Valid @RequestBody request: CommentCreateOrUpdateRequest
    ): CommentCreateOrUpdateResponse {
        val accessUser = userService.matchAccount(request.email, request.password)
        val curArticleEntity = articleService.getArticle(articleId)
        val updateCommentEntity = commentService.getAuthComment(commentId, accessUser, curArticleEntity)
        updateCommentEntity.updateInfo(request.content, LocalDateTime.now())
        return CommentCreateOrUpdateResponse.from(commentService.update(updateCommentEntity), request.email)
    }

    @ResponseBody
    @DeleteMapping("/{articleId}/{commentId}")
    @ResponseStatus(value = HttpStatus.OK)
    fun deleteComment(
        @PathVariable("articleId") articleId: Long,
        @PathVariable("commentId") commentId: Long,
        @Valid @RequestBody request: CommentDeleteRequest
    ) {
        val accessUser = userService.matchAccount(request.email, request.password)
        val curArticleEntity = articleService.getArticle(articleId)
        commentService.delete(commentId, accessUser, curArticleEntity)
    }
}