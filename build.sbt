ThisBuild / scalaVersion := "3.1.0-RC2"
ThisBuild / versionScheme := Some("early-semver")
ThisBuild / githubWorkflowPublishTargetBranches := Seq()

val commonSettings = Seq(
  scalacOptions -= "-Xfatal-warnings",
  libraryDependencies ++= Seq(
    "org.scala-lang" % "scala-library" % "2.11.8",
    "org.typelevel" %% "cats-effect" % "3.2.9",
    // "org.typelevel" %% "cats-mtl" % "1.2.1",
    "org.typelevel" %% "cats-core" % "2.6.1",
    "org.typelevel" %% "munit-cats-effect-3" % "1.0.6",
  ),
)

val shared = project.settings(commonSettings)
val server = project.settings(commonSettings).dependsOn(shared)
val client = project.settings(commonSettings).dependsOn(shared)

val root = project
  .in(file("."))
  .settings(publish := {}, publish / skip := true)
  .aggregate(server, client, shared)
