// build.sc
import mill._
import scalalib._

import $file.bar.build
import $file.foo.build

object top extends ScalaModule {
  def scalaVersion = "2.12.4"
  override def moduleDeps = Seq(foo.build.foo, bar.build.bar)
}
