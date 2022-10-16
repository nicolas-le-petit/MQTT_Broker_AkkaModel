package services

import controllers.routes
import models.TSData
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence
import org.eclipse.paho.client.mqttv3.{IMqttDeliveryToken, MqttCallback, MqttClient, MqttMessage}
import play.api.Configuration
import play.api.inject.ApplicationLifecycle
import play.api.mvc.{AbstractController, ControllerComponents}

import javax.inject.{Inject, Singleton}

/**
 * Subsribe services
 */
@Singleton
class SubscribeService @Inject() (cc: ControllerComponents, config: Configuration, appLifecycle: ApplicationLifecycle) extends AbstractController(cc) {

  def subscribe(url: String, port: Int, clientID: String, topic: String): Unit = {

    val brokerUrl = s"tcp://$url:$port"
    val persistence = new MemoryPersistence
    val client = new MqttClient(brokerUrl, clientID, persistence)
    client.connect()
    println(s"connecting to $brokerUrl ...")
    client.subscribe(topic)
    println(s"suscribed to $brokerUrl with topic $topic ...")

    val callback = new MqttCallback {

      override def deliveryComplete(token: IMqttDeliveryToken): Unit = {
        println("Delivery complete!")
      }

      override def connectionLost(cause: Throwable): Unit = {
        println("Connection to socket lost")
      }

      override def messageArrived(topic: String, message: MqttMessage): Unit = {
        println(s"A message arrived: ${new String(message.getPayload)} with topic $topic")
//        TSData.addData(topic, new String(message.getPayload))
        //        Redirect(routes.Assets.versioned("js/test.js"))
      }
    }

    client.setCallback(callback)
  }
}
