package io.github.nimatrueway.configurations

import play.api._
import play.api.inject._
import play.core.DefaultWebCommands

object ApplicationBuilder {

  implicit def getApplication[T <: MyTestApplication](t: T): Application = t.application

  val testApplicationContext = ApplicationLoader.Context(
    environment = Environment.simple(),
    sourceMapper = None,
    webCommands = new DefaultWebCommands(),
    initialConfiguration = Configuration.load(Environment.simple(), Map("config.file" -> s"conf/application.test.conf")),
    lifecycle = new DefaultApplicationLifecycle
  )

  def build = new MyApplicationComponents(testApplicationContext).application

  class MyTestApplication extends MyApplicationComponents(testApplicationContext) with MyApplicationComponents {
    override lazy val someService: SomeService = TestMocks.SomeServiceMocked
  }

}

object TestMocks {

  object SomeServiceMocked extends SomeService {
    override def giveAString: String = "MockedApplication"
  }

}