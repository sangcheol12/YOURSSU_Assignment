package com.example.ssu_blog.adapter.`in`.controller

import com.example.ssu_blog.adapter.`in`.dto.request.SignOutRequest
import com.example.ssu_blog.adapter.`in`.dto.request.SignUpRequest
import com.example.ssu_blog.adapter.out.persistence.entity.UserEntity
import com.example.ssu_blog.adapter.out.persistence.repository.UserRepository
import com.example.ssu_blog.application.service.UserService
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.validation.ValidationException
import jakarta.ws.rs.core.MediaType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import javax.transaction.Transactional

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class UserControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var userService: UserService

    @Autowired
    private lateinit var encoder: PasswordEncoder

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @BeforeEach
    fun setUp() {
        val user = UserEntity(
            email = "test1@urssu.com",
            password = "password",
            username = "Test User"
        )
        userRepository.save(user)
    }

    @Test
    fun successSignUpTest() {
        val request = SignUpRequest("newuser@urssu.com", "password", "New User")

        mockMvc.perform(
            MockMvcRequestBuilders.post("/api/user/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
    }

    @Test
    fun successSiginOutTest() {
        val request = SignOutRequest("test1@urssu.com", "password")

        mockMvc.perform(
            MockMvcRequestBuilders.delete("/api/user/signout")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
    }

    @Test
    fun existUserSignUpTest() {
        val request = SignUpRequest("test1@urssu.com", "password", "Test User")

        mockMvc.perform(
            MockMvcRequestBuilders.post("/api/user/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request))
        )
            .andExpect(MockMvcResultMatchers.status().isConflict)
    }

    @Test
    fun NoneUserSignOutTest() {
        val request = SignOutRequest("neverExistUser@urssu.com", "password")
        Mockito.`when`(userService.matchAccount(ArgumentMatchers.anyString(), ArgumentMatchers.anyString()))
            .thenThrow(IllegalArgumentException("존재하지 않는 회원입니다."))

        // Act and Assert
        mockMvc.perform(
            MockMvcRequestBuilders.delete("/api/user/signout")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request))
        )
            .andExpect(MockMvcResultMatchers.status().isUnauthorized)
    }

    private fun asJsonString(obj: Any): String {
        try {
            val objectMapper = ObjectMapper()
            return objectMapper.writeValueAsString(obj) // 객체를 JSON 문자열로 변환하여 반환합니다.
        } catch (e: Exception) {
            throw ValidationException(e.localizedMessage)
        }
    }
}