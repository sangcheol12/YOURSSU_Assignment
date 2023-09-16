package com.example.ssu_blog.application.service

import com.example.ssu_blog.adapter.out.persistence.entity.ArticleEntity
import com.example.ssu_blog.adapter.out.persistence.entity.CommentEntity
import com.example.ssu_blog.adapter.out.persistence.entity.UserEntity
import com.example.ssu_blog.adapter.out.persistence.repository.CommentRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class CommentService (
    private val commentRepository: CommentRepository
) {
    fun post(newCommentEntity: CommentEntity): CommentEntity {
        return commentRepository.save(newCommentEntity)
    }

    fun update(updateCommentEntity: CommentEntity): CommentEntity {
        return commentRepository.save(updateCommentEntity)
    }

    fun delete(deleteCommentId: Long, accessUser: UserEntity, curAricle: ArticleEntity) {
        val comment = getAuthComment(deleteCommentId, accessUser, curAricle)
        commentRepository.delete(comment)
    }

    fun getComment(commentId: Long): CommentEntity {
        return commentRepository.findById(commentId)
            .orElseThrow { NoSuchElementException("댓글이 존재하지 않습니다.") }
    }

    fun getAuthComment(commentId: Long, accessUser: UserEntity, curArticleEntity: ArticleEntity): CommentEntity {
        val comment = getComment(commentId)
        if(comment.userEntityId != accessUser)
            throw IllegalAccessException("댓글을 수정 할 권한이 없습니다.")
        if(comment.articleEntityId != curArticleEntity)
            throw NoSuchElementException("게시글과 댓글 정보가 일치하지 않습니다.")
        return comment
    }
}