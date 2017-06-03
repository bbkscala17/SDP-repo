import sbt._
import Keys._
//import sbtassembly._
//import AssemblyKeys._

//assemblySettings
//seq(assemblySettings: _*)

name := "akkaTesting"

version := "1.0"

scalaVersion := "2.12.2"

scalaVersion := "2.11.2"

resolvers ++=
  Seq("repo" at "http://repo.typesafe.com/typesafe/releases/")

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.4"

//assemblyMergeStrategy in assembly := {
//  case PathList("reference.conf") => MergeStrategy.concat
//}