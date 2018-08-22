package com.example.app

import com.example.app.transformers.JSONPlaceholderTransformer
import org.scalatra._

class MyScalatraServlet extends ScalatraServlet {

  val jsonPlaceHolderBaseURL = "https://jsonplaceholder.typicode.com"

  get("/users") {
    JSONPlaceholderTransformer.allUsersRaw
  }

  get("/posts"){
    JSONPlaceholderTransformer.allPostsRaw
  }

  get("/comments") {
    JSONPlaceholderTransformer.allCommentsRaw
  }
}
