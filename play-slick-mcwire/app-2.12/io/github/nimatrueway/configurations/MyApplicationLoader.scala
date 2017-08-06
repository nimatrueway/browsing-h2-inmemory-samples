package io.github.nimatrueway.configurations

import io.github.nimatrueway.entities._
import io.github.nimatrueway.controllers.MainController
import _root_.controllers.AssetsComponents
import com.softwaremill.macwire._
import io.github.nimatrueway.services.{SomeService, SomeServiceImpl}
import play.api.ApplicationLoader.Context
import play.api._
import play.api.i18n._
import play.api.routing.Router
import router.Routes
import play.api.db.{DBApi, HikariCPComponents}
import play.api.db.evolutions.EvolutionsComponents
import play.api.db.slick.evolutions.SlickDBApi
import play.api.db.slick.{DbName, SlickComponents}
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
     with MyModules
     with DatabaseModule
{
  override def configuration: Configuration = super[BuiltInComponentsFromContext].configuration
  lazy val router: Router = {
    implicit val prefix = "/"
    wire[Routes]
  }
}

trait DatabaseModule extends HikariCPComponents with SlickComponents with EvolutionsComponents {
  lazy val dbConfig: DatabaseConfig[JdbcProfile] = slickApi.dbConfig[JdbcProfile](DbName("default"))
  lazy val dbApi: DBApi = SlickDBApi(slickApi)
  applicationEvolutions.start()
}