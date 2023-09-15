package com.example.ssu_blog.comment.service

import com.example.ssu_blog.article.domain.entity.Article
import com.example.ssu_blog.comment.domain.entity.Comment
import com.example.ssu_blog.comment.domain.repository.JpaCommentRepository
import com.example.ssu_blog.user.domain.entity.UserModel
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import javax.transaction.Transactional

@Service
@Transactional
class CommentService (
    private val commentRepository: JpaCommentRepository
) {
    fun post(newComment: Comment): Comment {
        return commentRepository.save(newComment)
    }

    fun update(updateComment: Comment): Comment {
        return commentRepository.update(updateComment)
    }

    fun delete(deleteCommentId: Long, accessUser: UserModel, curAricle: Article) {
        val comment = getAuthComment(deleteCommentId, accessUser, curAricle)
        commentRepository.delete(comment)
    }

    fun getComment(commentId: Long): Comment {
        val comment = commentRepository.findById(commentId)
            ?: throw NoSuchElementException("댓글이 존재하지 않습니다.")
        return comment
    }

    fun getAuthComment(commentId: Long, accessUser: UserModel, curArticle: Article): Comment {
        val comment = getComment(commentId)
        if(comment.userId != accessUser)
            throw IllegalAccessException("댓글을 수정 할 권한이 없습니다.")
        if(comment.articleId != curArticle)
            throw NoSuchElementException("게시글과 댓글 정보가 일치하지 않습니다.")
        return comment
    }
}