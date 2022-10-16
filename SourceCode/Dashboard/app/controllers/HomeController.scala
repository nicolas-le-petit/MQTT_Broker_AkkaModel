package controllers

//import models.TSData
//import play.api.libs.json.Json
//import models.{DB, TSData}
import models.TSData
import play.api.mvc._
import services.{MQTTServices, PublishService, SubscribeService}

import javax.inject._
import scala.language.postfixOps

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents)(implicit assetsFinder: AssetsFinder)
  extends AbstractController(cc) {

  val server = "broker.mqttdashboard.com"
  val port = 1883
  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */

  //Home
  def index = Action {
    Redirect(routes.HomeController.listAllDevice)
  }

  //Introduction page
  def welcome = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.welcome("Welcome!"))
  }

  //Publish form
  def loadForm1(device_code: String) = Action { implicit request: Request[AnyContent] =>
    //create a new session here
    TSData.createSession(device_code)
    Ok(views.html.Form1("ok form", device_code))
  }

  //Publish function
  def MQTTpublishPOST = Action { implicit request: Request[AnyContent] =>
    val postVal = request.body.asFormUrlEncoded
    postVal.map { args =>
      val clientID = args("clientID").head
      val topic = args("topic").head
      val payload = args("payload").head
//      publisher.publish(server, port, clientID, topic, payload)
      //editing
      TSData.sessions(clientID).publish(topic, payload)
//      mqtt.publish(topic, payload)
      Ok(views.html.Form1(("ok form"), clientID))
    }.getOrElse(Ok("Opps!"))
  }

  //Subscribe form
  def loadForm2(device_code: String) = Action { implicit request: Request[AnyContent] =>
    //js code here
    TSData.createSession(device_code)
    Ok(views.html.Form2("OK", device_code))
  }

  def MQTTsubscribe = Action { implicit request: Request[AnyContent] =>
    val postVal = request.body.asFormUrlEncoded
    postVal.map { args =>
      val topic = args("subTopic").head
      val device_code = args("clientID").head
//      subscriber.subscribe(server, port, device_code, topic)
      //editing
      TSData.sessions(device_code).subscribe(topic)
//      mqtt.subscribe(topic)
      Ok(views.html.Form2("OK", device_code))
    }.getOrElse(Ok("Opps!"))
//    Redirect(routes.HomeController.loadForm2("Ok", clientID))
  }

  //for device management
  def loadCreateDevicePage = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.createDevice("Ok"))
  }

  def createDevice = Action { implicit request: Request[AnyContent] =>
    val postVal = request.body.asFormUrlEncoded
    postVal.map { args =>
      val device_name = args("device_name").head
      val device_code = args("device_code").head
      val device_des = args("device_description").head
      //      Ok(s"got 1 request to create $device_name with code $device_code")
      TSData.addItem(device_name,device_code, device_des)
      Redirect(routes.HomeController.listAllDevice)
    }.getOrElse(Ok("Opps!"))
  }

  def listAllDevice  = Action { implicit request: Request[AnyContent] =>
    val devicesList = TSData.getDeviceList()
    Ok(views.html.index("OK", devicesList))
  }

  def deleteDevice(device_code: String) = Action { implicit request: Request[AnyContent] =>
    TSData.deleteItem(device_code)
    Redirect(routes.HomeController.listAllDevice)
  }

  def loadEditDevicePage(device_code: String) = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.editDevice("Ok", device_code))
  }

  def editDevice = Action { implicit request: Request[AnyContent] =>
    val postVal = request.body.asFormUrlEncoded
    postVal.map { args =>
      val device_code_old = args("clientID_old").head
      val device_name = args("device_name").head
      val device_code = args("device_code").head
      val device_des = args("device_description").head
      TSData.editItem(device_code_old, device_name, device_code, device_des)
      Redirect(routes.HomeController.listAllDevice)
    }.getOrElse(Ok("Opps!"))
  }
}






