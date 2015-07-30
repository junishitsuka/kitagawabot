libraryDependencies +=
  "net.databinder" %% "dispatch-http" % "0.8.8"

libraryDependencies +=
  "com.github.scala-incubator.io" %% "scala-io-file" % "0.3.0"

libraryDependencies ++= {
  val liftVersion = "2.4"
    Seq(
        "net.liftweb" %% "lift-webkit" % liftVersion % "compile",
        "net.liftweb" %% "lift-mapper" % liftVersion % "compile",
        "org.mortbay.jetty" % "jetty" % "6.1.26" % "test",
        "junit" % "junit" % "4.7" % "test",
        "ch.qos.logback" % "logback-classic" % "0.9.26",
        "org.scala-tools.testing" %% "specs" % "1.6.9" % "test",
        "com.h2database" % "h2" % "1.2.147"
       )
}
