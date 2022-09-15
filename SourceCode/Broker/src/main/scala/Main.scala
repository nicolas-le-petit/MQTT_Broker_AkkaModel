package broker

import Core.Connection.{Server}
//import Core.Connection.{TCPConnectionManager}
import akka.actor.{ActorRef, ActorSystem, Props}
import akka.event.Logging

object Main extends App {
  val host = "127.0.0.1"
  val port = 8883
  val system = ActorSystem("Broker")

  val log = Logging.getLogger(system, this)
  log.info("Broker started...")
//  TCPConnectionManager.run(system)
  val server = system.actorOf(Props(classOf[Server], host, port), "Server")
}
