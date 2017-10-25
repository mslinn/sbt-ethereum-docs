// Tut is configured to read documentation source (markdown and html) from the docs/ directory, and to
// write output (for gitbook) to the gitbook/ directory, which will automatically be created if required.
// DO NOT MANUALLY PUT ANYTHING IN THE gitbook/ DIRECTORY.

name := "sbt-ethereum-docs"
scalaVersion := "2.12.4"

enablePlugins(TutPlugin)
tutTargetDirectory := new File("gitbook")
tutSourceDirectory := new File("docs")


//// The remainder of this file enables and configures sbt-ethereum

resolvers ++= Seq(
  "Typesafe releases"   at "http://repo.typesafe.com/typesafe/releases/",
  "Sonatype releases"   at "https://oss.sonatype.org/service/local/staging/deploy/maven2",
  "Sonhatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
)

val commitAndPublishGitbook =
  taskKey[Unit]("Rebuilds the docs, commits the git repository, and pushes to publish the updated gitbook")

// This task tries to push even if there's nothing to commit
commitAndPublishGitbook := {
  val dependOnTut: Seq[(File, String)] = tut.value
  "git commit -am -".!

  // See https://stackoverflow.com/a/20922141/553865
  println("git push origin HEAD".!!) // push the current branch to the same name on the remote
}

