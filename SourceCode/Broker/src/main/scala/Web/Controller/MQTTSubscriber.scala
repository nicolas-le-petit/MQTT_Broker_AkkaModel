//package services
//
//import akka.actor.ActorLogging
//import play.api.Logging
//
//import javax.inject._
////import play.Configuration
//import play.api.Logger
//import play.api.inject.ApplicationLifecycle
//
//import scala.concurrent.Future
//import org.eclipse.paho.client.mqttv3._
//import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence
//
///**
// * MQTT Subscriber
// * Based on the implementation by Shivansh in the
// * scala-mqtt-client-raspberrypi-starter-kit project.
// *
// * This class will connect to a MQTT broker when the application
// * starts. Connection settings are defined in application.conf,
// * and the default is to connect to a local mosquitto server.
// *
// * @author Stanley Yeh
// * @mail tamago.stan@gmail.com
// */
//@Singleton
////class MQTTSubscriber @Inject() (config: Configuration, appLifecycle: ApplicationLifecycle) {
//class MQTTSubscriber @Inject() (appLifecycle: ApplicationLifecycle) extends Logging{
////  val url = config.getString("mqtt-broker.url")
////  val port = config.getInt("mqtt-broker.port")
//  val url = "127.0.0.1"
//  val port = 1883
//
//  val brokerUrl = s"tcp://$url:$port"
//  val topics = Array("Lobby", "DeviceStat")
//  val persistence = new MemoryPersistence
//  val log: Logger = Logger(this.getClass())
//
//  try {
//    val client = new MqttClient(brokerUrl, MqttClient.generateClientId, persistence)
//    client.connect()
//    client.subscribe(topics)
//    val callback = new MqttCallBackImpl
//    client.setCallback(callback)
//
//    // When the application starts, register a stop hook with the
//    // ApplicationLifecycle object. The code inside the stop hook will
//    // be run when the application stops.
//    appLifecycle.addStopHook { () =>
//      client.disconnect()
//      client.close()
//      log.info(s"MQTT Subscriber: Closing MQTT connection...")
//      Future.successful(())
//    }
//  } catch {
//    case me: MqttException => {
//      log.info(s"MqttException: " + me.getReasonCode())
//      log.info(me.getMessage)
//    }
//  }
//  log.info(s"MQTT Subscriber: Connected to broker at $url")
//}
//
//class MqttCallBackImpl extends MqttCallback {
//  val log: Logger = Logger(this.getClass())
//  override def messageArrived(topic: String, message: MqttMessage): Unit = {
//    log.info(s"Receiving Data | Topic : $topic | Message : $message")
//  }
//
//  override def connectionLost(cause: Throwable): Unit = {
//    log.info(cause.toString)
//  }
//
//  override def deliveryComplete(token: IMqttDeliveryToken): Unit = {
//    log.info(s"Delivered Message :${token.getMessage}")
//  }
//}
