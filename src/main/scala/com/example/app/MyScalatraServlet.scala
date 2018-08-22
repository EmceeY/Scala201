package com.example.app

import org.scalatra._

class MyScalatraServlet extends ScalatraServlet {

  get("/"){
    "greetings"
  }

  get("/users") {
    "add users "
  }

  get("/posts"){
    "add posts here"
  }

  get("/comments") {
    "add comments here"
  }

}
