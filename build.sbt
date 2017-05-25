name := "mapa"

version := "1.0"

lazy val `mapa` = {
  project.in(file(".")).enablePlugins(PlayJava,PlayEbean)
}

scalaVersion := "2.11.7"
version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "org.postgresql" % "postgresql" % "9.3-1102-jdbc41",
  "org.hibernate" % "hibernate-core" % "4.3.5.Final",
  "org.hibernate" % "hibernate-entitymanager" % "4.3.5.Final"

)

// https://mvnrepository.com/artifact/org.avaje/ebean
//libraryDependencies += "org.avaje" % "ebean" % "2.7.3"