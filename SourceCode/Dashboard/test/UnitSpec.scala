import akka.actor.ActorSystem
import org.scalatestplus.play._
import services.MQTTServices

/**
 * Unit tests can run without a full Play application.
 */
class UnitSpec extends PlaySpec {

  val clientID = "Client1"
  val topic = "test_topic"
  val msg = "test_msg"

  "MQTTServices" should {

    "CONNECT and PUBLISH a message successfully" in {
      val actorSystem = ActorSystem("test")
      try {
        val MQTTclient = new MQTTServices(clientID)
        val result = MQTTclient.publish(topic, msg, true, 0)
        (result) must equal(true)
      } finally {
        // always shut down actor system at the end of the test.
        actorSystem.terminate()
      }
    }

    "CONNECT and SUBSCRIBE a message successfully" in {
      val actorSystem = ActorSystem("test")
      try {
        val MQTTclient = new MQTTServices(clientID)

        MQTTclient.subscribe(topic, 0)
        val result = MQTTclient.getUpdate
        result must equal(List())
      } finally {
        // always shut down actor system at the end of the test.
        actorSystem.terminate()
      }
    }
  }


}
