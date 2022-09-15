package Support

import Connection.mqttRequest
import akka.actor.{Actor, ActorRef}
import akka.io.{IO, Tcp}

import java.net.InetSocketAddress

class clientSimulator(remote: InetSocketAddress, actorTest: ActorRef) extends Actor {

  import akka.io.Tcp._
  import context.system

  IO(Tcp) ! Connect(remote)

  def receive = {
    case CommandFailed(_: Connect) =>
      //listener ! "connect failed"
      context.stop(self)

    case c @ Connected(remote, local) =>
      println("Connected!")
      val connection = sender()
      connection ! Register(self)//binded here
      actorTest ! Register(self)

      //listener ! ConnectOK//listener ready to read msg
      context become {
        case mqttRequest(p) => //data from user
          //case p: ByteString =>
          println("Get request: " + p)
          connection ! Write(p)
        case Received(data) => //data from server
          println("received data:" + data)
          actorTest ! data//without this line, the actorTest doesnt know the msg this actor have gotten

        //unexpected cases
        case CommandFailed(w: Write) =>
          println("Failed to write request.")
        case "close" =>
          println("Closing connection")
          connection ! Close
        case _: ConnectionClosed =>
          println("Connection closed by server.")
          context stop self
      }
  }
}