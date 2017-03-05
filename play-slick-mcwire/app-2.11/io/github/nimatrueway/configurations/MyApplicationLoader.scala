package io.github.nimatrueway.configurations

import com.softwaremill.macwire._
import controllers.Assets
import io.github.nimatrueway.controllers.MainController
import io.github.nimatrueway.entities.{LoginLogDao, UserDao}
import play.api._
import play.api.db.HikariCPComponents
import play.api.db.evolutions.EvolutionsComponents
import play.api.db.slick.evolutions.SlickEvolutionsComponents
import play.api.db.slick.{DbName, SlickComponents}
import play.api.i18n.I18nComponents
import play.api.routing.Router
import router.Routes
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile

import scala.concurrent.ExecutionContext

class MyApplicationLoader extends ApplicationLoader {
  def load(context: ApplicationLoader.Context): Application = new MyApplication(context).application
}

class MyApplication(context: ApplicationLoader.Context) extends BuiltInComponentsFromContext(context) with MyApplicationComponents {
}

trait MyApplicationComponents extends BuiltInComponents
  with I18nComponents
  with MyApplicationModules
  with DatabaseModule
  with ConcurrencyModule
{
  private[this] val prefix: String = "/"
  lazy val assets: Assets = wire[Assets]
  lazy val router: Router = wire[Routes]
}

trait MyApplicationModules {
  def dbConfig: DatabaseConfig[JdbcProfile]
  def executionContext: ExecutionContext
  lazy val userDao = wire[UserDao]
  lazy val loginLogDao = wire[LoginLogDao]
  lazy val mainController = wire[MainController]
}

trait DatabaseModule extends HikariCPComponents with SlickComponents with EvolutionsComponents with SlickEvolutionsComponents {
  lazy val dbConfig: DatabaseConfig[JdbcProfile] = api.dbConfig[JdbcProfile](DbName("default"))
  applicationEvolutions.start()
}

trait ConcurrencyModule {
  lazy val executionContext = scala.concurrent.ExecutionContext.Implicits.global
}