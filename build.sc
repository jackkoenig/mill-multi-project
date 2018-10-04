// build.sc
import mill._
import scalalib._

import $file.bar.build
import $file.foo.build

object bar2 extends bar.build.AbstractBar {
  def fooDep = bar.build.ModuleDep(foo.build.foo)
  override def millSourcePath = super.millSourcePath / ammonite.ops.up / 'bar / 'bar
}

object top extends ScalaModule {
  def scalaVersion = "2.12.4"
  override def moduleDeps = Seq(bar2)
}
