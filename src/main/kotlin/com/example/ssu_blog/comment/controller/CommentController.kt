package com.example.ssu_blog.comment.controller

import com.example.ssu_blog.Exception.ExceptionResponse
import com.example.ssu_blog.article.domain.entity.Article
import com.example.ssu_blog.article.service.ArticleService
import com.example.ssu_blog.comment.domain.entity.Comment
import com.example.ssu_blog.comment.dto.request.CommentCreateOrUpdateRequest
import com.example.ssu_blog.comment.dto.request.CommentDeleteRequest
import com.example.ssu_blog.comment.dto.response.CommentCreateOrUpdateResponse
import com.example.ssu_blog.comment.service.CommentService
import com.example.ssu_blog.user.domain.entity.UserModel
import com.example.ssu_blog.user.service.UserService
import javax.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

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
    fun postComment(
        @PathVariable("articleId") articleId: Long,
        @Valid @RequestBody request: CommentCreateOrUpdateRequest
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
        val curArticle: Article
        try {
            curArticle = articleService.getArticle(articleId)
        } catch (e: NoSuchElementException) {
            val exceptionResponse = ExceptionResponse(HttpStatus.BAD_REQUEST, e.message.toString(), requestURI)
            return ResponseEntity.status(404).body(exceptionResponse)
        }
        val newComment = Comment(request.content, curArticle, accessUser)
        val commentResponse = CommentCreateOrUpdateResponse.from(commentService.post(newComment), request.email)
        return ResponseEntity.status(200).body(commentResponse)
    }

    @ResponseBody
    @PutMapping("/{articleId}/{commentId}")
    fun updateComment(
        @PathVariable("articleId") articleId: Long,
        @PathVariable("commentId") commentId: Long,
        @Valid @RequestBody request: CommentCreateOrUpdateRequest
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
        val curArticle: Article
        val updateComment: Comment
        try {
            curArticle = articleService.getArticle(articleId)
            updateComment = commentService.getAuthComment(commentId, accessUser, curArticle)
            updateComment.content = request.content
        } catch (e: NoSuchElementException) {
            val exceptionResponse = ExceptionResponse(HttpStatus.BAD_REQUEST, e.message.toString(), requestURI)
            return ResponseEntity.status(404).body(exceptionResponse)
        } catch (e: IllegalAccessException) {
            val exceptionResponse = ExceptionResponse(HttpStatus.FORBIDDEN, e.message.toString(), requestURI)
            return ResponseEntity.status(403).body(exceptionResponse)
        }
        val commentResponse = CommentCreateOrUpdateResponse.from(commentService.update(updateComment), request.email)
        return ResponseEntity.status(200).body(commentResponse)
    }

    @ResponseBody
    @DeleteMapping("/{articleId}/{commentId}")
    fun deleteComment(
        @PathVariable("articleId") articleId: Long,
        @PathVariable("commentId") commentId: Long,
        @RequestBody request: CommentDeleteRequest
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
        val curArticle: Article
        try {
            curArticle = articleService.getArticle(articleId)
            commentService.delete(commentId, accessUser, curArticle)
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