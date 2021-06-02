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

import zio.test._
import zio.test.environment.TestConsole
import zio.test.Assertion._
import zio._

object HelloWorldTest
    extends DefaultRunnableSpec(
      suite("HelloWorldSpec")(
        testM("sayHello correctly displays output") {
          for {
            name   <- ZIO.succeed("Shankar R C")
            _      <- TestConsole.feedLines(name)
            _      <- HelloWorld.sayHelloWorld
            output <- TestConsole.output
          } yield {
            assert(output)(equalTo(Vector("Hello! What is your name?\n", s"Hello, ${name}, welcome to ZIO!\n")))
          }
        }
      )
    )
