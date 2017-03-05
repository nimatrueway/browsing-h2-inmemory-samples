package io.github.nimatrueway.shared;

import org.h2.tools.Server;

import java.sql.SQLException;

public class H2ServerBuilder {

  public static Server start() {
    try {
      return Server.createTcpServer("-tcp","-tcpAllowOthers","-tcpPort","9092","-tcpDaemon").start();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

}
