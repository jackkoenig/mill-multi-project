import mill._
import scalalib._
import publish._

object foo extends ScalaModule with PublishModule {
  def scalaVersion = "2.12.4"
  def publishVersion = "0.0.1"

  def pomSettings = PomSettings(
    description = "This is an example",
    organization = "com.jackkoenig",
    url = "https://github.com/jackkoenig/mill-multi-project",
    licenses = Seq(License.`Apache-2.0`),
    versionControl = VersionControl.github("jackkoenig", "mill-multi-project"),
    developers = Seq(
      Developer("jackkoenig", "Jack Koenig","https://github.com/jackkoenig")
    )
  )
}
