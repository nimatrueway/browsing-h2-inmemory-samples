package io.github.nimatrueway.controllers

import javax.swing.JOptionPane

import io.github.nimatrueway.entities.{LoginLogDao, UserDao}
import play.api.mvc._
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile

import scala.concurrent.ExecutionContext
import scala.io.StdIn

class MainController(
  executionContext: ExecutionContext,
  dbConfig: DatabaseConfig[JdbcProfile],
  userDao: UserDao,
  loginLogDao: LoginLogDao
) {

  import dbConfig.driver.api._

  def nimaLoginCount = Action.async {
    implicit val ec = executionContext

    val query = userDao.query.filter(_.username === "nima") joinLeft loginLogDao.query on { (user, loginLog) =>
      user.id === loginLog.userId
    } length
    val queryResult = query.result
    val loginCountFuture = dbConfig.db.run(queryResult)

    loginCountFuture map { loginCount =>
      Results.Ok(s"${loginCount}")
    }
  }

}
