package com.example.ssu_blog.comment.domain.repository

import com.example.ssu_blog.article.domain.entity.Article
import com.example.ssu_blog.comment.domain.entity.Comment
import com.example.ssu_blog.user.domain.entity.UserModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class JpaCommentRepository(@Autowired private val em: EntityManager): CommentRepository {
    override fun save(saveComment: Comment): Comment {
        em.persist(saveComment)
        return saveComment
    }

    override fun findById(id: Long): Comment? {
        return em.find(Comment::class.java, id)
    }

    override fun update(updateComment: Comment): Comment {
        em.merge(updateComment)
        return updateComment
    }

    override fun delete(deleteComment: Comment) {
        em.remove(deleteComment)
    }

    override fun deleteAllByArticle(deleteArticle: Article) {
        em.createQuery("DELETE FROM Comment c WHERE c.articleId = :deleteArticle")
            .setParameter("deleteArticle", deleteArticle)
            .executeUpdate()
    }

    override fun deleteAllByUser(deleteUser: UserModel) {
        em.createQuery("DELETE FROM Comment c WHERE c.userId = :deleteUser")
            .setParameter("deleteUser", deleteUser)
            .executeUpdate()
    }
}