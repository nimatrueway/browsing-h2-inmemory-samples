name := "play-slick-mcwire"

version := "1.0"

scalaVersion := "2.12.3"

enablePlugins(PlayScala)

// macwire
libraryDependencies += "com.softwaremill.macwire" %% "macros" % "2.3.0" % "provided"
libraryDependencies += "com.softwaremill.macwire" %% "util" % "2.3.0"
libraryDependencies += "com.softwaremill.macwire" %% "proxy" % "2.3.0"

// database libraries
libraryDependencies += "org.postgresql" % "postgresql" % "42.1.3"
libraryDependencies += "com.typesafe.play" %% "play-slick" % "3.0.0"
libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "3.0.0"
libraryDependencies += evolutions
libraryDependencies += jdbc
libraryDependencies += "com.github.tototoshi" %% "slick-joda-mapper" % "2.3.0"

// test libraries
libraryDependencies += "com.h2database" % "h2" % "1.4.194" % Test
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % Test
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.1" % Test
