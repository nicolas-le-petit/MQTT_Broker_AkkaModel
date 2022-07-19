package Core.Connection

import PacketHandler.{Packet, PacketsHelper}
import Supporter.SupportFunction.ByteStringConvert
import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import akka.stream.OverflowStrategy
import akka.stream.scaladsl.Sink.queue
import akka.stream.scaladsl.Source
import akka.util.ByteString
import scodec.Attempt.Failure
import scodec.codecs.bytes

case class ReceivedPacket(packet: Packet)
case class SendingPacket(packet: Packet)
case object Closing

//this guy will handle the connection & communication with client via TCP
class PacketHandler(sessions: ActorRef) extends Actor with ActorLogging{

  private var _packetCount = 0//count number of packet for each connection
  val mqtt = context.actorOf(Props(classOf[MqttConnectionActor], sessions), "MqttConnectionActor" + _packetCount)

  def receive = {

    case data: ByteString =>{
      _packetCount += 1
      log.info("Got packet number: " + _packetCount)
      //this is raw data which is wrapped in ByteString
      //need to be decode to bits
//      val packets = PacketsHelper.decode(data.toBitVector)
//      println("Content packet: " + data)
//      println("From client number: " +  self)
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

      Injector.inject(envelope)

//      println("Ops, suy luận đúng rồi!")
//      Source(envelope)
//      onNextBuffered(envelope)
    }

//    case Request
    case Closing => {
//      complete(out)
//      onUpstreamFailure()
      println("Got in Closing")
      context.stop(self)
    }


    /*case any: Any => {
      println("Got others" + any)
      context.stop(self)
    }

    case x => {
      println("x")
      context.stop(self)
    }

    case data: String =>{
      println("Got String" + data)
      context.stop(self)
    }

    case message: ConnectionClosed => {
      println("Connection has been closed")
      context.stop(self)
    }*/
  }
}


