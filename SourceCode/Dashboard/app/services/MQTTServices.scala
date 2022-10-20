package services

import models.{PayloadItem, TSData, data}
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence
import org.eclipse.paho.client.mqttv3.{IMqttDeliveryToken, MqttCallback, MqttClient, MqttMessage}

import javax.inject.{Inject, Singleton}
import scala.collection.mutable
import scala.util.{Failure, Success, Try}

/**
 * Subsribe services
 */
object BrokerInfo{
//  val url = "broker.mqttdashboard.com"
  val url = "127.0.0.1"
  val port = 1883
}
@Singleton
class MQTTServices @Inject() (clientID: String) {

  val brokerUrl = s"tcp://${BrokerInfo.url}:${BrokerInfo.port}"
  val persistence = new MemoryPersistence
//  val clientID = MqttClient.generateClientId()
  val client = new MqttClient(brokerUrl, clientID, persistence)
  var payloadsList: List[PayloadItem] = List()

  def subscribe(topic: String, qos: Int ): Unit = {

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
    payloadsList.foreach(i => {
      println(i.clientID)
      println(i.topic)
      println(i.payload)
    })
    payloadsList
  }

  def publish(topic: String, message: String): Boolean = {

    if (!client.isConnected()) {
      client.connect()
      println(s"CONNECT | $clientID | connect to broker: $brokerUrl ...")
    }

    val result = Try(client.getTopic(topic)) match {
      case Success(messageTopic) =>
        val mqttMessage = new MqttMessage(message.getBytes("utf-8"))
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
