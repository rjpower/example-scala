name := "example-scala"
 
organization := "example"
  
version := "1.0-SNAPSHOT"
   
scalaVersion := "2.9.2"

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource

EclipseKeys.withSource := true

libraryDependencies ++= {
	Seq(
		"org.scalatest" %% "scalatest" % "2.0.M3" % "test"
	)
}

