package services

import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence
import org.eclipse.paho.client.mqttv3.{MqttClient, MqttMessage}
import play.api.Configuration
import play.api.inject.ApplicationLifecycle

import javax.inject.{Inject, Singleton}
import scala.util.{Failure, Success, Try}
/**
 * PublishService
 */
@Singleton
class PublishService @Inject() (config: Configuration, appLifecycle: ApplicationLifecycle){

//  def publish(url: String, port: Int, topic:String, message: String): Boolean = {
  def publish(url: String, port: Int, clientID: String, topic:String, message: String): Boolean = {
    val brokerUrl = s"tcp://$url:$port"
    val persistence = new MemoryPersistence
//    val client = new MqttClient(brokerUrl, MqttClient.generateClientId(), persistence)
    val client = new MqttClient(brokerUrl, clientID, persistence)

    client.connect()
    val result = Try(client.getTopic(topic)) match {
      case Success(messageTopic) =>
        val mqttMessage = new MqttMessage(message.getBytes("utf-8"))
        Try(messageTopic.publish(mqttMessage)) match {
          case Success(r) =>
            println(s"Published: ${r.getMessage}")
            true
          case Failure(exception) =>

            println(
              s"""
                 |An error occurred while trying to publish the message "$message" to $topic into $brokerUrl:
         """.stripMargin, exception)
            false
        }
      case Failure(exception) =>
        println(s"""
                   |An error occurred while trying to publish the message "$message" to $topic into $brokerUrl:
         """.stripMargin, exception)
        false
    }
    client.disconnect()
    result
  }
}