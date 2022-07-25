package Core.Connection

import PacketHandler.{Packet, PacketsHelper}
import Supporter.SupportFunction
import Supporter.SupportFunction.ByteStringConvert
import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import akka.io.Tcp
import akka.io.Tcp.{ConnectionClosed, Received, Write}
import akka.stream.OverflowStrategy
import akka.stream.scaladsl.Sink.queue
import akka.stream.scaladsl.Source
import akka.util.ByteString
import scodec.Attempt.Failure
import scodec.codecs.bytes

case class ReceivedPacket(packet: Packet)
case class SendingPacket(packet: Packet)
case class SendingTCP(packet: ByteString)
case object Closing

//this guy will handle the connection & communication with client via TCP
class PacketHandler(sessions: ActorRef, connection: ActorRef) extends Actor with ActorLogging{

  private var _packetCount = 0//count number of packet for each connection
  val mqtt = context.actorOf(Props(classOf[MqttConnectionActor], sessions), "MqttConnectionActor" + _packetCount)

  def receive = {

    case data: ByteString =>{
      _packetCount += 1
      log.info(s"Got packet number ${_packetCount}:" + data.toBitVector)

      //decode here
      val decodedPacket = PacketsHelper.decode(data.toBitVector)
      log.info("Data after decoding: " + decodedPacket)

      decodedPacket.foreach {
        case Left(p: Packet) => mqtt ! ReceivedPacket(p)
        case Right(f: Failure) => {
          log.error("failure occurs: " + f)
        }
      }
    }
    //this handles communicate with client
    case SendingPacket(p) => {
      val bits = PacketsHelper.encode(p)
      val envelope = ByteString(bits.require.toByteArray)
      log.info("Got in case SendingPacket" + envelope)
      connection ! Write(envelope)
    }

//    case Request
    case Closing => {
      println("Got in Closing")
      context.stop(self)
    }
  }
}






