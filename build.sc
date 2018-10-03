// build.sc
import mill._
import scalalib._

import $file.bar.build
import $file.foo.build

object bar2 extends bar.build.BarCross(Some(foo.build.foo))

object top extends ScalaModule {
  def scalaVersion = "2.12.4"
  override def moduleDeps = Seq(foo.build.foo, bar2)
}
