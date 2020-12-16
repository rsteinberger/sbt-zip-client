
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
lazy val pluginZipTask = taskKey[Unit]("Run a plugin task to zip a directory")
lazy val libTask = taskKey[Unit]("Run a library function to modify a file")
lazy val pluginLibTask = taskKey[Unit]("Run a library function to modify a file")
lazy val runTasks = taskKey[Unit]("Run tasks")

lazy val root = (project in file("."))
    .enablePlugins(ZipPlugin)
  	.settings(
		name := "sbt-zip-client",
	    scalaVersion := "2.12.11",
    	version := "0.1",

    	// Used in the zipTask
    	sourceZipDir := file(dataInPath),
	    targetZipDir := file(dataOutPath),

	    // Used in the pluginLibTask
	    sourceDataName := dataInPath + "/data.txt"
  	)

// Run the tasks in sequence
runTasks := Def.sequential(
	localTask, 
	libTask, 
	pluginLibTask,
	pluginZipTask
).value

// Copy the data file to the staging folder
localTask := {
	println("localTask...")
	val sourcePath = Paths.get(dataPath + "/test.txt");
    val targetPath = Paths.get(dataInPath + "/data.txt");
	Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING)
}

// Modify the data file
// Making a call directly to the library dependency
// Configured in the client project/build.sbt
libTask := {
	println("libTask...")
	val libFileClass = new LibFileClass()
	val file = new File(dataInPath + "/data.txt")
	println("file size before: " + file.length())
	libFileClass.libFileAppendFunction(Array(file), "Client")
	println("filesize after: " + file.length())
}

// Modify the data file
// Making a call to the library dependency through the plugin
// Configured in the plugin build.sbt
pluginLibTask := {
	libCall.value
}

// zip the dataIn folder into dataOut
// Making a call to the plugin zipTask
pluginZipTask := {
	zip.value
}

