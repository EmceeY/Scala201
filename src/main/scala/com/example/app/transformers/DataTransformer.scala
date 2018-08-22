package com.example.app.transformers

import com.example.app.models._
import org.json4s._
import org.json4s.jackson.JsonMethods._

import scala.util.{Failure, Success, Try}

object DataTransformer {

  implicit val formats = DefaultFormats // Brings in default date formats etc.


  val defaultPost = Post(0,0,"title","body")
  val defaultPosts = List(defaultPost)

  def getPost(rawJSON: String) : Post = {
    Try(parse(rawJSON).extract[Post]) match {
      case Success(post) => post
      case Failure(e) => defaultPost
    }
  }

  def getPosts(rawJSON: String) : List[Post] = {
    Try(parse(rawJSON).children.map(child => child.extract[Post])) match {
      case Success(posts) => posts
      case Failure(e) => defaultPosts
    }
  }

}
