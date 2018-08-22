package com.example.app

import com.example.app.models.Post
import com.example.app.transformers.{DataTransformer => transformer, JSONPlaceholderDataFactory => data}
import org.scalatra._

class MyScalatraServlet extends ScalatraServlet {

  get("/users") {
    data.allUsersRaw
  }

  get("/posts"){
//    data.allPostsRaw
    transformer.getItems[Post](data.allPostsRaw)
  }

  get("/comments") {
    data.allCommentsRaw
  }

  get("/users/:id"){
    data.individualUserRaw(params("id"))
  }

  get("/posts/:id"){
//    data.individualPostRaw(params("id"))
    transformer.getItem[Post](data.individualPostRaw(params("id")))
  }

  get("/comments/:id"){
    data.individualCommentRaw(params("id"))
  }
}
