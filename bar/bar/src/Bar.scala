
package bar

import fizz._

case class Bar(fizz: Fizz)

object Main extends App {
  val bar = Bar(Fizz())
  println(bar)
}
