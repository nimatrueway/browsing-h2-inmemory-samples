package io.github.nimatrueway.specs

import io.github.nimatrueway.configurations._
import org.scalatestplus.play.PlaySpec
import play.api.test.FakeRequest

import TestHelpers._
import io.github.nimatrueway.controllers.routes

class MainSpec extends PlaySpec {

  "nimaLoginCount() should return nima's loginCounts after all evolutions-scripts are applied" in {
    H2ServerBuilder.start
    val getStudentsFakeRequest = FakeRequest(routes.MainController.nimaLoginCount())
    val resultFuture = route(new MyTestApplication, getStudentsFakeRequest).get
    status(resultFuture) mustEqual OK
    contentAsString(resultFuture) mustEqual "5"
  }

  "Test mocking modules" in {
    val getStudentsFakeRequest = FakeRequest(routes.MainController.someServiceService())
    val resultFuture = route(new MyTestApplication, getStudentsFakeRequest).get
    status(resultFuture) mustEqual OK
    contentAsString(resultFuture) mustEqual "MockedApplication"
  }

}
