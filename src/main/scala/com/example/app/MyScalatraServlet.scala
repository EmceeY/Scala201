package com.example.app

import com.example.app.transformers.{JSONPlaceholderTransformer => data}
import org.scalatra._

class MyScalatraServlet extends ScalatraServlet {

  get("/users") {
    data.allUsersRaw
  }

  get("/posts"){
    data.allPostsRaw
  }

  get("/comments") {
    data.allCommentsRaw
  }
}
