name := "albgorski-spray"

organization := "albgorski.spray"

version := "1.0.0"

scalaVersion := "2.11.6"

libraryDependencies ++= {
  val sprayVersion = "1.3.2"
  val akkaVersion = "2.3.10"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "io.spray" %% "spray-routing" % sprayVersion,
    "io.spray" %% "spray-can" % sprayVersion,
    "io.spray" %% "spray-httpx" % sprayVersion,
    "io.spray" %% "spray-json" % sprayVersion
  )
}

javaOptions in run ++= Seq(
  "-Xms1024m", "-Xmx1024m"
)

// Assembly settings
mainClass in Global := Some("albgorski.spray.Main")

assemblyJarName in assembly := s"${name.value}.jar"

fork in run := true