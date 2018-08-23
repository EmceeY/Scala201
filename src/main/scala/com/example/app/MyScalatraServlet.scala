package com.example.app

import com.example.app.transformers.{DataTransformer => transformer, JSONPlaceholderDataFactory => data}
import org.scalatra._

class MyScalatraServlet extends ScalatraServlet {

  get("/users") {
    data.allUsersRaw
  }

  get("/posts"){
//    data.allPostsRaw
    val posts = transformer.getPosts(data.allPostsRaw)
    transformer.caseClassToPrettyJSON(posts)
  }

  get("/comments") {
    data.allCommentsRaw
  }

  get("/users/:id"){
    data.individualUserRaw(params("id"))
  }

  get("/posts/:id"){
//    data.individualPostRaw(params("id"))
    val post = transformer.getPost(data.individualPostRaw(params("id")))
    transformer.caseClassToPrettyJSON(post)
  }

  get("/comments/:id"){
    data.individualCommentRaw(params("id"))
  }
}
