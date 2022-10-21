import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
 * Functional tests start a Play application internally, available
 * as `app`.
 */

class RoutingSpec extends PlaySpec with GuiceOneAppPerSuite {

  "Routes" should {

    "send 404 on a bad request" in  {
      route(app, FakeRequest(GET, "/boum")).map(status(_)) mustBe Some(NOT_FOUND)
    }

    "send 200 on a good request" in  {
      route(app, FakeRequest(GET, "/welcome")).map(status(_)) mustBe Some(OK)
    }

    "send 303 on a good request but redirect to another site" in {
      route(app, FakeRequest(GET, "/")).map(status(_)) mustBe Some(SEE_OTHER)
    }

  }
}
