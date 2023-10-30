package com.example.ssu_blog.adapter.`in`.controller

import com.example.ssu_blog.adapter.`in`.dto.request.SignInRequest
import com.example.ssu_blog.adapter.`in`.dto.request.SignUpRequest
import com.example.ssu_blog.adapter.out.persistence.entity.UserEntity
import com.example.ssu_blog.adapter.out.persistence.repository.UserRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import javax.transaction.Transactional

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
internal class UserControllerTest @Autowired constructor(
    val mockMvc: MockMvc,
    val objectMapper: ObjectMapper,
    @Autowired val userRepository: UserRepository,
) {

    val baseUrl = "/api/user"
    var testMainUser: UserEntity? = null
    var testToken: String? = null
    @BeforeEach
    fun setUp() {
        val request = SignUpRequest("test001@urssu.com", "password", "Test User", "USER")
        val jsonBody = ObjectMapper().writeValueAsString(request)

        val result = mockMvc.perform(
            MockMvcRequestBuilders.post("$baseUrl/signup")
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
            MockMvcRequestBuilders.post("$baseUrl/signin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBody2)
        ).andReturn()
        if (result2.response.status == 200) {
            val temp = result2.response.contentAsString
            val objectMapper = ObjectMapper()
            val jsonNode = objectMapper.readTree(temp)
            testToken = jsonNode["accessToken"].asText()
        }
    }

    @Test
    @DisplayName("회원가입 성공 컨트롤러 테스트")
    fun successSignUpTest() {
        val signUpRequest = SignUpRequest("newTestuser@yourssu.com", "newpassword", "New User", "USER")
        val jsonBody = ObjectMapper().writeValueAsString(signUpRequest)

        mockMvc.perform(
            MockMvcRequestBuilders.post("$baseUrl/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBody)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
    }

    @Test
    @DisplayName("중복 회원가입 실패 컨트롤러 테스트")
    fun existUserSignUpTest() {
        val request = SignUpRequest("test1@urssu.com", "password", "Test User", "USER")
        val jsonBody = ObjectMapper().writeValueAsString(request)

        mockMvc.perform(
            MockMvcRequestBuilders.post("$baseUrl/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBody)
        )
            .andExpect(MockMvcResultMatchers.status().isConflict)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
    }

    @Test
    @DisplayName("회원 삭제 컨트롤러 테스트")
    fun SignOutTest() {
        mockMvc.perform(
            MockMvcRequestBuilders.delete("$baseUrl/signout")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", testToken)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
    }
}