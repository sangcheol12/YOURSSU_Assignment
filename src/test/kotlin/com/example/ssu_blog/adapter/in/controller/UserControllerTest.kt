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
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
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

    /*@Test
    @DisplayName("회원가입 성공 컨트롤러 테스트")
    fun successSignUpTest() {
        val request = SignUpRequest("newuser@urssu.com", "password", "New User")

        val user = UserEntity(
            email = request.email,
            password = request.password,
            username = request.username
        )

        mockMvc.perform(
            MockMvcRequestBuilders.post("/api/user/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
    }*/

    @Test
    @DisplayName("회원탈퇴 성공 컨트롤러 테스트")
    fun successSiginOutTest() {
        val request = SignOutRequest("test1@urssu.com", "password")

        mockMvc.perform(
            MockMvcRequestBuilders.delete("/api/user/signout")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
    }

    /*@Test
    @DisplayName("중복 회원가입 실패 컨트롤러 테스트")
    fun existUserSignUpTest() {
        val request = SignUpRequest("test1@urssu.com", "password", "Test User")

        mockMvc.perform(
            MockMvcRequestBuilders.post("/api/user/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request))
        )
            .andExpect(MockMvcResultMatchers.status().isConflict)
    }*/

    @Test
    @DisplayName("존재하지 않은 회원 삭제 컨트롤러 테스트")
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