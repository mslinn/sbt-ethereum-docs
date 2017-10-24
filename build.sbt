// Documentation source (markdown and html) must be placed in the docs/ directory
// Tut writes output (for gitbook) to the gitbook/ directory
//
// To build and publish docs:
// sbt tut && git commit -am - && git push

name := "sbt-ethereum-docs"

enablePlugins(TutPlugin)
tutTargetDirectory := new File("gitbook")
tutSourceDirectory := new File("docs")
