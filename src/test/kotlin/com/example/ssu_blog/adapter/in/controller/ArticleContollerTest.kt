package com.example.ssu_blog.adapter.`in`.controller

import com.example.ssu_blog.adapter.`in`.dto.request.ArticleCreateOrUpdateRequest
import com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity
import com.example.ssu_blog.adapter.out.persistence.entity.UserEntity
import com.example.ssu_blog.application.service.ArticleService
import com.example.ssu_blog.application.service.UserService
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.ws.rs.core.MediaType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import javax.transaction.Transactional

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ArticleContollerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Mock
    private lateinit var userService: UserService

    @Mock
    private lateinit var articleService: ArticleService

    @Mock
    private lateinit var passwordEncoder: PasswordEncoder

    private lateinit var user: UserEntity

    @BeforeEach
    fun setUp() {
        user = UserEntity("test1@urssu.com", "password", "testuser")
        userService.join(user)
    }

    @Test
    fun postArticleTest() {
        val request = ArticleCreateOrUpdateRequest("test1@urssu.com", "password", "New Title", "New Content")

        Mockito.`when`(userService.matchAccount(request.email, request.password)).thenReturn(user)

        val newArticle = ArticleEntity(request.content, request.title, user)
        Mockito.`when`(articleService.post(newArticle)).then { newArticle }

        val result = mockMvc.perform(
            MockMvcRequestBuilders.post("/api/article")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(request.title))
            .andExpect(MockMvcResultMatchers.jsonPath("$.content").value(request.content))
            .andReturn()
    }
}