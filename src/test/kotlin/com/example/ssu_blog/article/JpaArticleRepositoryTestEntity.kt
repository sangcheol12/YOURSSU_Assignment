package com.example.ssu_blog.article

import org.springframework.boot.test.context.SpringBootTest
import javax.transaction.Transactional


@SpringBootTest
@Transactional
class JpaArticleRepositoryTestEntity {

    /*@Autowired
    private lateinit var userRepository: JpaUserRepository
    @Autowired
    private lateinit var articleRepository: JpaArticleRepository
    @Autowired
    private lateinit var commentRepository: JpaCommentRepository

    @Test
    @DisplayName("게시글 추가 및 조회")
    fun saveAndFindById() {
        val testUser = UserEntity("test@urssu.com", "testPwd", "tester")
        val savedUser = userRepository.save(testUser)
        val testArticleEntity = ArticleEntity("testContent", "testTitle", savedUser)

        val savedArticle = articleRepository.save(testArticleEntity)
        val foundArticle = articleRepository.findById(savedArticle.articleId!!)

        Assertions.assertEquals(savedArticle, foundArticle, "저장된 게시글과 조회된 게시글이 다름")
    }

    @Test
    @DisplayName("게시글 업데이트")
    fun updateArticle() {
        val testUser = UserEntity("test@urssu.com", "testPwd", "tester")
        val savedUser = userRepository.save(testUser)
        val testArticleEntity = ArticleEntity("testContent", "testTitle", savedUser)
        val savedArticle = articleRepository.save(testArticleEntity)

        savedArticle.title = "newTitle"
        val updatedArticle = articleRepository.update(savedArticle)

        Assertions.assertEquals("newTitle", updatedArticle.title, "게시글이 업데이트 되자 않음")
    }

    @Test
    @DisplayName("게시글 삭제")
    fun deleteArticle() {
        val testUser = UserEntity("test@urssu.com", "testPwd", "tester")
        val savedUser = userRepository.save(testUser)
        val testArticleEntity = ArticleEntity("testContent", "testTitle", savedUser)
        val savedArticle = articleRepository.save(testArticleEntity)

        articleRepository.delete(savedArticle)
        val foundArticle = articleRepository.findById(savedArticle.articleId!!)

        Assertions.assertNull(foundArticle, "게시글이 삭제되지 않음")
    }

    @Test
    @DisplayName("유저의 게시글 및 댓글 삭제")
    @Rollback(false)
    fun deleteAllByUser() {
        val testUser = UserEntity("test@urssu.com", "testPwd", "tester")
        val savedUser = userRepository.save(testUser)
        val testArticle1Entity = ArticleEntity("testContent", "testTitle", savedUser)
        val testArticle2Entity = ArticleEntity("testContent2", "testTitle2", savedUser)

        val savedArticle1 = articleRepository.save(testArticle1Entity)
        val savedArticle2 = articleRepository.save(testArticle2Entity)

        val commentEntity1 = CommentEntity("comment1", savedArticle1, savedUser)
        val commentEntity2 = CommentEntity("comment2", savedArticle2, savedUser)

        val savedComment1 = commentRepository.save(commentEntity1)
        val savedComment2 = commentRepository.save(commentEntity2)

        articleRepository.deleteAllByUser(savedUser)

        Assertions.assertNull(articleRepository.findById(savedArticle1.articleId!!))
        Assertions.assertNull(articleRepository.findById(savedArticle2.articleId!!))
        Assertions.assertNull(commentRepository.findById(savedComment1.commentId!!))
        Assertions.assertNull(commentRepository.findById(savedComment2.commentId!!))
    }*/
}
