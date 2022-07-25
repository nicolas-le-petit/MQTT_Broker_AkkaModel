package Core.Connection

import Core.Session.{EventBusActor, SessionsManagerActor}
import PacketHandler.{Packet, PacketsHelper}
import Supporter.SupportFunction.ByteStringConvert
import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}
import akka.io.{IO, Tcp}
import akka.io.Tcp.{Bind, Bound, CommandFailed, Connected, Register}
import akka.stream.{Graph, Materializer, SourceShape}
import scodec.Attempt.Failure
//import akka.stream.scaladsl.{Flow, Sink, Source, Tcp}
import akka.util.ByteString

import java.net.InetSocketAddress

import java.net.InetSocketAddress

import akka.actor.{ActorSystem, Props, Actor}
import akka.io.{Tcp, IO}
import akka.io.Tcp._
import akka.util.ByteString

class Server(address: String, port: Int) extends Actor {
  import context.system
  IO(Tcp) ! Bind(self, new InetSocketAddress(address, port))

  val eventHandler = system.actorOf(Props[EventBusActor], name = "eventHandler")//handle Events
  val sessionsManager = system.actorOf(Props(new SessionsManagerActor(eventHandler)), name = "sessionsManager")//manage Sessions

  implicit val mat: Materializer = Materializer(system)//implementor of blueprint
  println("Local host at :" + address + ":" + port)
  private var conn_count = 0

  override def receive: Receive = {
    case Bound(local) =>
      println(s"Server started on $local")
    case Connected(remote, local) =>
      conn_count += 1

      val handler = context.actorOf(Props(classOf[PacketHandler], sessionsManager, sender()), "PacketHandler" + conn_count)// as a handler
      val forwarder = context.actorOf(Props(classOf[TCPConnectionHandler], handler), "TCPConnectionHandler" + conn_count)// as a Publisher
//      val endpoint = system.actorOf(Props(classOf[EndPoint]), "EndPoint" + conn_count)
//    val forwarder = context.actorOf(Props(classOf[TCPConnectionHandler], endpoint), "TCPConnectionHandler" + conn_count)
      println(s"New connnection number $conn_count: $local -> $remote")
      sender() ! Register(forwarder, keepOpenOnPeerClosed = true)
  }
}


class TCPConnectionHandler (handler: ActorRef) extends ActorLogging with Actor {
  override def receive: Actor.Receive = {
    case Received(data) =>{
      val decoded = data.utf8String
//      sender() ! Write(ByteString(s"You told us: $decoded"))
      log.info(s"Get data: $decoded")
      handler ! ByteString(data)
    }
    case message: ConnectionClosed =>
      println(s"The connection $handler has been closed")
      context stop self
//    case msg: ByteString => {
//      log.info(s"Send back to device: $msg")
//      Tcp.Write(msg)
//    }
  }
}

//case class ReceivedPacket(packet: Packet)
//case class SendingPacket(packet: Packet)
//case object Closing
//class PacketHandler(sessions: ActorRef) extends ActorLogging with Actor{
//  private var _packetCount = 0 //count number of packet for each connection
//  val mqtt = context.actorOf(Props(classOf[MqttConnectionActor], sessions), "MqttConnectionActor" + _packetCount)
//
//  def receive = {
//          case data: ByteString => {
//            _packetCount += 1
//            log.info(s"Got packet number ${_packetCount}:" + data.toBitVector)
//            val decodedPacket = PacketsHelper.decode(data.toBitVector)
//            log.info("Data after decoding: " + decodedPacket)
//            decodedPacket.foreach {
//              case Left(p: Packet) => log.info("OK!")//mqtt ! ReceivedPacket(p)
//              case Right(f: Failure) => {
//                log.error("failure occurs: " + f)
//              }
//            }
//          }
//          case SendingPacket(p) => {
//            val bits = PacketsHelper.encode(p)
//            val envelope = ByteString(bits.require.toByteArray)
//            log.info("Got in case SendingPacket" + envelope)
//            sender() ! (envelope)
//          }
//          case Closing => {
//            //      complete(out)
//            //      onUpstreamFailure()
//            println("Got in Closing")
//            context.stop(self)
//          }
//          case message: ConnectionClosed =>
//            println("Connection has been closed")
//            context stop self
//        }
//
//}

//class EndPoint extends ActorLogging with Actor {
//  def receive = {
//    case msg: ByteString => {
//      log.info(s"Get ByteString $msg")
//    }
//  }
//}