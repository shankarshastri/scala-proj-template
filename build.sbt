/*
 * Copyright 2019 Shankar R C
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import Dependencies._
import sbt.Keys.{ resolvers, version }
import sbt.addCommandAlias

lazy val commands = List(
  "clean",
  "bloopInstall",
  "headerCheck",
  "scalastyle",
  "scalafmtCheckAll",
  "compile:scalafix",
  "test:scalafix",
  "shield",
  "test"
)
lazy val root = project
  .in(file("."))
  .settings(
    name := "scala-proj-template",
    version := "0.1",
    startYear := Some(2019),
    crossScalaVersions := Seq("2.12.10", "2.13.11"),
    organizationName := "Shankar R C",
    licenses += ("Apache-2.0", new URL("https://www.apache.org/licenses/LICENSE-2.0.txt")),
    scalacOptions ++= Seq("-Yrangepos", "-Ywarn-unused"),
    scalaVersion := "2.12.10",
    libraryDependencies ++= compileDeps ++ testDeps,
    shieldFatalWarnings := true,
    addCommandAlias("cat", commands.mkString(";")),
    testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
  )
  .enablePlugins(AutomateHeaderPlugin)
