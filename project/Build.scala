import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "temp"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    "mysql" % "mysql-connector-java" % "5.1.21",
    "play" %% "anorm" % "2.1.1",
    "play" %% "play-jdbc" % "2.1.1",
    "com.lucidchart" %% "relate" % "0.1-SNAPSHOT"
 
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
    scalaVersion := "2.10.1",
    resolvers ++= List(   
      Resolver.file("local ivy repository", file(System.getenv("HOME") + "/.ivy2/local/"))(Resolver.ivyStylePatterns),
     "lucidchart snapshot repository" at "http://repo.lucidchart.com:8081/artifactory/libs-snapshot-local",
      "Staging Sonatype repository" at "https://oss.sonatype.org/content/groups/staging/" )
  )

}
