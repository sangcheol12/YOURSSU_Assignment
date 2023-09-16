package com.example.ssu_blog.application.service

import com.example.ssu_blog.adapter.out.persistence.entity.UserEntity
import com.example.ssu_blog.adapter.out.persistence.repository.ArticleRepository
import com.example.ssu_blog.adapter.out.persistence.repository.CommentRepository
import com.example.ssu_blog.adapter.out.persistence.repository.UserRepository
import org.hibernate.validator.internal.util.Contracts.assertNotNull
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
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

    @InjectMocks
    private lateinit var userService: UserService

    @BeforeEach
    fun setUp() {
        userService = UserService(userRepository ,articleRepository, commentRepository, encoder)
    }

    @Test
    fun joinTest() {
        val user = UserEntity("test@urssu.com", "password", "Test User")

        Mockito.`when`(userRepository.findByEmail(user.email)).thenReturn(null)
        Mockito.`when`(userRepository.save(user)).thenReturn(user)

        val result = userService.join(user)

        assertNotNull(result)
        assertEquals(user, result)

        Mockito.verify(userRepository, Mockito.times(1)).findByEmail(user.email)
        Mockito.verify(userRepository, Mockito.times(1)).save(user)
    }

    @Test
    fun joinDuplicateUserTest() {
        val user = UserEntity("test@urssu.com", "password", "Test User")

        Mockito.`when`(userRepository.findByEmail(user.email)).thenReturn(user)

        assertThrows<IllegalStateException> { userService.join(user) }

        Mockito.verify(userRepository, Mockito.times(1)).findByEmail(user.email)
        Mockito.verify(userRepository, Mockito.never()).save(user)
    }
}