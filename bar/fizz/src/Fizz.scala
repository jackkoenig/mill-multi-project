
package fizz

import foo._

case class Fizz(foo: Foo = Foo("hello"))

object Main extends App {
  println(Fizz())
}
