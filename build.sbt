import com.demo.app.ZipPlugin
import com.demo.app.LibClass

lazy val root = (project in file("."))
    .enablePlugins(ZipPlugin)
  	.settings(
		name := "sbt-zip-client",
	    scalaVersion := "2.12.11",
    	version := "0.1",
    	sourceZipDir := file("/Home/git/sbt-zip-client/dataIn"),
	    targetZipDir := file("/Home/git/sbt-zip-client/dataOut/zip")
  	)


/*
	Case One
	Create and run a local task
*/

lazy val localTask = taskKey[Unit]("Run a local task")
localTask := {
	println("Local Task Complete")
}
(compile in Compile) := ((compile in Compile) dependsOn localTask).value

/*
	Case Two
	Create a local task to call a function on a library dependency
*/

val functionCall = taskKey[Unit]("Run a library function")
functionCall := {
	val libClass = new LibClass(Array())
	libClass.libFunction()
}
(compile in Compile) := ((compile in Compile) dependsOn functionCall).value

/*
	Case Three
	Call a task on an sbt plugin
*/

(compile in Compile) := ((compile in Compile) dependsOn zip).value



