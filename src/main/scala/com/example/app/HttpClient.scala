package com.example.app

import scalaj.http.{Http}

class HttpClient(url: String) {

  def getResponse() : String =
    Http(url).asString.throwError.throwServerError.body

}

object HttpClient {
  def apply(url: String) = new HttpClient(url)
}
