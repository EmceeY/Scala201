package com.example.app.transformers

import com.example.app.HttpClient

object JSONPlaceholderDataFactory {

  private
  val jsonPlaceHolderBaseURL = "https://jsonplaceholder.typicode.com"

  private
  def getContent(contentType: String) = {
    HttpClient(jsonPlaceHolderBaseURL + s"/${contentType}").getResponse()
  }

  private
  def getIndividualContent(contentType: String, id: String) = {
    HttpClient(jsonPlaceHolderBaseURL + s"/${contentType}/${id}").getResponse()
  }

  val allUsersRaw = getContent("users")
  val allPostsRaw = getContent("posts")
  val allCommentsRaw = getContent("comments")
  def individualUserRaw(id: String) = {
    getIndividualContent("users", id)
  }
  def individualPostRaw(id: String) = {
    getIndividualContent("posts", id)
  }
  def individualCommentRaw(id: String) = {
    getIndividualContent("comments", id)
  }
}