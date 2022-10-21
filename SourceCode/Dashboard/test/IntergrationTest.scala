import org.scalatestplus.play._
import org.scalatestplus.play.guice.GuiceOneServerPerTest

/**
 * Runs a browser test using Fluentium against a play application on a server port.
 */
class IntergrationTest extends PlaySpec
  with OneBrowserPerTest
  with GuiceOneServerPerTest
  with HtmlUnitFactory {

  val topic = "test_topic"
  val msg = "test_msg"
  val clientID = "Client1"
  "Application" should {

    "load the PubSub form" in {

      go to (s"http://localhost:$port/device/listDevice" )
//      click on "pubTopic"
//      textField("pubTopic").value = topic
//      click on "pubPayload"
//      textField("pubPayload").value = msg
//      submit()
//      eventually{
//
//      }
      pageSource must include ("MQTT")
    }
  }
}