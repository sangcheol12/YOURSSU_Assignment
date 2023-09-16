package com.example.ssu_blog.user.domain.repository

import com.example.ssu_blog.user.domain.entity.UserModel
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
        return em.find(UserModel::class.java, id)
    }

    override fun findByEmail(email: String): UserModel? {
        return em.createQuery(
            "SELECT u " +
                    "FROM UserModel u " +
                    "WHERE u.email = :email", UserModel::class.java
        )
            .setParameter("email", email)
            .resultList
            .firstOrNull()
    }

    override fun update(userParam: UserModel): UserModel {
        em.merge(userParam)
        return userParam
    }

    override fun delete(deleteUser: UserModel) {
        em.remove(deleteUser)
    }
}