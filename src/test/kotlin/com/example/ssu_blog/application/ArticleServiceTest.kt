package com.example.ssu_blog.application

import com.example.ssu_blog.adapter.out.persistence.repository.ArticleRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.transaction.Transactional

@SpringBootTest
@Transactional
@ExtendWith(MockitoExtension::class)
class ArticleServiceTest {
   /* @Autowired
    private final val articleRepository: ArticleRepository

    @Test
    fun getArticleTest() {
        `when`(articleRepository.save(

        )).thenReturn()
    }*/
}