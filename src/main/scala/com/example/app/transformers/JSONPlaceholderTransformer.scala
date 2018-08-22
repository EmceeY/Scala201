package com.example.app.transformers

import com.example.app.HttpClient

object JSONPlaceholderTransformer {

  val jsonPlaceHolderBaseURL = "https://jsonplaceholder.typicode.com"

  def getContent(contentType: String) = {
    HttpClient(jsonPlaceHolderBaseURL + s"/${contentType}").getResponse()
  }

  val allUsersRaw = getContent("users")
  val allPostsRaw = getContent("posts")
  val allCommentsRaw = getContent("comments")
}