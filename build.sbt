name := "sbt-ethereum-docs"

enablePlugins(TutPlugin)
tutTargetDirectory :=  new sbt.File("src/main/gitbook")

// To build docs:
// sbt tut && git commit -am "-" && git push
