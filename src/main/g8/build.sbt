import Dependencies._

ThisBuild / organization := "$organisation$"
ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file(".")).
  settings(
    name := "$name$",
    libraryDependencies ++= Seq(
      log4jSlf4j,
      log4jCore,
      log4jTemplateJson,
      lambdaCore,
      $if(use_sqs_event.truthy)$
      lambdaJavaEvents,
      $endif$
      scalaTest % Test
    )
  )
(assembly / assemblyJarName) := "$name$.jar"

scalacOptions ++= Seq("-Wunused:imports", "-Werror")

(assembly / assemblyMergeStrategy) := {
  case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
  case _ => MergeStrategy.first
}

