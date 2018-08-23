package com.example.app.models

case class UsersPosts(
                       id: Int,
                       name: String,
                       email: String,
                       posts: List[PostDetail]
                     )

case class PostDetail(
                       title: String,
                       body: String
                     )

case class CommentDetail(
                          email: String,
                          body: String
                        )
