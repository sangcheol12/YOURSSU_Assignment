package com.example.ssu_blog.repository

import com.example.ssu_blog.domain.UserModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class JpaUserRepository (@Autowired private val em: EntityManager): UserRepository {
    override fun save(userParam: UserModel): UserModel {
        em.persist(userParam)
        return userParam
    }

    override fun findById(id: Long): UserModel? {
        return em.find(UserModel::class.javaObjectType, id)
    }

    override fun findByEmail(email: String): UserModel? {
        return em.createQuery(
            "SELECT u " +
                    "FROM UserModel u " +
                    "WHERE u.email = :email", UserModel::class.javaObjectType
        )
            .setParameter("email", email)
            .resultList
            .firstOrNull()
    }

    override fun update(userParam: UserModel): UserModel {
        em.merge(userParam)
        return userParam
    }

    override fun delete(id: Long): UserModel {
        val user = findById(id)
        user ?: throw IllegalArgumentException("")
        em.remove(user)
        return user
    }
}