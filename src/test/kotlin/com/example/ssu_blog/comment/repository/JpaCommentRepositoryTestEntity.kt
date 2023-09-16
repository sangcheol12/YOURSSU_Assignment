package com.example.ssu_blog.comment.repository

import org.springframework.boot.test.context.SpringBootTest
import javax.transaction.Transactional

@SpringBootTest
@Transactional
class JpaCommentRepositoryTestEntity {

    /*@Autowired
    private lateinit var userRepository: JpaUserRepository
    @Autowired
    private lateinit var articleRepository: JpaArticleRepository
    @Autowired
    private lateinit var commentRepository: JpaCommentRepository

    @Test
    @DisplayName("댓글 추가 및 조회")
    fun saveAndFindById() {
        val testUser = UserEntity("test@urssu.com", "testPwd", "tester")
        val savedUser = userRepository.save(testUser)
        val testArticleEntity = ArticleEntity("testContent", "testTitle", savedUser)
        val savedArticle = articleRepository.save(testArticleEntity)

        val testCommentEntity = CommentEntity("testComment", savedArticle, savedUser)
        val savedComment = commentRepository.save(testCommentEntity)
        val foundComment = commentRepository.findById(savedComment.commentId!!)

        Assertions.assertNotNull(foundComment, "저장된 댓글을 찾아야 함")
        Assertions.assertEquals(savedComment, foundComment, "저장된 댓글과 조회된 댓글이 일치해야 함")
    }

    @Test
    @DisplayName("댓글 수정")
    fun updateComment() {
        val testUser = UserEntity("test@urssu.com", "testPwd", "tester")
        val savedUser = userRepository.save(testUser)
        val testArticleEntity = ArticleEntity("testContent", "testTitle", savedUser)
        val savedArticle = articleRepository.save(testArticleEntity)

        val testCommentEntity = CommentEntity("testComment", savedArticle, savedUser)
        val savedComment = commentRepository.save(testCommentEntity)

        val updatedCommentText = "newComment"
        savedComment.content = updatedCommentText
        val updatedComment = commentRepository.update(savedComment)

        Assertions.assertEquals(updatedCommentText, updatedComment.content, "댓글이 수정되어야 함")
    }

    @Test
    @DisplayName("댓글 삭제")
    fun deleteComment() {
        val testUser = UserEntity("test@urssu.com", "testPwd", "tester")
        val savedUser = userRepository.save(testUser)
        val testArticleEntity = ArticleEntity("testContent", "testTitle", savedUser)
        val savedArticle = articleRepository.save(testArticleEntity)

        val testCommentEntity = CommentEntity("testComment", savedArticle, savedUser)
        val savedComment = commentRepository.save(testCommentEntity)

        commentRepository.delete(savedComment)
        val foundComment = commentRepository.findById(savedComment.commentId!!)

        Assertions.assertNull(foundComment, "댓글이 삭제되어야 함")
    }

    @Test
    @DisplayName("게시글 아래 댓글 삭제")
    fun deleteAllByArticle() {
        val testUser = UserEntity("test@urssu.com", "testPwd", "tester")
        val savedUser = userRepository.save(testUser)
        val testArticleEntity = ArticleEntity("testContent", "testTitle", savedUser)
        val savedArticle = articleRepository.save(testArticleEntity)

        val testComment1Entity = CommentEntity("testComment", savedArticle, savedUser)
        val testComment2Entity = CommentEntity("testComment2", savedArticle, savedUser)
        commentRepository.save(testComment1Entity)
        commentRepository.save(testComment2Entity)

        commentRepository.deleteAllByArticle(savedArticle)
        articleRepository.delete(savedArticle)

        val foundComment1 = commentRepository.findById(testComment1Entity.commentId!!)
        val foundComment2 = commentRepository.findById(testComment2Entity.commentId!!)

        Assertions.assertNull(foundComment1, "댓글 1이 삭제되어야 함")
        Assertions.assertNull(foundComment2, "댓글 2가 삭제되어야 함")
    }

    @Test
    @DisplayName("유저의 댓글 삭제")
    fun deleteAllByUser() {
        val testUser = UserEntity("test123@naver.com", "testPwd", "tester")
        val savedUser = userRepository.save(testUser)
        val testArticle1Entity = ArticleEntity("Test Content 1", "Test Title 1", savedUser)
        val testArticle2Entity = ArticleEntity("Test Content 2", "Test Title 2", savedUser)
        articleRepository.save(testArticle1Entity)
        articleRepository.save(testArticle2Entity)

        val testComment1Entity = CommentEntity("Comment 1", testArticle1Entity, savedUser)
        val testComment2Entity = CommentEntity("Comment 2", testArticle2Entity, savedUser)
        commentRepository.save(testComment1Entity)
        commentRepository.save(testComment2Entity)

        commentRepository.deleteAllByUser(savedUser)

        val foundComment1 = commentRepository.findById(testComment1Entity.commentId!!)
        val foundComment2 = commentRepository.findById(testComment2Entity.commentId!!)

        Assertions.assertNull(foundComment1, "댓글 1이 삭제되어야 함")
        Assertions.assertNull(foundComment2, "댓글 2가 삭제되어야 함")
    }*/
}
