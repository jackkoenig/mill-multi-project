// build.sc
import mill._
import scalalib._
import ammonite.ops._

import $file.bar.build
import $file.foo.build

object bar2 extends bar.build.BarModule {
  override def ivyDeps = T { Agg() }
  override def moduleDeps = Seq(foo.build.foo)
  override def millSourcePath = super.millSourcePath / up / 'bar / 'bar
}

object top extends ScalaModule {
  def scalaVersion = "2.12.4"
  override def moduleDeps = Seq(bar2)
}
