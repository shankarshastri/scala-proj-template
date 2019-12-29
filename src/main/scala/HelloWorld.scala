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

import java.io.IOException

import zio._
import zio.console._

object HelloWorld extends App {

  def sayHelloWorld: ZIO[zio.ZEnv, Nothing, Int] = {
    val program: ZIO[Console, IOException, Unit] =
      for {
        _    <- putStrLn("Hello! What is your name?")
        name <- getStrLn
        _    <- putStrLn(s"Hello, ${name}, welcome to ZIO!")
      } yield ()
    program.fold(_ => 0, _ => 1)
  }

  override def run(args: List[String]): ZIO[zio.ZEnv, Nothing, Int] = sayHelloWorld

}
