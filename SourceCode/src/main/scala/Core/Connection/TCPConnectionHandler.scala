//package Core.Connection
//
//import Core.Session.{EventBusActor, SessionsManagerActor}
//import PacketHandler.{Packet, PacketsHelper}
//import Supporter.SupportFunction.ByteStringConvert
//import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}
//import akka.io.Tcp.{Bind, Bound, CommandFailed, Connected, Register}
//import akka.stream.scaladsl.{Flow, Sink, Source, Tcp}
//import akka.stream.{Graph, Materializer, SourceShape}
//import scodec.Attempt.Failure
////import akka.stream.scaladsl.{Flow, Sink, Source, Tcp}
//import akka.util.ByteString
//
//import java.net.InetSocketAddress
//
////import java.net.InetSocketAddress
//
////open a socket here
//
//object TCPConnectionManager {
//
//  private val _host = "127.0.0.1"
//  private val _port = 1883
//  private var _count = 0
//  def run(system: ActorSystem): Unit ={
//
//    val eventHandler = system.actorOf(Props[EventBusActor], name = "eventHandler")//handle Events
//    val sessionsManager = system.actorOf(Props(new SessionsManagerActor(eventHandler)), name = "sessionsManager")//manage Sessions
//
//    implicit val mat: Materializer = Materializer(system)//implementor of blueprint
//
//    println("Local host at :" + _host + ":" + _port)
//    Tcp(system).bind(_host, _port).to(Sink.foreach{
//      connection =>
//        _count += 1
//        println("New client number " + _count + ": " + connection.remoteAddress)
//        //  val mqtt = context.actorOf(Props(classOf[MqttConnectionActor], sessions), "name")
//        val handler = system.actorOf(Props(classOf[PacketHandler], sessionsManager), "PacketHandler" + _count)
//        val graph = new InjectControl(Injector)
//        val flow = Flow.fromGraph(graph)
//
//        val queue = Source.maybe[ByteString]
//          .via(connection.flow)
////          .via(flow)
//
//          .to(Sink.foreach(handler ! _))
//          .run() // in order to "keep" the queue Materialized value instead of the Sink's
//
//    }).run()
//}
//}