package broker

import Core.Connection.TCPConnectionManager
import akka.actor.{ActorRef, ActorSystem}
import akka.event.Logging

object Main extends App {

  val system = ActorSystem("Broker")

  val log = Logging.getLogger(system, this)
  log.info("Broker started...")
  TCPConnectionManager.run(system)
//  Server.run(system)
}
