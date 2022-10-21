package controllers

import models.TSData
import play.api.mvc._

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject._
import scala.language.postfixOps

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents)(implicit assetsFinder: AssetsFinder)
  extends AbstractController(cc) {
  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */

  def loadForm(device_code: String) = Action {
    TSData.createSession(device_code)
    Ok(views.html.Form("Load form PubSub successfully!", device_code))
  }
  //Home
  def index = Action {
    Redirect(routes.HomeController.listAllDevice)
  }

  //Introduction page
  def welcome = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.welcome("Welcome!"))
  }

  //Publish function
  def MQTTpublishPOST = Action { implicit request: Request[AnyContent] =>
    val postVal = request.body.asFormUrlEncoded
    postVal.map { args =>
      val clientID = args("PubClientID").head
      val topic = args("pubTopic").head
      val payload = args("pubPayload").head
      val _retain = args("retain_flag").head
      var retain = false
      if (_retain == "true"){
        retain = true
      }
      else {
        retain = false
      }
      val qos = args("pubQos").head.toInt
      TSData.sessions(clientID).publish(topic, payload, retain, qos)
      Ok(views.html.Form(("MQTT publish successfully!"), clientID))
    }.getOrElse(Ok("Opps!"))
  }

  //for subscribing
  def MQTTsubscribe = Action { implicit request: Request[AnyContent] =>
    val postVal = request.body.asFormUrlEncoded
    postVal.map { args =>
      val topic = args("subTopic").head
      val device_code = args("SubClientID").head
      val qos = args("subQos").head.toInt
      TSData.sessions(device_code).subscribe(topic, qos)
      Ok(views.html.Form("MQTT subscribe successfully!", device_code))
    }.getOrElse(Ok("Opps!"))
  }

  def updatePayload(device_code: String) = Action { implicit request: Request[AnyContent] =>
    val dataUpdate = TSData.sessions(device_code).getUpdate
    val topicUpdated = dataUpdate.head.topic
    val payloadUpdated = dataUpdate.head.payload
    val date = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy").format(LocalDateTime.now)

    TSData.sessions(device_code).payloadsList = List()//clear buffer
    Ok(s"$topicUpdated\n$payloadUpdated\n$date")
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
      TSData.addItem(device_name,device_code, device_des)
      Redirect(routes.HomeController.listAllDevice)
    }.getOrElse(Ok("Opps!"))
  }

  def listAllDevice  = Action { implicit request: Request[AnyContent] =>
    val devicesList = TSData.getDeviceList()
    Ok(views.html.index("List all device successfully!", devicesList))
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






