val scala3Version = "3.3.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "pps-lab02",
    scalaVersion := scala3Version,
    libraryDependencies += "com.github.sbt" % "junit-interface" % "0.13.3" % Test
  )
