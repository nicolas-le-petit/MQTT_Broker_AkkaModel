package Session

import Connection.mqttRequest
import Core.Connection.Server
import Core.Session.PublishPayload
import Support.clientSimulator
import Test.UserTimer.wait_time_500mil
import akka.io.Tcp.Register
//import Core.PacketHandler.Connect
import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.BeforeAndAfterAll
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

import java.net.InetSocketAddress

class BasicTest extends TestKit(ActorSystem("BasicTest")) with ImplicitSender
                                                          with AnyWordSpecLike
                                                          with Matchers
                                                          with BeforeAndAfterAll {
  "Test list with Basic Functions:" should {
    val host = "127.0.0.1"
    val port = 1883
    val connection = new InetSocketAddress(host, port)

    val server = system.actorOf(Props(classOf[Server], host, port), "TestServer")
    val client1 = system.actorOf(Props(classOf[clientSimulator], connection, testActor), "TestClient" + 1)
    Thread.sleep(500)//to create actor client1 and join TCP

    "TCP connection is established successfully!" in {
      expectMsg(Register(client1))
    }

    "MQTT connection has been established successfully with client!" in {
      client1 ! mqttRequest(packetList.connectPack1)
      expectMsg(wait_time_500mil, packetList.conackPack)
    }

    "Client SUBSCRIBE a topic and get subACK!" in {
      client1 ! mqttRequest(packetList.subPack1)
      expectMsg(wait_time_500mil,packetList.subACK1)
    }

    "Client PUBLISH a topic (qos = 1) and get pubACK!" in {
      client1 ! mqttRequest(packetList.pubPack1)
      expectMsg(wait_time_500mil, packetList.pubACK1)
    }

    "Client PUBLISH a topic (qos = 2) and process 04 steps!" in {
      client1 ! mqttRequest(packetList.pubPack2)
      client1 ! mqttRequest(packetList.pubrel2)
      expectMsg(wait_time_500mil, packetList.pubrec2)
      expectMsg(wait_time_500mil, packetList.pubcomp2)
    }

  }
}
