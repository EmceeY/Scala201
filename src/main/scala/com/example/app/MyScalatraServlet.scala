package com.example.app

import org.scalatra._

class MyScalatraServlet extends ScalatraServlet {

  val jsonPlaceHolderBaseURL = "https://jsonplaceholder.typicode.com"

  get("/users") {
    HttpClient(jsonPlaceHolderBaseURL + "/users").getResponse()
  }

  get("/posts"){
    HttpClient(jsonPlaceHolderBaseURL + "/posts").getResponse()
  }

  get("/comments") {
    HttpClient(jsonPlaceHolderBaseURL + "/comments").getResponse()
  }
}
