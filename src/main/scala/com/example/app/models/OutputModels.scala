package com.example.app.models

case class UsersPosts(
                       userId: Int,
                       name: String,
                       email: String,
                       posts: List[PostDetail]
                     )

case class PostDetail(
                       postId: Int,
                       title: String,
                       body: String,
                       comments: List[CommentDetail]
                     )

case class CommentDetail(
                          commentId: Int,
                          email: String,
                          body: String
                        )
