package io.github.nimatrueway.configurations

import play.api.http._
import play.api.test._

import scala.concurrent.duration._

object TestHelpers extends PlayRunners
  with HeaderNames
  with Status
  with MimeTypes
  with HttpProtocol
  with DefaultAwaitTimeout
  with ResultExtractors
  with Writeables
  with EssentialActionCaller
  with RouteInvokers
  with FutureAwaits {
  override implicit def defaultAwaitTimeout = 1 day
}