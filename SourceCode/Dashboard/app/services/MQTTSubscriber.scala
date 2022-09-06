package services

import play.api.Configuration

import javax.inject._
//import play.Configuration
import org.eclipse.paho.client.mqttv3._
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence
import play.api.Logger
import play.api.inject.ApplicationLifecycle

import scala.concurrent.Future

/**
 * MQTT Subscriber
 * Based on the implementation by Shivansh in the
 * scala-mqtt-client-raspberrypi-starter-kit project.
 *
 * This class will connect to a MQTT broker when the application
 * starts. Connection settings are defined in application.conf,
 * and the default is to connect to a local mosquitto server.
 *
 * @author Stanley Yeh
 * @mail tamago.stan@gmail.com
 */
@Singleton
class MQTTSubscriber @Inject() (config: Configuration, appLifecycle: ApplicationLifecycle) {
  //class MQTTSubscriber @Inject() (appLifecycle: ApplicationLifecycle) extends AbstractController{
//  val url = config.get[String]("mqtt-broker.url")
//  val port = config.get[Int]("mqtt-broker.port")
   def MQTTSubscribe(url: String, port: Int, topic: String): Unit = {

    val brokerUrl = s"tcp://$url:$port"
    val persistence = new MemoryPersistence
//    val log: Logger = Logger(this.getClass())

    println(s"Connecting to broker at $url")

    try {
      val client = new MqttClient(brokerUrl, MqttClient.generateClientId, persistence)
      client.connect()
      client.subscribe(topic)
      val callback = new MqttCallBackImpl
      client.setCallback(callback)

      // When the application starts, register a stop hook with the
      // ApplicationLifecycle object. The code inside the stop hook will
      // be run when the application stops.
      appLifecycle.addStopHook { () =>
        client.disconnect()
        client.close()
        println(s"MQTT Subscriber: Closing MQTT connection...")
        Future.successful(())
      }

    } catch {
      case me: MqttException => {
        println(s"MqttException: " + me.getReasonCode())
        println(me.getMessage)
      }
    }
  println(s"MQTT Subscriber: Connected to broker at $url")
}


  /*def mqtt() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }*/
}

class MqttCallBackImpl extends MqttCallback {
  val log: Logger = Logger(this.getClass())
  override def messageArrived(topic: String, message: MqttMessage): Unit = {
    println(s"Receiving Data | Topic : $topic | Message : $message")
  }

  override def connectionLost(cause: Throwable): Unit = {
    println(cause.toString)
  }

  override def deliveryComplete(token: IMqttDeliveryToken): Unit = {
    println(s"Delivered Message :${token.getMessage}")
  }
}
