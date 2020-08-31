import sbt._

object Dependencies {
  val zioVersion = "1.0.0-RC17"

  val zio = "dev.zio" %% "zio" % "1.0.0-RC17"

  val scalaTestDep = "org.scalatest" %% "scalatest"    % "3.1.4"
  val zioTest      = "dev.zio"       %% "zio-test"     % zioVersion
  val zioTestSbt   = "dev.zio"       %% "zio-test-sbt" % zioVersion

  val compileDeps = Seq(zio).map(_                               % Compile)
  val testDeps    = Seq(scalaTestDep, zioTest, zioTestSbt).map(_ % Test)
}
