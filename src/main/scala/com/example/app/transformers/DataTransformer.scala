package com.example.app.transformers

import com.example.app.models.Post
import org.json4s._
import org.json4s.jackson.JsonMethods._

object DataTransformer {

  implicit val formats = DefaultFormats // Brings in default date formats etc.

//  def getClasses[T](rawJSON: String) = {
//    parse(rawJSON).children.map(child => child.extract[T])
//  }

  def getPost(rawJSON: String) = {
    parse(rawJSON).extract[Post]
  }

  def getPosts(rawJSON: String) = {
    parse(rawJSON).children.map(child => child.extract[Post])
  }



}
