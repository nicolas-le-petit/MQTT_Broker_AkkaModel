import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.http.Status
import play.api.test.FakeRequest
import play.api.test.Helpers._

class RenderingSpec extends PlaySpec with GuiceOneAppPerSuite {
    "HomeController" should {
      val device_code = "Client1"
      "render the HOME PAGE successfully!" in {
        val home = route(app, FakeRequest(GET, "/")).get

        status(home) mustBe Status.SEE_OTHER
        contentType(home) mustBe None
        contentAsString(home) must include ("")
      }

      "render the PUBSUB FORM successfully!" in {
        val home = route(app, FakeRequest(GET, "/form/" + device_code)).get

        status(home) mustBe Status.OK
        contentType(home) mustBe Some("text/html")
        contentAsString(home) must include("FormMQTT")
      }

      "render the CREATE DEVICE FORM successfully!" in {
        val home = route(app, FakeRequest(GET, "/device/loadDevicePage")).get

        status(home) mustBe Status.OK
        contentType(home) mustBe Some("text/html")
        contentAsString(home) must include("CREATE NEW DEVICE")
      }

      "render the EDIT DEVICE FORM successfully!" in {
        val home = route(app, FakeRequest(GET, "/device/edit/" + device_code)).get

        status(home) mustBe Status.OK
        contentType(home) mustBe Some("text/html")
        contentAsString(home) must include("EDIT DEVICE")
      }

      "render the LIST DEVICE PAGE successfully!" in {
        val home = route(app, FakeRequest(GET, "/device/listDevice")).get

        status(home) mustBe Status.OK
        contentType(home) mustBe Some("text/html")
        contentAsString(home) must include("MQTT DASH BOARD")
      }

    }
}
