
import bar._
import fizz._
import foo._

object Main extends App {
  println(Bar(Fizz(Foo("Hello!"))))
}
