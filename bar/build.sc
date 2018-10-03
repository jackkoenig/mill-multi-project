// build.sc
import mill._
import scalalib._

object bar extends BarModule

trait BarModule extends ScalaModule {
  def scalaVersion = "2.12.4"
  override def ivyDeps = Agg(ivy"com.jackkoenig::foo:0.0.1")
}
