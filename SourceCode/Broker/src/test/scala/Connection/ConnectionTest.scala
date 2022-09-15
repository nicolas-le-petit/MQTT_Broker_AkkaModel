package Connection

import Core.Connection.Server
import Support.clientSimulator
import Test.UserTimer.{one_sec, wait_time_500mil}
import akka.io.Tcp
import akka.io.Tcp.Register
import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit}
import akka.util.ByteString
import org.scalatest.BeforeAndAfterAll
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

import java.net.InetSocketAddress

trait requestPacket
case class ConnectOK(msg: String) extends requestPacket
case class mqttRequest(request: ByteString) extends requestPacket

class ConnectionTest extends TestKit(ActorSystem("BasicTest")) with ImplicitSender
                                                          with AnyWordSpecLike
                                                          with Matchers
                                                          with BeforeAndAfterAll {
  "Test list with Connecting Functions:" should {
    val host = "127.0.0.1"
    val port = 1883
    val connection = new InetSocketAddress(host, port)

    val server = system.actorOf(Props(classOf[Server], host, port), "TestServer")
    val client1 = system.actorOf(Props(classOf[clientSimulator], connection, testActor), "TestClient" + 1)
    Thread.sleep(500)

    "TCP connection is established successfully!" in {
      expectMsg(Register(client1))
    }

    "MQTT connection has been established successfully with 01 client!" in {
      client1 ! mqttRequest(packetList.connectPack1)
      expectMsg(wait_time_500mil,packetList.conackPack)
    }

    "MQTT connection has been established successfully with 02 clients!" in {
      val client2 = system.actorOf(Props(classOf[clientSimulator], connection, testActor), "TestClient" + 2)
      Thread.sleep(500)
      client2 ! mqttRequest(packetList.connectPack2)
      expectMsg(one_sec, Register(client2))
      expectMsg(one_sec, packetList.conackPack)
    }

    "MQTT connection has been established successfully with 03 clients!" in {
      val client3 = system.actorOf(Props(classOf[clientSimulator], connection, testActor), "TestClient" + 3)
      Thread.sleep(500)
      client3 ! mqttRequest(packetList.connectPack3)
      expectMsg(one_sec, Register(client3))
      expectMsg(one_sec, packetList.conackPack)
    }

    "MQTT connection has been established successfully with 04 clients!" in {
      val client4 = system.actorOf(Props(classOf[clientSimulator], connection, testActor), "TestClient" + 4)
      Thread.sleep(500)
      client4 ! mqttRequest(packetList.connectPack4)
      expectMsg(one_sec, Register(client4))
      expectMsg(one_sec, packetList.conackPack)
    }

    "MQTT connection has been established successfully with 05 clients!" in {
      val client5 = system.actorOf(Props(classOf[clientSimulator], connection, testActor), "TestClient" + 5)
      Thread.sleep(500)
      client5 ! mqttRequest(packetList.connectPack5)
      expectMsg(one_sec, Register(client5))
      expectMsg(one_sec, packetList.conackPack)
    }
  }
}
