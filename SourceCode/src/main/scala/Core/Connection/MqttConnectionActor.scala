package Core.Connection

import Core.Session.{KeepAliveTimeout, WrongState}
import PacketHandler.{Connect, Disconnect, Header, Packet}
import akka.actor.{ActorLogging, ActorRef, ActorSystem, FSM}
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.language.postfixOps

sealed trait ConnectionState
case object Active extends ConnectionState
case object Waiting extends ConnectionState

sealed trait ConnectionBag
case class EmptyConnectionBag() extends ConnectionBag
case class ConnectionSessionBag(session: ActorRef, connection: ActorRef) extends ConnectionBag

class MqttConnectionActor(sessions: ActorRef) extends FSM[ConnectionState, ConnectionBag] with ActorLogging{

//  val log_actor = context.system.actorSelection("akka://jetmq/system/*LogstashTcpUploader")
  startWith(Waiting, EmptyConnectionBag())

  //here is the connected state
  when(Active) {
    //attribute packet
    case Event(p: Packet, bag: ConnectionSessionBag) => {
//      log_actor ! PacketTrace(self.path.toString, false, p)
      //send back the connection -> PacketHandler
      log.info("Got an attribute packet")
      bag.connection ! SendingPacket(p)
      stay
    }
    //when receive Connect packet when already connected
    case Event(ReceivedPacket(c: Connect), bag: ConnectionSessionBag) => {
      log.info("Unexpected Connect. Closing peer")
      bag.session ! Disconnect(Header(dup = false, qos = 0, retain = false))
      bag.connection ! Closing
      stay
    }
    //when receive disconnect packet
    case Event(ReceivedPacket(c: Disconnect), bag: ConnectionSessionBag) => {
      log.info("Disconnect. Closing peer")
      bag.session ! Disconnect(Header(dup = false, qos = 0, retain = false))
      bag.connection ! Closing
      stay
    }
    //when receive packet (in connected session) -> from TCP stream
    case Event(ReceivedPacket(c: Packet), bag: ConnectionSessionBag) => {
//      log_actor ! PacketTrace(self.path.toString, true, c)
      log.info("Got the TCP packet:")
      bag.session ! c
      stay
    }

    case Event(WrongState, b: ConnectionSessionBag) => {
      log.info("Session was in a wrong state")
      b.connection ! Closing
      stay
    }
    //when timeout
    case Event(KeepAliveTimeout, b: ConnectionSessionBag) => {
      log.info("Keep alive timed out. Closing connection")
      b.connection ! Closing
      stay
    }
  }
  //
  when(Waiting) {
    //when receive connect packet
    case Event(ReceivedPacket(c: Connect), _) => {
      log.info("Get connect Packet")
      implicit val timeout = Timeout(1 seconds)
      //ask for session
      val sessionF: Future[ActorRef] = ask(sessions, c).mapTo[ActorRef]//ask for a session/actor
      val session = Await.result(sessionF, timeout.duration)//

//      log_actor ! PacketTrace(self.path.toString, true, c)
      session ! c
      goto(Active) using ConnectionSessionBag(session, sender)
    }
    case x => {
      log.info("unexpected " + x + " for waiting. Closing peer")
      sender ! Closing
      stay
    }
  }

  whenUnhandled {
    case Event(x, _) => {
      log.error("unexpected " + x + " for " + stateName + ". Closing peer")
      sender ! Closing
      stay
    }
  }

  onTermination {
    case StopEvent(x, s, d) => {
      log.info("Terminated with " + x + " and " + s + " and " + d)
    }
  }

  onTransition(handler _)

  def handler(from: ConnectionState, to: ConnectionState): Unit = {
    log.info("State changed from " + from + " to " + to)
  }

  initialize()
}

object MqttConnectionActorTest extends App {
  val system = ActorSystem("MqttConnectionActorTest")

}

