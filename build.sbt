val scala3Version = "3.0.2"

lazy val root = project
  .in(file("."))
  .settings(
    name := "calclog-examples",
    organization := "com.danielwestheide",
    version := "0.1.0",
    scalaVersion := scala3Version,
    resolvers += Resolver.githubPackages("dwestheide"),
    libraryDependencies ++= Seq(
      "com.danielwestheide" %% "calclog" % "0.2.0",
      "org.typelevel"  %% "squants"  % "1.8.3",
      "org.slf4j" % "slf4j-simple" % "1.7.32",
      "com.casualmiracles" %% "treelog-cats" % "1.8.0"
    )
  )
