
package bar

import foo._

case class Bar(foo: Foo)

object Main extends App {
  val bar = Bar(Foo("Hello World!"))
  println(bar)
}
