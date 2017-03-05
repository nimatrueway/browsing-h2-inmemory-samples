package io.github.nimatrueway.entities

import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile

class UserDao(val dbConfig: DatabaseConfig[JdbcProfile]) {
  import dbConfig.driver.api._
  val query = TableQuery[UserTable]

  class UserTable(tag: Tag) extends Table[User](tag, "Users") {
    import dbConfig.driver.api._

    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def username = column[String]("username")
    def passwordHash = column[String]("password_hash")

    def * = (id, username, passwordHash) <> ((User.apply _).tupled, User.unapply)
  }
}

case class User (
  id: Long,
  username: String,
  passwordHash: String
)