package controllers

//import models.TSData
//import play.api.libs.json.Json
//import models.{DB, TSData}
import models.TSData
import play.api.mvc._
import services.{PublishService, SubscribeService}

import javax.inject._
import scala.language.postfixOps

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents, subscriber: SubscribeService, publisher: PublishService)
                              (implicit assetsFinder: AssetsFinder)
  extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */

  val server = "broker.mqttdashboard.com"
  //  val server = "127.0.0.1"
  val port = 1883

  //Home
  def index = Action {
    Redirect(routes.HomeController.listAll)
  }

  //Introduction page
  def welcome = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.welcome("Welcome!"))
  }

  //Publish form
  def loadForm1(device_code: String) = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.Form1("ok form", device_code))
  }

  //Publish function
  def MQTTpublishPOST = Action { implicit request: Request[AnyContent] =>
    val postVal = request.body.asFormUrlEncoded
    postVal.map { args =>
      val clientID = args("clientID").head
      val topic = args("topic").head
      val payload = args("payload").head
      publisher.publish(server, port, topic, payload)
      Ok(views.html.Form1(("ok form"), clientID))
    }.getOrElse(Ok("Opps!"))
  }

  //Subscribe form
  def loadForm2 = Action { implicit request: Request[AnyContent] =>
    val deviceName = "device1"
    val topicList = TSData.getTopicList(deviceName)
    var data: Seq[String] = List()
    for (topic <- topicList) {
      data = TSData.getData(topic)
      //Redirect(routes.HomeController.loadForm2)
      /*val time = Calendar.getInstance().getTime()
      val formatTime = new SimpleDateFormat("HH:mm:ss")
      val currTime = formatTime.format(time)*/
    }
    Ok(views.html.Form2(topicList, data))
  }

  def getTopicSubscribe = Action { implicit request: Request[AnyContent] =>
    val postVal = request.body.asFormUrlEncoded
    val deviceName = "device1"
    postVal.map { args =>
      val topic = args("subTopic").head
      TSData.addTopic(deviceName, topic)
      Redirect(routes.HomeController.MQTTsubscribe(topic))
    }.getOrElse(Ok("Opps!"))
  }

  def MQTTsubscribe(topic: String) = Action { implicit request: Request[AnyContent] =>
    subscriber.subscribe(server, port, topic)
    Redirect(routes.HomeController.loadForm2)
  }

  def loadDevicePage = Action { implicit request: Request[AnyContent] =>
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
      Redirect(routes.HomeController.listAll)
    }.getOrElse(Ok("Opps!"))
  }

  def listAll  = Action { implicit request: Request[AnyContent] =>
    val devicesList = TSData.getDeviceList()
    Ok(views.html.index("OK", devicesList))
  }

  def deleteDevice(device_code: String) = Action { implicit request: Request[AnyContent] =>
    TSData.deleteItem(device_code)
    Redirect(routes.HomeController.listAll)
  }
}






