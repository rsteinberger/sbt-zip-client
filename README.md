# sbt-zip-client

## This prototype demonstrates four sbt build configuration tasks

1. Create and run a local build task to copy files (localTask)
2. Create and run a local build task which calls a function on a library dependency to modify a file (libTask)
3. Reference and run a task on an sbt plugin to call the same library dependency to modify a file (pluginLibTask)
4. Reference and run a task on an sbt plugin to zip a folder (pluginZipTask)

The tasks are configured, in build.sbt, to run sequentially to simulate the movement and modification of a data file in a production build process

## The projects

Three projects are use to configure the prototype

## sbt-zip-app 

Acts as the library dependency containg functions and processes to be called from the client app during the build

## sbt-zip-plugin 

Is the sbt plugin

## sbt-zip-client 

Uses the two dependency projects to demonstrate possible production configurations

##  Installed Software Versions

### SBT

```
C:\Home\git>sbt -version
sbt version in this project: 1.4.1
sbt script version: 1.4.4
```

### Scala

```
C:\Home\git>sbt scalaVersion
2.12.11
```

### Java

```
C:\Home\git>java -version
java version "15.0.1" 2020-10-20
Java(TM) SE Runtime Environment (build 15.0.1+9-18)
Java HotSpot(TM) 64-Bit Server VM (build 15.0.1+9-18, mixed mode, sharing)
```

# Build and Publish the sbt-zip-client Dependencies

__Note that the projects must be published in the order presented__

Clone all three projects

1. sbt-zip-app
2. sbt-zip-plugin
3. sbt-zip-client

## sbt-zip-app

### Enter the sbt shell

```
C:\Home\git\sbt-zip-app>sbt
[info] welcome to sbt 1.4.4 (Oracle Corporation Java 15.0.1)
[info] loading global plugins from C:\Users\rsteinberger\.sbt\1.0\plugins
[info] loading project definition from C:\Home\git\sbt-zip-app\project
[info] loading settings for project root from build.sbt ...
[info] set current project to sbt-zip-app (in build file:/C:/Home/git/sbt-zip-app/)
[info] sbt server started at local:sbt-server-a8184c675a5f7b1e8a88
[info] started sbt server
sbt:sbt-zip-app>
```

### Compile

```
sbt:sbt-zip-app> compile
[success] Total time: 0 s, completed Dec 15, 2020, 1:07:55 PM
```

### Publish Locally

```
sbt:sbt-zip-app> publishLocal
[info] Wrote C:\Home\git\sbt-zip-app\target\scala-2.12\sbt-zip-app_2.12-0.1-SNAPSHOT.pom
[info] Main Scala API documentation to C:\Home\git\sbt-zip-app\target\scala-2.12\api...
model contains 6 documentable templates
[info] Main Scala API documentation successful.
[info] :: delivering :: com.demo.app#sbt-zip-app_2.12;0.1-SNAPSHOT :: 0.1-SNAPSHOT :: integration :: Tue Dec 15 13:08:04 EST 2020
[info]  delivering ivy file to C:\Home\git\sbt-zip-app\target\scala-2.12\ivy-0.1-SNAPSHOT.xml
[info]  published sbt-zip-app_2.12 to C:\Users\rsteinberger\.ivy2\local\com.demo.app\sbt-zip-app_2.12\0.1-SNAPSHOT\poms\sbt-zip-app_2.12.pom
[info]  published sbt-zip-app_2.12 to C:\Users\rsteinberger\.ivy2\local\com.demo.app\sbt-zip-app_2.12\0.1-SNAPSHOT\jars\sbt-zip-app_2.12.jar
[info]  published sbt-zip-app_2.12 to C:\Users\rsteinberger\.ivy2\local\com.demo.app\sbt-zip-app_2.12\0.1-SNAPSHOT\srcs\sbt-zip-app_2.12-sources.jar
[info]  published sbt-zip-app_2.12 to C:\Users\rsteinberger\.ivy2\local\com.demo.app\sbt-zip-app_2.12\0.1-SNAPSHOT\docs\sbt-zip-app_2.12-javadoc.jar
[info]  published ivy to C:\Users\rsteinberger\.ivy2\local\com.demo.app\sbt-zip-app_2.12\0.1-SNAPSHOT\ivys\ivy.xml
[success] Total time: 2 s, completed Dec 15, 2020, 1:08:04 PM
sbt:sbt-zip-app>
```

