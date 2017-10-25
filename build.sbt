// Tut is configured to read documentation source (markdown and html) from the docs/ directory, and to
// write output (for gitbook) to the gitbook/ directory, which will automatically be created if required.
// DO NOT MANUALLY PUT ANYTHING IN THE gitbook/ DIRECTORY.

name := "sbt-ethereum-docs"
scalaVersion := "2.12.4"

enablePlugins(TutPlugin)
tutTargetDirectory := new File("gitbook")
tutSourceDirectory := new File("docs")

resolvers ++= Seq(
  "Typesafe releases"  at "http://repo.typesafe.com/typesafe/releases/",
  "Sonatype releases"  at "https://oss.sonatype.org/service/local/staging/deploy/maven2",
  "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
)

val commitAndPublishGitbook = taskKey[Unit]("Rebuilds the docs, commits the git repository, and pushes to publish the updated gitbook")

// a minor annoyance:
// this task won't push if there's nothing to commit,
// because 'git commit' yields a nonzero exit code in that case.
commitAndPublishGitbook := {
  val dependOnTut = tut.value
  "git commit -am -" #&& "git push" !
}


