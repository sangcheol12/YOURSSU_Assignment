package com.example.ssu_blog.user.repository

import com.example.ssu_blog.adapter.out.persistence.entity.UserEntity
import com.example.ssu_blog.adapter.out.persistence.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.transaction.Transactional

@SpringBootTest
@Transactional
class JpaUserRepositoryTest {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Test
    @DisplayName("User를 추가하고 찾기")
    fun saveAndFindByEmail() {
        val testEmail = "test@urssu.com"
        val testUser = UserEntity(testEmail, "testPwd", "tester")

        val savedUser = userRepository.save(testUser)
        val foundUser = userRepository.findByEmail(testEmail)

        Assertions.assertEquals(testUser, foundUser, "저장된 유저와 찾은 유저가 일치하지 않음")
    }
}
