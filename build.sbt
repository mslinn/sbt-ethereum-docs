// Tut is configured to read documentation source (markdown and html) from the docs/ directory, and to
// write output (for gitbook) to the gitbook/ directory.
//
// To build and publish docs, type:
// sbt tut && git commit -am - && git push

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

libraryDependencies ++= Seq(
  "com.mchange" %% "consuela" % "0.0.3-SNAPSHOT"
)

// You must define an environment variable called INFURA_TOKEN in order for this project to work
ethJsonRpcUrl := s"http://mainnet.infura.io/${ sys.env("INFURA_TOKEN") }"
//ethJsonRpcUrl := "http://192.168.10.49:8545"

ethPackageScalaStubs := "eth.anyone.contract"
