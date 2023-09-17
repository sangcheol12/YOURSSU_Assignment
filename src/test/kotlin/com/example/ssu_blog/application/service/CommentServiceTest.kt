package com.example.ssu_blog.application.service

import com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity
import com.example.ssu_blog.adapter.out.persistence.entity.CommentEntity
import com.example.ssu_blog.adapter.out.persistence.entity.UserEntity
import com.example.ssu_blog.adapter.out.persistence.repository.CommentRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.boot.test.context.SpringBootTest
import java.util.*
import javax.transaction.Transactional

@SpringBootTest
@Transactional
@ExtendWith(MockitoExtension::class)
class CommentServiceTest {
    @InjectMocks
    private lateinit var commentService: CommentService
    @Mock
    private lateinit var commentRepository: CommentRepository

    @BeforeEach
    fun setUp() {
        commentService = CommentService(commentRepository)
    }

    @Test
    @DisplayName("댓글 추가 서비스 테스트")
    fun postCommentTest() {
        val user = UserEntity("test@urssu.com", "password", "Test User")
        val article = ArticleEntity("Test Content", "Test Title", user)
        val comment = CommentEntity("Test Comment", article, user)

        Mockito.`when`(commentRepository.save(comment)).thenReturn(comment)

        val savedComment = commentService.post(comment)

        assertNotNull(savedComment)
        assertEquals(comment.content, savedComment.content)
    }

    @Test
    @DisplayName("댓글 삭제 서비스 테스트")
    fun deleteCommentTest() {
        val user = UserEntity("test@urssu.com", "password", "Test User")
        val article = ArticleEntity("Test Content", "Test Title", user)
        val commentIdToDelete = 1L
        val comment = CommentEntity("Test Comment", article, user)

        Mockito.`when`(commentRepository.findById(commentIdToDelete)).thenReturn(Optional.of(comment))

        commentService.delete(commentIdToDelete, user, article)

        Mockito.verify(commentRepository, Mockito.times(1)).delete(comment)
    }

    @Test
    @DisplayName("삭제 권한없는 댓글 삭제 서비스 테스트")
    fun deleteCommentWithoutPermissionTest() {
        val user = UserEntity("test@urssu.com", "password", "Test User")
        val article = ArticleEntity("Test Content", "Test Title", user)
        val commentIdToDelete = 1L // 삭제할 댓글의 ID
        val anotherUser = UserEntity("other@urssu.com", "password", "OtherUser")
        val comment = CommentEntity("Test Comment", article, anotherUser)

        Mockito.`when`(commentRepository.findById(commentIdToDelete)).thenReturn(Optional.of(comment))

        val exception = assertThrows<IllegalAccessException> { commentService.delete(commentIdToDelete, user, article) }

        assertEquals("댓글을 수정 할 권한이 없습니다.", exception.message)
    }
}