/*package com.example.ssu_blog.adapter.`in`.controller

import com.example.ssu_blog.adapter.`in`.dto.request.ArticleCreateOrUpdateRequest
import com.example.ssu_blog.adapter.`in`.dto.request.SignInRequest
import com.example.ssu_blog.adapter.`in`.dto.request.SignUpRequest

import com.example.ssu_blog.adapter.out.persistence.entity.UserEntity
import com.example.ssu_blog.adapter.out.persistence.repository.ArticleRepository
import com.example.ssu_blog.adapter.out.persistence.repository.UserRepository
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.*
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.time.LocalDateTime
import javax.transaction.Transactional

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ArticleContollerTest @Autowired constructor(
    val mockMvc: MockMvc,
    val objectMapper: ObjectMapper,
    @Autowired val userRepository: UserRepository,
    @Autowired val articleRepository: ArticleRepository
) {
    val baseUrl = "/api/article"
    val baseUserUrl = "/api/user"
    var testMainUser: UserEntity? = null
    var testToken: String? = null
    var testArticleId: Long? = null
    @BeforeEach
    fun setUp() {
        val request = SignUpRequest("test001@urssu.com", "password", "Test User", "USER")
        val jsonBody = ObjectMapper().writeValueAsString(request)

        val result = mockMvc.perform(
            MockMvcRequestBuilders.post("$baseUserUrl/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBody)
        ).andReturn()
        if (result.response.status == 200) {
            val temp = result.response.contentAsString
            val objectMapper = ObjectMapper()
            val jsonNode = objectMapper.readTree(temp)
            val email = jsonNode["email"].asText()

            testMainUser = userRepository.findByEmail(email)
        }

        val request2 = SignInRequest(testMainUser!!.email, "password")
        val jsonBody2 = ObjectMapper().writeValueAsString(request2)

        val result2 = mockMvc.perform(
            MockMvcRequestBuilders.post("$baseUserUrl/signin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBody2)
        ).andReturn()
        if (result2.response.status == 200) {
            val temp = result2.response.contentAsString
            val objectMapper = ObjectMapper()
            val jsonNode = objectMapper.readTree(temp)
            testToken = jsonNode["accessToken"].asText()
        }

        val request3 = ArticleCreateOrUpdateRequest("article title", "article content")
        val jsonBody3 = ObjectMapper().writeValueAsString(request3)

        val result3 = mockMvc.perform(
            MockMvcRequestBuilders.post(baseUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", testToken)
                .content(jsonBody3)
        ).andReturn()
        if (result3.response.status == 200) {
            val temp = result3.response.contentAsString
            val objectMapper = ObjectMapper()
            val jsonNode = objectMapper.readTree(temp)
            testArticleId = jsonNode["articleId"].asLong()
        }
    }

    @Test
    @DisplayName("게시물 작성 컨트롤러 테스트")
    fun testPostArticle() {
        val request = ArticleCreateOrUpdateRequest("new article title", "new article content")
        val jsonBody = ObjectMapper().writeValueAsString(request)

        mockMvc.perform(
            MockMvcRequestBuilders.post(baseUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", testToken)
                .content(jsonBody)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
    }

    @Test
    @DisplayName("게시물 수정 컨트롤러 테스트")
    fun testUpdateArticle() {
        var request = articleRepository.findByArticleId(testArticleId!!)
        request.updateInfo("new Title", "new Content", LocalDateTime.now())

        val objectMapper = ObjectMapper().registerModule(JavaTimeModule()) // Java 8 date/time 모듈 등록
        val jsonBody = objectMapper.writeValueAsString(request)

        val temp = "$baseUrl/" + testArticleId.toString()

        mockMvc.perform(
            MockMvcRequestBuilders.put(temp)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", testToken)
                .content(jsonBody)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
    }
}*/