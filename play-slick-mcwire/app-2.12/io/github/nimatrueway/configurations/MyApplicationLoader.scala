package io.github.nimatrueway.configurations

import io.github.nimatrueway.entities._
import io.github.nimatrueway.controllers.MainController
import _root_.controllers.AssetsComponents
import com.softwaremill.macwire._
import play.api.ApplicationLoader.Context
import play.api._
import play.api.i18n._
import play.api.routing.Router
import router.Routes
import play.api.db.{DBApi, HikariCPComponents}
import play.api.db.evolutions.EvolutionsComponents
import play.api.db.slick.evolutions.SlickDBApi
import play.api.db.slick.{DbName, SlickComponents}
import play.api.mvc.{ControllerComponents, DefaultControllerComponents}
import slick.basic.DatabaseConfig
import slick.jdbc.JdbcProfile

class MyApplicationLoader extends ApplicationLoader {
  def load(context: ApplicationLoader.Context): Application = new MyApplicationComponents(context).application
}

class MyApplicationComponents(context: Context)
  extends BuiltInComponentsFromContext(context)
     with AssetsComponents
     with I18nComponents
     with play.filters.HttpFiltersComponents
     with MyApplicationModules
     with DatabaseModule
{
  private[this] lazy val prefix = "/"
  override def configuration: Configuration = super[BuiltInComponentsFromContext].configuration
  lazy val router: Router = wire[Routes]
}

trait MyApplicationModules { this: BuiltInComponentsFromContext with DatabaseModule =>
  lazy val userDao = wire[UserDao]
  lazy val loginLogDao = wire[LoginLogDao]
  lazy val mainController = wire[MainController]
}

trait DatabaseModule extends HikariCPComponents with SlickComponents with EvolutionsComponents {
  lazy val dbConfig: DatabaseConfig[JdbcProfile] = slickApi.dbConfig[JdbcProfile](DbName("default"))
  lazy val dbApi: DBApi = SlickDBApi(slickApi)
  applicationEvolutions.start()
}