package steve

import munit.CatsEffectSuite
import cats.Id

class ExecutorSpec extends CatsEffectSuite {
  val exec = Executor.instance[Either[Throwable, *]]

  test("Build empty image") {

    assertEquals(
      exec.build(Build.empty).flatMap(exec.run).map(_.getAll),
      Right(Map.empty),
    )
  }
}
