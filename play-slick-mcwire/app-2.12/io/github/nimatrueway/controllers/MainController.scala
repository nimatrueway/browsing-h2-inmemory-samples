package io.github.nimatrueway.controllers

import io.github.nimatrueway.entities.{LoginLogDao, UserDao}
import io.github.nimatrueway.services.SomeService
import play.api.mvc._
import slick.basic.DatabaseConfig
import slick.jdbc.JdbcProfile

import scala.concurrent.ExecutionContext

class MainController(
  controllerComponents: ControllerComponents,
  executionContext: ExecutionContext,
  dbConfig: DatabaseConfig[JdbcProfile],
  userDao: UserDao,
  loginLogDao: LoginLogDao,
  someService: SomeService
) {

  val actionBuilder = DefaultActionBuilder(controllerComponents.parsers.defaultBodyParser)(executionContext)
  implicit val ec = executionContext
  import dbConfig.profile.api._

  def nimaLoginCount = actionBuilder.async {
    val query = userDao.query.filter(_.username === "nima") joinLeft loginLogDao.query on { (user, loginLog) =>
      user.id === loginLog.userId
    } length
    val queryResult = query.result
    val loginCountFuture = dbConfig.db.run(queryResult)

    loginCountFuture map { loginCount =>
      Results.Ok(s"${loginCount}")
    }
  }

  def someServiceService() = actionBuilder {
    Results.Ok(someService.giveAString)
  }

}
