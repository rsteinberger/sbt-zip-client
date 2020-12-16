
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption

import com.demo.app.ZipPlugin
import com.demo.app.LibClass
import com.demo.app.LibFileClass

lazy val dataPath = "/Home/git/sbt-zip-client/data"
lazy val dataInPath = "/Home/git/sbt-zip-client/dataIn"
lazy val dataOutPath = "/Home/git/sbt-zip-client/dataOut"

lazy val localTask = taskKey[Unit]("Run a local task to copy a file")
lazy val pluginTask = taskKey[Unit]("Run a plugin task to zip a directory")
lazy val libTask = taskKey[Unit]("Run a library function to modify a file")
lazy val runTasks = taskKey[Unit]("Run tasks")

lazy val root = (project in file("."))
    .enablePlugins(ZipPlugin)
  	.settings(
		name := "sbt-zip-client",
	    scalaVersion := "2.12.11",
    	version := "0.1",
    	sourceZipDir := file(dataInPath),
	    targetZipDir := file(dataOutPath)
  	)

// Run the tasks in sequence
runTasks := Def.sequential(
	localTask, 
	libTask, 
	pluginTask
).value

// Copy the data file to the staging folder
localTask := {
	println("Local Task...")
	val sourcePath = Paths.get(dataPath + "/test.txt");
    val targetPath = Paths.get(dataInPath + "/data.txt");
	Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING)
	println("")
}

// Modify the data file
libTask := {
	println("Lib Task...")
	val libFileClass = new LibFileClass()
	val file = new File(dataInPath + "/data.txt")
	println("file size before: " + file.length())
	libFileClass.libFileAppendFunction(Array(file))
	println("filesize after: " + file.length())
	println("")
}

// zip the dataIn folder into dataOut
pluginTask := {
	zip.value
}


