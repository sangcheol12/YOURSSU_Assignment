package com.example.ssu_blog.repository

import com.example.ssu_blog.user.domain.entity.UserModel
import com.example.ssu_blog.user.domain.repository.JpaUserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.transaction.Transactional

@SpringBootTest
@Transactional
class JpaUserRepositoryTest {

    @Autowired
    private lateinit var userRepository: JpaUserRepository
    val testEmail: String = "test123@naver.com"
    private val testUser = UserModel(testEmail,"testPwd","tester")

    @BeforeEach
    fun setup() {
        userRepository.save(testUser)
    }

    @Test
    @DisplayName("User 추가 레포지토리 테스트")
    fun saveTest() {
        val savedUser = userRepository.save(testUser)
        Assertions.assertEquals(testUser, savedUser)
    }

    @Test
    @DisplayName("Email을 통해 User 찾기 레포지토리 테스트")
    fun findByEmail() {
        val findUser = userRepository.findByEmail(testEmail)
        Assertions.assertEquals(testUser, findUser)
    }
}