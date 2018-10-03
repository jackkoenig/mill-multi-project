// build.sc
import mill._
import scalalib._

object bar extends BarCross(None)

class BarCross(val fooDepOverride: Option[ScalaModule] = None) extends ScalaModule {
  def scalaVersion = "2.12.4"
  def ivyDeps = fooDepOverride match {
    case Some(_) => Agg(ivy"org.scalatest::scalatest:3.0.1") // Agg() doesn't work, arbitrary and unused
    case None => Agg(ivy"com.jackkoenig::foo:0.0.1")
  }
  def moduleDeps = fooDepOverride match {
    case Some(dep) => Seq(dep)
    case None => Seq()
  }
}
