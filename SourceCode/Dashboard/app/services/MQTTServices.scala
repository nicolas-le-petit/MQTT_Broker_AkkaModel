package services

import models.PayloadItem
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence
import org.eclipse.paho.client.mqttv3.{IMqttDeliveryToken, MqttCallback, MqttClient, MqttMessage}

import javax.inject.{Inject, Singleton}
import scala.util.{Failure, Success, Try}

/**
 * MQTT Services
 * This class supports all functions of MQTT protocol, which is developed base on MQTT Paho Client Library
 * Including: Subscribe/Publish/Connect
 */
object BrokerInfo{
  val url = "127.0.0.1"
  val port = 1883
}
@Singleton
class MQTTServices @Inject() (clientID: String) {

  //setting up to connect to Broker
  val brokerUrl = s"tcp://${BrokerInfo.url}:${BrokerInfo.port}"
  val persistence = new MemoryPersistence
  val client = new MqttClient(brokerUrl, clientID, persistence)
  var payloadsList: List[PayloadItem] = List()

  //subscribe function
  def subscribe(topic: String, qos: Int ): Unit = {
    //check if the device already connected to broker
    if (!client.isConnected()){
      client.connect()
      println(s"$clientID connecting to $brokerUrl ...")
    }

    client.subscribe(topic, qos)
    println(s"$clientID suscribed to $brokerUrl with topic $topic ...")

    val callback = new MqttCallback {
      override def deliveryComplete(token: IMqttDeliveryToken): Unit = {
        println("Delivery complete!")
      }

      override def connectionLost(cause: Throwable): Unit = {
        println("Connection to socket lost")
      }

      override def messageArrived(topic: String, message: MqttMessage): Unit = {
        val newPayload = new String(message.getPayload)
        println(s"SUBSCRIBE | $clientID | received message: $newPayload - TOPIC: $topic")
        payloadsList = new PayloadItem(clientID, topic, newPayload) :: payloadsList
      }
    }
    client.setCallback(callback)
  }

  def getUpdate: List[PayloadItem] = {
    /*payloadsList.foreach(i => {
      println(i.clientID)
      println(i.topic)
      println(i.payload)
    })*/
    payloadsList
  }

  //publish function
  def publish(topic: String, message: String, retain_flag: Boolean, qos: Int): Boolean = {
    //check if the device already connected to broker
    if (!client.isConnected()) {
      client.connect()
      println(s"CONNECT | $clientID | connect to broker: $brokerUrl ...")
    }

    val result = Try(client.getTopic(topic)) match {
      case Success(messageTopic) =>
        val mqttMessage = new MqttMessage(message.getBytes("utf-8"))
        mqttMessage.setRetained(retain_flag)
        mqttMessage.setQos(qos)

        Try(messageTopic.publish(mqttMessage)) match {
          case Success(r) =>
            println(s"PUBLISH | $clientID | sent message: ${r.getMessage}")
            true
          case Failure(exception) =>

            println(
              s"""
                 |An error occurred while trying to publish the message "$message" to $topic into $brokerUrl:
         """.stripMargin, exception)
            false
        }
      case Failure(exception) =>
        println(
          s"""
             |An error occurred while trying to publish the message "$message" to $topic into $brokerUrl:
         """.stripMargin, exception)
        false
    }
    result
  }
}
