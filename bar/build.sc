// build.sc
import mill._
import scalalib._

sealed trait IvyOrModule
case class IvyDep(dep: Dep) extends IvyOrModule
case class ModuleDep(dep: ScalaModule) extends IvyOrModule

object bar extends AbstractBar {
  def fooDep = IvyDep(ivy"com.jackkoenig::foo:0.0.1")
}

trait AbstractBar extends ScalaModule {

  def fooDep: IvyOrModule

  def scalaVersion = "2.12.4"
  def moduleDeps = Seq(fizz)

  object fizz extends ScalaModule {
    def scalaVersion = "2.12.4"
    def ivyDeps = T { fooDep match {
      case IvyDep(dep) => Agg(dep)
      case ModuleDep(_) => Agg()
    } }
    def moduleDeps = fooDep match {
      case ModuleDep(dep) => Seq(dep)
      case IvyDep(_) => Seq()
    }
    override def millSourcePath = bar.millSourcePath / ammonite.ops.up / 'fizz
  }
}

