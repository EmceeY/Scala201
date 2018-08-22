
val ScalatraVersion = "2.6.3"

organization := "com.example"

name := "Scala201"

version := "0.1"

scalaVersion := "2.12.6"

resolvers += Classpaths.typesafeReleases

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % ScalatraVersion,
  "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
  "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
  "org.eclipse.jetty" % "jetty-webapp" % "9.2.19.v20160908" % "container",
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
  "org.scalaj" %% "scalaj-http" % "2.4.0",
  "org.json4s"   %% "json4s-jackson" % "3.5.2",
  "org.json4s" %% "json4s-mongo" % "3.5.2",
  "org.mongodb" %% "casbah" % "3.1.1",
  "net.liftweb" %% "lift-json" % "3.3.0",
  "org.scalatra" %% "scalatra-json" % ScalatraVersion
)

enablePlugins(SbtTwirl)
enablePlugins(ScalatraPlugin)