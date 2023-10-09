package com.example.ssu_blog.application.service

import com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity
import com.example.ssu_blog.adapter.out.persistence.entity.CommentEntity
import com.example.ssu_blog.adapter.out.persistence.entity.UserEntity
import com.example.ssu_blog.adapter.out.persistence.repository.ArticleRepository
import com.example.ssu_blog.adapter.out.persistence.repository.CommentRepository
import com.example.ssu_blog.adapter.out.persistence.repository.UserRepository
import com.example.ssu_blog.auth.JwtTokenProvider
import org.hibernate.validator.internal.util.Contracts.assertNotNull
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
import org.springframework.security.crypto.password.PasswordEncoder
import javax.transaction.Transactional

@SpringBootTest
@Transactional
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

    @InjectMocks
    private lateinit var userService: UserService

    @BeforeEach
    fun setUp() {
        userService = UserService(userRepository ,articleRepository, commentRepository, jwtTokenProvider, encoder)

        val user = UserEntity("leave@urssu.com", "password", "Tester", "USER")
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
    @DisplayName("회원 가입 서비스 테스트")
    fun joinTest() {
        val user = UserEntity("test@urssu.com", "password", "Test User", "USER")

        Mockito.`when`(userRepository.findByEmail(user.email)).thenReturn(null)
        Mockito.`when`(userRepository.save(user)).thenReturn(user)

        val result = userService.join(user)

        assertNotNull(result)
        assertEquals(user, result)

        Mockito.verify(userRepository, Mockito.times(1)).findByEmail(user.email)
        Mockito.verify(userRepository, Mockito.times(1)).save(user)
    }

    @Test
    @DisplayName("회원 중복 서비스 테스트")
    fun joinDuplicateUserTest() {
        val user = UserEntity("test@urssu.com", "password", "Test User", "USER")

        Mockito.`when`(userRepository.findByEmail(user.email)).thenReturn(user)

        val exception = assertThrows<IllegalStateException> { userService.join(user) }

        Mockito.verify(userRepository, Mockito.times(1)).findByEmail(user.email)
        Mockito.verify(userRepository, Mockito.never()).save(user)
        assertEquals("이미 존재하는 회원입니다.", exception.message)
    }

    @Test
    @DisplayName("회원 탈퇴 서비스 테스트")
    fun leaveTest() {
        val user = userRepository.findByEmail("leave@urssu.com")

        user?.let { safeUser ->
            Mockito.`when`(userRepository.findByEmail(safeUser.email)).thenReturn(user)

            userService.leave(safeUser)
            Mockito.verify(userRepository, Mockito.times(1)).delete(safeUser)
            Mockito.verify(articleRepository, Mockito.times(1)).deleteAllByUserEntityId(safeUser)
        } ?: run {
        }
    }
}