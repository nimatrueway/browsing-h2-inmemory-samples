package io.github.nimatrueway.configurations

import org.h2.tools.Server

object H2ServerBuilder {
  def start = Server.createTcpServer ("-tcp", "-tcpAllowOthers", "-tcpPort", "9092", "-tcpDaemon").start()
}