## sbt-zip-plugin

### Enter the sbt shell

```
C:\Home\git\sbt-zip-plugin>sbt
[info] welcome to sbt 1.4.4 (Oracle Corporation Java 15.0.1)
[info] loading global plugins from C:\Users\rsteinberger\.sbt\1.0\plugins
[info] loading settings for project sbt-zip-plugin-build from plugins.sbt ...
[info] loading project definition from C:\Home\git\sbt-zip-plugin\project
[info] loading settings for project root from build.sbt ...
[info] set current project to sbt-zip-plugin (in build file:/C:/Home/git/sbt-zip-plugin/)
[info] sbt server started at local:sbt-server-0cf296b269452ad8d520
[info] started sbt server
```

### Compile

```
sbt:sbt-zip-plugin> compile
[success] Total time: 0 s, completed Dec 15, 2020, 1:15:19 PM
```

### Publish Locally

```
sbt:sbt-zip-plugin> publishLocal
[info] Wrote C:\Home\git\sbt-zip-plugin\target\scala-2.12\sbt-1.0\sbt-zip-plugin-0.1-SNAPSHOT.pom
[info] :: delivering :: com.demo.app#sbt-zip-plugin;0.1-SNAPSHOT :: 0.1-SNAPSHOT :: integration :: Tue Dec 15 13:15:26 EST 2020
[info]  delivering ivy file to C:\Home\git\sbt-zip-plugin\target\scala-2.12\sbt-1.0\ivy-0.1-SNAPSHOT.xml
[info]  published sbt-zip-plugin to C:\Users\rsteinberger\.ivy2\local\com.demo.app\sbt-zip-plugin\scala_2.12\sbt_1.0\0.1-SNAPSHOT\poms\sbt-zip-plugin.pom
[info]  published sbt-zip-plugin to C:\Users\rsteinberger\.ivy2\local\com.demo.app\sbt-zip-plugin\scala_2.12\sbt_1.0\0.1-SNAPSHOT\jars\sbt-zip-plugin.jar
[info]  published sbt-zip-plugin to C:\Users\rsteinberger\.ivy2\local\com.demo.app\sbt-zip-plugin\scala_2.12\sbt_1.0\0.1-SNAPSHOT\srcs\sbt-zip-plugin-sources.jar
[info]  published sbt-zip-plugin to C:\Users\rsteinberger\.ivy2\local\com.demo.app\sbt-zip-plugin\scala_2.12\sbt_1.0\0.1-SNAPSHOT\docs\sbt-zip-plugin-javadoc.jar
[info]  published ivy to C:\Users\rsteinberger\.ivy2\local\com.demo.app\sbt-zip-plugin\scala_2.12\sbt_1.0\0.1-SNAPSHOT\ivys\ivy.xml
[success] Total time: 0 s, completed Dec 15, 2020, 1:15:26 PM
sbt:sbt-zip-plugin>
```

## ivy2 Local Repo

```
C:\Users\...\.ivy2\local\com.demo.app

/sbt-zip-app_2.12
/sbt-zip-plugin
```

## sbt-zip-client

### Enter the sbt shell

```
C:\Home\git\sbt-zip-client>sbt
[info] welcome to sbt 1.4.4 (Oracle Corporation Java 15.0.1)
[info] loading global plugins from C:\Users\rsteinberger\.sbt\1.0\plugins
[info] loading settings for project sbt-zip-client-build from build.sbt,plugins.sbt ...
[info] loading project definition from C:\Home\git\sbt-zip-client\project
[info] loading settings for project root from build.sbt ...
[info] set current project to sbt-zip-client (in build file:/C:/Home/git/sbt-zip-client/)
[info] sbt server started at local:sbt-server-031466a930485fb075ff
[info] started sbt server
```

### Compile

```
sbt:sbt-zip-client> compile
[success] Total time: 0 s, completed Dec 16, 2020, 11:18:12 AM
```

### runTasks

```
sbt:sbt-zip-client> runTasks
localTask...
libTask...
file size before: 10
libFileAppendFunction called with: Client
filesize after: 17
pluginLibTask...
file size before: 17
libFileAppendFunction called with: Plugin
filesize after: 24
pluginZipTask...
[success] Total time: 0 s, completed Dec 16, 2020, 5:33:39 PM
sbt:sbt-zip-client>
```



