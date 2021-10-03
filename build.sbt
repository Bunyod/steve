val commonSettings = Seq(
    scalaVersion := "3.1.0-RC2",
    scalacOptions -= "-Xfatal-warnings",
    libraryDependencies ++= Seq(
        "org.scala-lang" % "scala-library" % "2.11.8",
        "org.typelevel" %% "cats-effect" % "3.2.9",
        // "org.typelevel" %% "cats-mtl" % "1.2.1",
        "org.typelevel" %% "cats-core" % "2.6.1"

    )
)

val shared = project.settings(commonSettings)
val server = project.settings(commonSettings).dependsOn(shared)
val client = project.settings(commonSettings).dependsOn(shared)

val root = project.in(file("."))
.settings(publish := {})
.aggregate(server, client, shared)