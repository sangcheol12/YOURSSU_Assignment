package com.example.ssu_blog.application.service

import com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity
import com.example.ssu_blog.adapter.out.persistence.entity.UserEntity
import com.example.ssu_blog.adapter.out.persistence.repository.ArticleRepository
import com.example.ssu_blog.adapter.out.persistence.repository.CommentRepository
import com.example.ssu_blog.utils.UserRoleEnum
import org.junit.jupiter.api.Assertions.assertEquals
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
class ArticleServiceTest {

    @Mock
    private lateinit var articleRepository: ArticleRepository

    @Mock
    private lateinit var commentRepository: CommentRepository

    private lateinit var articleService: ArticleService

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        articleService = ArticleService(articleRepository, commentRepository)
    }

    @Test
    @DisplayName("Given: 새 게시글, When: 게시글을 작성하면, Then: 작성한 게시글이 반환되어야 함")
    fun postArticleTest() {
        // given
        val newArticle = ArticleEntity(
            "Test Content",
            "Test Title",
            UserEntity("test@urssu.com", "password", "Test User", UserRoleEnum.USER)
        )
        Mockito.`when`(articleRepository.save(newArticle)).thenReturn(newArticle)

        // then
        val result = articleService.post(newArticle)

        // when
        assertEquals(newArticle, result)
    }

    @Test
    @DisplayName("Given: 게시글 ID, When: 게시글을 삭제하면, Then: 게시글과 관련된 댓글이 삭제되어야 함")
    fun deleteArticleTest() {
        // given
        val articleId = 1L
        val accessUser = UserEntity("test@urssu.com", "password", "Test User", UserRoleEnum.USER)
        val articleToDelete = ArticleEntity("Test Content", "Test Title", accessUser)
        Mockito.`when`(articleRepository.findById(articleId)).thenReturn(Optional.of(articleToDelete))

        // when
        articleService.delete(articleId, accessUser)

        // then
        Mockito.verify(articleRepository, Mockito.times(1)).delete(articleToDelete)
        Mockito.verify(commentRepository, Mockito.times(1)).deleteAllByArticleEntityId(articleToDelete)
    }

    @Test
    @DisplayName("Given: 삭제 권한이 없는 게시글, When: 게시글을 삭제하면, Then: IllegalAccessException이 발생해야 함")
    fun deleteArticleAccessDeniedTest() {
        // Given
        val articleId = 1L
        val accessUser = UserEntity("test@urssu.com", "password", "Test User", UserRoleEnum.USER)
        val articleToDelete = ArticleEntity(
            "Test Content",
            "Test Title",
            UserEntity("another@urssu.com", "password", "other User", UserRoleEnum.USER)
        )
        Mockito.`when`(articleRepository.findById(articleId)).thenReturn(Optional.of(articleToDelete))

        // When
        val exception = assertThrows<IllegalAccessException> { articleService.delete(articleId, accessUser) }

        // Then
        assertEquals("게시글을 수정 할 권한이 없습니다.", exception.message)
    }
}
