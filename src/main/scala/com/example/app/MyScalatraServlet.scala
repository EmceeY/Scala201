package com.example.app

import org.scalatra._
import org.json4s._
import org.json4s.jackson.JsonMethods._
import com.example.app.models._

class MyScalatraServlet extends ScalatraServlet {

  implicit val formats = DefaultFormats // Brings in default date formats etc.

  val jsonPlaceHolderBaseURL = "https://jsonplaceholder.typicode.com"

  get("/") {
    views.html.hello()
  }

  get("/comments") {
    HttpClient(jsonPlaceHolderBaseURL + "/comments").getResponse()
  }

  get("/posts"){
    HttpClient(jsonPlaceHolderBaseURL + "/posts").getResponse()
  }

  get("/users") {
    HttpClient(jsonPlaceHolderBaseURL + "/comments").getResponse()
  }

  get("/posts/:id"){
    val post = HttpClient(jsonPlaceHolderBaseURL + "/posts/" + {params("id")}).getResponse()
    val json = parse(post)
    val result = json.extract[Post]
    result
  }

//  def getClasses[T](rawJson: String) = {
//    parse(rawJson).children.map(child => {child.extract[T]})
//  }

  get("/comments/emails"){
    val allCommentsRaw = HttpClient(jsonPlaceHolderBaseURL + "/comments").getResponse()
    val allEmails =
      parse(allCommentsRaw)
        .children
        .map(comment => {
          comment.extract[Comment]
        })
        .map(_.email)
    allEmails
  }

  get("/users/emails"){
    val allUsersRaw = HttpClient(jsonPlaceHolderBaseURL + "/users").getResponse()
    val allUsers = parse(allUsersRaw).children.map(user => {
      user.extract[User]
    })
    val emails = allUsers.map(_.email)
    emails
  }

  get("/matchingUserCommentEmails") {
    val allCommentsRaw = HttpClient(jsonPlaceHolderBaseURL + "/comments").getResponse()
    val allUsersRaw = HttpClient(jsonPlaceHolderBaseURL + "/users").getResponse()

    val allCommentEmails = parse(allCommentsRaw).children.map(comment => {comment.extract[Comment]}).map(_.email)
    val allUserEmails = parse(allUsersRaw).children.map(comment => {comment.extract[User]}).map(_.email)
    val unionEmails = allCommentEmails.intersect(allUserEmails)
    unionEmails
  }

  get("/posts/:id/userDetails") {
    val post = HttpClient(jsonPlaceHolderBaseURL + "/posts/" + {params("id")}).getResponse()
    val postUserId = parse(post).extract[Post].userId

    val user = HttpClient(jsonPlaceHolderBaseURL + s"/users/${postUserId}").getResponse()
    val userDetail = parse(user).extract[User]
    userDetail
  }

  get("/users/:id/postDetails") {
    val userRaw = HttpClient(jsonPlaceHolderBaseURL + "/users/" + {params("id")}).getResponse()
    val user = parse(userRaw).extract[User]

    val allPostsRaw = HttpClient(jsonPlaceHolderBaseURL + s"/posts").getResponse()
    val allPostsUser = parse(allPostsRaw).children.map(post => {post.extract[Post]}).filter(post => post.userId.equals(user.id))
    val allPostDetail = allPostsUser.map(post => PostDetail(post.title, post.body))
    val userPostDetail = UsersPosts(user.id, user.name, user.email, allPostDetail)
//    userPostDetail

    //todo add comments to post details

    def printPostDetails(postDetails: List[PostDetail]) = {
      postDetails.map(post =>
        s"""
           |  title: ${post.title}
           |  body: ${post.body}
         """.stripMargin
      ).mkString
    }
    s"""
       |userId: ${userPostDetail.id}
       |name: ${userPostDetail.name}
       |email: ${userPostDetail.email}
       |posts:
       |${printPostDetails(userPostDetail.posts)}
       |""".stripMargin
  }



}
