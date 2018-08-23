package com.example.app

import scalaj.http.{Http, HttpResponse}

class HttpClient(url: String) {

  def getResponse() : String =
    Http(url).asString.throwError.throwServerError.body

}

object HttpClient {
  def apply(url: String) = new HttpClient(url)
}
