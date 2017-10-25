val commitAndPublishGitbook =
  taskKey[Unit]("Rebuilds the docs, commits the git repository, and pushes to publish the updated gitbook")

// This task tries to push even if there's nothing to commit.
// Best practice is to comment your commits: git commit -m "Your comment here"
// However, this task ensures any uncommitted changes are committed before publishing, including new files; it provides the comment as "-".
commitAndPublishGitbook := {
  import scala.language.postfixOps

  val dependOnTut: Seq[(File, String)] = tut.value

  "git add -A" #&& "git commit -m -" !

  println("git push origin master" !!)
}
