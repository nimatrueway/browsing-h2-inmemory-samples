package io.github.nimatrueway.configurations

import play.api._
import play.core.DefaultWebCommands

object ApplicationBuilder {

  val testApplicationContext = ApplicationLoader.Context(
    environment = Environment.simple(),
    sourceMapper = None,
    webCommands = new DefaultWebCommands(),
    initialConfiguration = Configuration.load(Environment.simple(), Map("config.file" -> s"conf/application.test.conf"))
  )

  def build = new MyApplication(testApplicationContext).application

}