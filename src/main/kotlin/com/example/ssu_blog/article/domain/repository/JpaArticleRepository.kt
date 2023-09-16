package com.example.ssu_blog.article.domain.repository

import com.example.ssu_blog.article.domain.entity.Article
import com.example.ssu_blog.user.domain.entity.UserModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class JpaArticleRepository(@Autowired private val em: EntityManager): ArticleRepository {
    override fun save(saveArticle: Article): Article {
        em.persist(saveArticle)
        return saveArticle
    }

    override fun findById(id: Long): Article? {
        return em.find(Article::class.java, id)
    }

    override fun update(updateArticle: Article): Article {
        em.merge(updateArticle)
        return updateArticle
    }

    override fun delete(deleteArticle: Article): Article {
        em.remove(deleteArticle)
        return deleteArticle
    }

    override fun deleteAllByUser(deleteUser: UserModel) {
        val articles = em.createQuery("SELECT a FROM Article a WHERE a.userId = :deleteUser", Article::class.java)
            .setParameter("deleteUser", deleteUser)
            .resultList

        // 유저가 작성한 게시글에 작성된 댓글들 삭제
        articles.forEach { article ->
            em.createQuery("DELETE FROM Comment c WHERE c.articleId = :article")
                .setParameter("article", article)
                .executeUpdate()
        }

        em.createQuery("DELETE FROM Article a WHERE a.userId = :deleteUser")
            .setParameter("deleteUser", deleteUser)
            .executeUpdate()
    }
}