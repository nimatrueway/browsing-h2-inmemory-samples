name := "play-slick-mcwire"

version := "1.0"

scalaVersion := "2.11.8"

enablePlugins(PlayScala)

// macwire
libraryDependencies += "com.softwaremill.macwire" %% "macros" % "2.3.0" % "provided"
libraryDependencies += "com.softwaremill.macwire" %% "util" % "2.3.0"
libraryDependencies += "com.softwaremill.macwire" %% "proxy" % "2.3.0"

// database libraries
libraryDependencies += "org.postgresql" % "postgresql" % "42.0.0"
libraryDependencies += "com.typesafe.play" %% "play-slick" % "2.0.2"
libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "2.0.2"
libraryDependencies += evolutions
libraryDependencies += jdbc
libraryDependencies += "com.github.tototoshi" %% "slick-joda-mapper" % "2.2.0"

// test libraries
libraryDependencies += "com.h2database" % "h2" % "1.4.193" % Test
libraryDependencies += "org.scalactic" %% "scalactic" % "2.2.6"
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % Test
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.0" % Test
