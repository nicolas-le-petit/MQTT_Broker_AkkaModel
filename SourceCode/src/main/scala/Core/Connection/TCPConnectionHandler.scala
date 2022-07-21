//package Core.Connection
//
//package net.jetmq.infra
///*
//1st file
//purpose: open connect socket
// */
//
//import PacketHandler.Packet
//import akka.actor.Actor
//
//import java.net.InetSocketAddress
//import akka.io.Tcp.Received
//import akka.stream.{ActorMaterializer, Materializer}
//import akka.stream.scaladsl.{Sink, Source, Tcp}
//import akka.util.ByteString
//import play.api.libs.json._
//
//import scala.concurrent.ExecutionContext.Implicits.global
//
//
//class TCPConnectionHandler(remote: InetSocketAddress) extends Actor{
//
////  implicit val materializer = ActorMaterializer()(context.system)//deprecated
//  //DungTT
//  //modifying
//  implicit val materializer = Materializer(context)
//
//  val connection = Tcp(context.system).outgoingConnection(remote)
//
//  val source = Source.maybe[ByteString]
//
//  source
//    .map(x => x)
//    .via(connection)
//    .runWith(Sink.ignore)
//    .onComplete(x => {
//      print("[Warn] LogstashTcpConnection sending completed. Closing")
//      context.stop(self)
//    })
//
//  def receive = {
//    // if receive some msg
//    // reformat to json -> send to stream
//    case data: PacketTrace => {
//      implicit val fmt1 = PacketFormat
//      implicit val fmt2 = Json.format[PacketTrace]
//      val s: String = Json.toJson(data).toString() + "\n"
//      onNextBuffered(ByteString(s))
//    }
//
//    case data: LogstashMessage => {
//      implicit val fmt2 = Json.format[LogstashMessage]
//      val s: String = Json.toJson(data).toString() + "\n"
//      onNextBuffered(ByteString(s))
//    }
//
//    case Received(data) => {
//      println("[Info] LogstashTcpConnection received " + data)
//    }
//    /* https://doc.akka.io/api/akka/2.5/akka/stream/actor/ActorPublisherMessage$.html */
//    case Request(count) => {
//      println("[Info] LogstashTcpConnection Requested: " + count + " demand is " + totalDemand)
//      deliverBuffer()
//    }
//
//    case Cancel => {
//      println("[Info] LogstashTcpConnection was canceled")
//      context.stop(self)
//    }
//  }
//}
//
//case class LogstashMessage(level: String, source: String, log_class: String, message: String, cause: Option[String] = None)
//case class PacketTrace(source: String, in: Boolean, packet: Packet)
//object PacketFormat extends Format[Packet] {
//
//  def writes(p: Packet) = JsObject(Seq(
//    "type" -> JsString(p.getClass.getSimpleName),
//    "dup" -> JsBoolean(p.header.dup),
//    "qos" -> JsNumber(p.header.qos),
//    "retain" -> JsBoolean(p.header.retain)
//  ))
//
//  override def reads(json: JsValue): JsResult[Packet] = ???
//}
