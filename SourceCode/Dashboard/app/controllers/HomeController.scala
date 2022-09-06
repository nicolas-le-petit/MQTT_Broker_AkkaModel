package controllers

//import models.TSData
//import play.api.libs.json.Json
//import models.{DB, TSData}
import javax.inject._
import play.api.mvc._
import services.MQTTSubscriber

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents, client: MQTTSubscriber) (implicit assetsFinder: AssetsFinder)
  extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def welcome = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.welcome("Welcome!"))
  }

  def mqtt = Action { implicit request: Request[AnyContent] =>
    Ok(client.MQTTSubscribe("broker.mqttdashboard.com",1883,"Greeting").toString)
//    Ok(client.MQTTSubscribe("127.0.0.1",1883,"Greeting").toString)
  }
//  def dataSet = Action {
//    val dataset = db.query[TSData].fetch()
//    Ok(Json.toJson(dataset))
//  }
//
//  def addData = Action(parse.json) { request =>
//    val data = db.save(request.body.as[TSData])
//    Ok(Json.toJson(data))
//  }
}
