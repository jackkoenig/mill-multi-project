
import bar._
import foo._

object Main extends App {
  val b = Bar(Foo("Hello!"))
  println(b)
}
