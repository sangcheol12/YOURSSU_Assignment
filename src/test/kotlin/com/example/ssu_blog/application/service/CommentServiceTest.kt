package com.example.ssu_blog.application.service

import com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity
import com.example.ssu_blog.adapter.out.persistence.entity.CommentEntity
import com.example.ssu_blog.adapter.out.persistence.entity.UserEntity
import com.example.ssu_blog.adapter.out.persistence.repository.CommentRepository
import com.example.ssu_blog.utils.UserRoleEnum
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
class CommentServiceTest {
    private lateinit var commentService: CommentService

    @Mock
    private lateinit var commentRepository: CommentRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        commentService = CommentService(commentRepository)
    }

    @Test
    @DisplayName("Given: 유저, 게시글, When: 댓글을 추가하면, Then: 추가된 댓글이 반환되어야 함")
    fun postCommentTest() {
        // Given
        val articleToDelete = ArticleEntity(
            "Test Content",
            "Test Title",
            UserEntity("another@urssu.com", "password", "other User", UserRoleEnum.USER)
        )
        val user = UserEntity("test@urssu.com", "password", "Test User", UserRoleEnum.USER)
        val article = ArticleEntity("Test Content", "Test Title", user)
        val comment = CommentEntity("Test Comment", article, user)

        // When
        Mockito.`when`(commentRepository.save(comment)).thenReturn(comment)
        val savedComment = commentService.post(comment)

        // Then
        assertNotNull(savedComment)
        assertEquals(comment.content, savedComment.content)
    }

    @Test
    @DisplayName("Given: 유저, 게시글, 댓글, When: 댓글 삭제하면, Then: 삭제된 댓글 반환되어야 함")
    fun deleteCommentTest() {
        // Given
        val user = UserEntity("test@urssu.com", "password", "Test User", UserRoleEnum.USER)
        val article = ArticleEntity("Test Content", "Test Title", user)
        val commentIdToDelete = 1L
        val comment = CommentEntity("Test Comment", article, user)

        // When
        Mockito.`when`(commentRepository.findById(commentIdToDelete)).thenReturn(Optional.of(comment))
        commentService.delete(commentIdToDelete, user, article)

        // Then
        Mockito.verify(commentRepository, Mockito.times(1)).delete(comment)
    }

    @Test
    @DisplayName("Given: 유저, 게시글, 댓글, When: 삭제 권한 없는 댓글 삭제하면, Then: IllegalAccessException이 발생해야 함")
    fun deleteCommentWithoutPermissionTest() {
        // Given
        val user = UserEntity("test@urssu.com", "password", "Test User", UserRoleEnum.USER)
        val article = ArticleEntity("Test Content", "Test Title", user)
        val commentIdToDelete = 1L // 삭제할 댓글의 ID
        val anotherUser = UserEntity("other@urssu.com", "password", "OtherUser", UserRoleEnum.USER)
        val comment = CommentEntity("Test Comment", article, anotherUser)

        // When
        Mockito.`when`(commentRepository.findById(commentIdToDelete)).thenReturn(Optional.of(comment))
        val exception = assertThrows<IllegalAccessException> { commentService.delete(commentIdToDelete, user, article) }

        // Then
        assertEquals("댓글을 수정 할 권한이 없습니다.", exception.message)
    }
}
