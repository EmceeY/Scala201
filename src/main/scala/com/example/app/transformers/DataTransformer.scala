package com.example.app.transformers

import com.example.app.models._
import org.json4s._
import org.json4s.jackson.JsonMethods._

import com.example.app.transformers.{JSONPlaceholderDataFactory => data}

object DataTransformer {

  implicit val formats = DefaultFormats // Brings in default date formats etc.

  def getItems[T](rawJSON: String)(implicit m: Manifest[T]): List[T] = {
    parse(rawJSON).children.map(child => child.extract[T])
  }

  def getItem[T](rawJSON: String)(implicit m: Manifest[T]): T = {
    parse(rawJSON).extract[T]
  }

  def getUserByPost(id: String): User = {
    val postRaw = data.individualPostRaw(id)
    val post = getItem[Post](postRaw)
    val postUserId = post.userId

    val userRaw = data.individualUserRaw(postUserId.toString)
    val user = getItem[User](userRaw)
    user
  }

  private
  def getCommentDetail(postId: Int) : List[CommentDetail] = {
    val allComments = getItems[Comment](data.allCommentsRaw)
    val allCommentsOnPost = allComments.filter(comment => {comment.postId.equals(postId)})
    allCommentsOnPost
      .map(comment =>
        CommentDetail(comment.id, comment.email, comment.body)
    )
  }

  private
  def getPostDetails(userId: Int) : List[PostDetail] = {
    val allPosts = getItems[Post](data.allPostsRaw)
    val allPostsForUser = allPosts.filter(post => post.userId.equals(userId))
    allPostsForUser
      .map(post =>
        PostDetail(post.id, post.title, post.body, getCommentDetail(post.id))
      )
  }

  def getUsersPosts(userId: String) : UsersPosts = {
    val user = getItem[User](data.individualUserRaw(userId))
    UsersPosts(user.id, user.name, user.email, getPostDetails(userId.toInt))
  }
}

