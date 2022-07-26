package Core.Connection

import Core.PacketHandler.{Packet, PacketsHelper}
import Core.Supporter.SupportFunction.ByteStringConvert
import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import akka.io.Tcp.Write
import akka.util.ByteString
import scodec.Attempt.Failure

case class ReceivedPacket(packet: Packet)
case class SendingPacket(packet: Packet)
case class SendingTCP(packet: ByteString)
case object Closing

/*
@Brief: This actor acts like an router
        Receiving the raw packet (ByteString) from TCP and encode -> MqttConnectionActor
        Receiving the responds and send to devices via TCP
@Note : None
*/
class PacketHandler(sessions: ActorRef, connection: ActorRef) extends Actor with ActorLogging{

  private var _packetCount = 0//count number of packet for each connection
  val mqtt = context.actorOf(Props(classOf[MqttConnectionActor], sessions), "MqttConnectionActor" + _packetCount)

  def receive = {
    //get ByteString from TCP
    case data: ByteString =>{
      _packetCount += 1
      log.info(s"Got packet number ${_packetCount}:" + data.toBitVector)
      //decode here
      val decodedPacket = PacketsHelper.decode(data.toBitVector)
      log.info("Data after decoding: " + decodedPacket)
      //check the packet's format -> error if they're not mqtt format
      decodedPacket.foreach {
        case Left(p: Packet) => mqtt ! ReceivedPacket(p)
        case Right(f: Failure) => {
          log.error("Invalid packet: " + f)
        }
      }
    }
    //receive response and send to device here
    case SendingPacket(p) => {
      val bits = PacketsHelper.encode(p)
      val envelope = ByteString(bits.require.toByteArray)
      log.info("Got in case SendingPacket" + envelope)
      connection ! Write(envelope)
    }
    case Closing => {
      println("Got in Closing")
      context.stop(self)
    }
  }
}






