addSbtPlugin("org.tpolecat" % "tut-plugin" % "0.5.5")

// only necessary while using a SNAPSHOT version of sbt-ethereum
resolvers += ("snapshots" at "https://oss.sonatype.org/content/repositories/snapshots")
addSbtPlugin("com.mchange" % "sbt-ethereum" % "0.0.2-SNAPSHOT")
