package com.example.app

import org.scalatra._

class MyScalatraServlet extends ScalatraServlet {

  val jsonPlaceholderBaseURL = "https://jsonplaceholder.typicode.com"

  get("/users") {
    HttpClient(jsonPlaceholderBaseURL + "/users").getResponse()
  }

  get("/posts"){
    HttpClient(jsonPlaceholderBaseURL + "/posts").getResponse()
  }

  get("/comments") {
    HttpClient(jsonPlaceholderBaseURL + "/comments").getResponse()
  }
}
