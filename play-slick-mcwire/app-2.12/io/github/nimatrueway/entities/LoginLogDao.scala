package io.github.nimatrueway.entities

import com.github.tototoshi.slick.GenericJodaSupport
import org.joda.time.DateTime
import slick.basic.DatabaseConfig
import slick.jdbc.JdbcProfile

class LoginLogDao(val dbConfig: DatabaseConfig[JdbcProfile], val userDao: UserDao) {
  import dbConfig.profile.api._
  val query = TableQuery[LoginLogTable]
  val jodaSupport = new GenericJodaSupport(dbConfig.profile)
  import jodaSupport._

  class LoginLogTable(tag: Tag) extends Table[LoginLog](tag, "LoginLogs") {
    import dbConfig.profile.api._

    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def userId = column[Long]("user_id")
    def loginTime = column[DateTime]("login_time")

    def * = (id, userId, loginTime) <> ((LoginLog.apply _).tupled, LoginLog.unapply)
    def user = foreignKey("LoginLog_User_FK", userId, TableQuery[userDao.UserTable])(_.id)
  }
}

case class LoginLog (
  id: Long,
  userId: Long,
  loginTime: DateTime
)