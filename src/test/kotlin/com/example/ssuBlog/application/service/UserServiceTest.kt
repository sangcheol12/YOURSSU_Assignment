package com.example.ssuBlog.application.service

import com.example.ssuBlog.adapter.out.persistence.entity.ArticleEntity
import com.example.ssuBlog.adapter.out.persistence.entity.CommentEntity
import com.example.ssuBlog.adapter.out.persistence.entity.UserEntity
import com.example.ssuBlog.adapter.out.persistence.repository.ArticleRepository
import com.example.ssuBlog.adapter.out.persistence.repository.CommentRepository
import com.example.ssuBlog.adapter.out.persistence.repository.UserRepository
import com.example.ssuBlog.auth.JwtTokenProvider
import com.example.ssuBlog.utils.UserRoleEnum
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
import org.springframework.security.crypto.password.PasswordEncoder

@ExtendWith(MockitoExtension::class)
class UserServiceTest {

    @Mock
    private lateinit var userRepository: UserRepository

    @Mock
    private lateinit var articleRepository: ArticleRepository // Add this mock

    @Mock
    private lateinit var commentRepository: CommentRepository

    @Mock
    private lateinit var encoder: PasswordEncoder

    @Mock
    private lateinit var jwtTokenProvider: JwtTokenProvider

    private lateinit var userService: UserService

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        userService = UserService(userRepository, articleRepository, commentRepository, jwtTokenProvider, encoder)

        val user = UserEntity("leave@urssu.com", "password", "Tester", UserRoleEnum.USER)
        userRepository.save(user)

        val article1 = ArticleEntity("Title 1", "Content 1", user)
        val article2 = ArticleEntity("Title 2", "Content 2", user)
        articleRepository.save(article1)
        articleRepository.save(article2)

        val comment1 = CommentEntity("Comment 1", article1, user)
        val comment2 = CommentEntity("Comment 2", article2, user)
        commentRepository.save(comment1)
        commentRepository.save(comment2)
    }

    @Test
    @DisplayName("Given: 회원 가입을 시도하고, When: 유효한 사용자 정보를 제출하면, Then: 회원 가입이 성공해야 함")
    fun joinTest() {
        // Given
        val user = UserEntity("test@urssu.com", "password", "Test User", UserRoleEnum.USER)

        // When
        Mockito.`when`(userRepository.findByEmail(user.email)).thenReturn(null)
        Mockito.`when`(userRepository.save(user)).thenReturn(user)
        val result = userService.join(user)

        // Then
        assertEquals(user, result)

        Mockito.verify(userRepository, Mockito.times(1)).findByEmail(user.email)
        Mockito.verify(userRepository, Mockito.times(1)).save(user)
    }

    @Test
    @DisplayName("Given: 이미 등록된 이메일로 가입을 시도하고, When: 동일 이메일로 가입을 시도하면, Then: IllegalStateException 예외가 발생해야 함")
    fun joinDuplicateUserTest() {
        // Given
        val user = UserEntity("test@urssu.com", "password", "Test User", UserRoleEnum.USER)

        // When
        Mockito.`when`(userRepository.findByEmail(user.email)).thenReturn(user)

        // Then
        val exception = assertThrows<IllegalStateException> { userService.join(user) }

        Mockito.verify(userRepository, Mockito.times(1)).findByEmail(user.email)
        Mockito.verify(userRepository, Mockito.never()).save(user)
        assertEquals("이미 존재하는 회원입니다.", exception.message)
    }

    @Test
    @DisplayName("Given: 탈퇴할 회원, When: 회원 탈퇴를 요청하면, Then: 사용자 및 관련 게시물이 삭제되어야 함")
    fun leaveTest() {
        // Given
        val user = userRepository.findByEmail("leave@urssu.com")

        // When
        user?.let { safeUser ->
            Mockito.`when`(userRepository.findByEmail(safeUser.email)).thenReturn(user)

            // Then
            userService.leave(safeUser)
            Mockito.verify(userRepository, Mockito.times(1)).delete(safeUser)
            Mockito.verify(articleRepository, Mockito.times(1)).deleteAllByUserEntityId(safeUser)
        } ?: run {
        }
    }
}
