package com.example.app.transformers

import com.example.app.HttpClient

object JSONPlaceholderDataFactory {

  val jsonPlaceholderBaseURL = "https://jsonplaceholder.typicode.com"

  def getContent(contentType: String) : String = {
    HttpClient(jsonPlaceholderBaseURL + s"/${contentType}").getResponse()
  }

  val allUsersRaw = getContent("users")
  val allPostsRaw = getContent("posts")
  val allCommentsRaw = getContent("comments")
}