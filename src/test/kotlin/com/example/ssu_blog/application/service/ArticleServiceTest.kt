package com.example.ssu_blog.application.service

import com.example.ssu_blog.adapter.`in`.controller.UserController
import com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity
import com.example.ssu_blog.adapter.out.persistence.entity.UserEntity
import com.example.ssu_blog.adapter.out.persistence.repository.ArticleRepository
import com.example.ssu_blog.adapter.out.persistence.repository.CommentRepository
import org.junit.jupiter.api.Assertions.assertEquals
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
class ArticleServiceTest {

    @Mock
    private lateinit var articleRepository: ArticleRepository

    @Mock
    private lateinit var commentRepository: CommentRepository

    @InjectMocks
    private lateinit var articleService: ArticleService

    @BeforeEach
    fun setUp() {
        articleService = ArticleService(articleRepository, commentRepository)
    }

    @Test
    @DisplayName("게시글 작성 서비스 테스트")
    fun postArticleTest() {
        val newArticle = ArticleEntity("Test Content", "Test Title", UserEntity("test@urssu.com", "password", "Test User"))
        Mockito.`when`(articleRepository.save(newArticle)).thenReturn(newArticle)

        val result = articleService.post(newArticle)

        assertEquals(newArticle, result)
    }

    @Test
    @DisplayName("게시글 삭제 서비스 테스트")
    fun deleteArticleTest() {
        val articleId = 1L
        val accessUser = UserEntity("test@urssu.com", "password", "Test User")
        val articleToDelete = ArticleEntity("Test Content", "Test Title", accessUser)
        Mockito.`when`(articleRepository.findById(articleId)).thenReturn(Optional.of(articleToDelete))

        articleService.delete(articleId, accessUser)

        Mockito.verify(articleRepository, Mockito.times(1)).delete(articleToDelete)
        Mockito.verify(commentRepository, Mockito.times(1)).deleteAllByArticleEntityId(articleToDelete)
    }

    @Test
    @DisplayName("삭제 권한없는 게시글 삭제 서비스 테스트")
    fun deleteArticleAccessDeniedTest() {
        val articleId = 1L
        val accessUser = UserEntity("test@urssu.com", "password", "Test User")
        val articleToDelete = ArticleEntity("Test Content", "Test Title", UserEntity("another@urssu.com", "password", "other User"))
        Mockito.`when`(articleRepository.findById(articleId)).thenReturn(Optional.of(articleToDelete))

        val exception = assertThrows<IllegalAccessException> { articleService.delete(articleId, accessUser) }

        assertEquals("게시글을 수정 할 권한이 없습니다.", exception.message)
    }
}
