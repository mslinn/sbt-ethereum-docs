name := "sbt-ethereum-docs"

enablePlugins(TutPlugin)
tutTargetDirectory :=  new sbt.File(".")

// Documentation source is in src/main/tut
// Output, for gitbook, is written to the root directory
//
// To build and publish docs:
// sbt tut && git commit -am "-" && git push
