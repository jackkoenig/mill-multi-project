// build.sc
import mill._
import scalalib._

object bar extends BarCross(None)

class BarCross(val fooDepOverride: Option[ScalaModule] = None) extends ScalaModule {
  def scalaVersion = "2.12.4"
  def ivyDeps = T { fooDepOverride match {
    case Some(_) => Agg()
    case None => Agg(ivy"com.jackkoenig::foo:0.0.1")
  } }
  def moduleDeps = fooDepOverride match {
    case Some(dep) => Seq(dep)
    case None => Seq()
  }
}
