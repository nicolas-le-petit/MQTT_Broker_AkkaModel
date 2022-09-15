package Session

import Core.Session._
import Test.UserTimer
import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.BeforeAndAfterAll
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

/*
@Brief: Test list below evaluates Event_Handler's functions
        Checking implementing pub/sub in various conditions
@Note : Work well - DungTT :)))
*/
class EventTest extends TestKit(ActorSystem("BusSpec")) with ImplicitSender
  with AnyWordSpecLike
  with Matchers
  with BeforeAndAfterAll  {

  "EventBus actor can do:" should {

    "simple pubsub - ok!" in {

      val bus = system.actorOf(Props[EventBusActor])

      bus ! BusSubscribe("greetings", self)
      bus ! BusPublish("time", "123")
      bus ! BusPublish("greetings", "hello")

      expectMsg(PublishPayload("hello", false))

      expectNoMessage(UserTimer.wait_time_50mil)
    }

    "SubscribeFunction: Multiple level wildcard (#) - ok!" in {

      val bus = system.actorOf(Props[EventBusActor])
      bus ! BusSubscribe("parent/f1/f2/#", self)
      bus ! BusPublish("parent/f1/f2/", "1")
      expectMsg(PublishPayload("1", false))

      bus ! BusPublish("parent/f1/f2/f3", "2")
      expectMsg(PublishPayload("2", false))

      bus ! BusPublish("parent/f1/f2/f3/f4", "3")
      expectMsg(PublishPayload("3", false))

      expectNoMessage(UserTimer.wait_time_50mil)
    }


    "SubscribeFunction: multilevel only with a wildcard - ok" in {

      val bus = system.actorOf(Props[EventBusActor])
      bus ! BusSubscribe("sport/tennis/player2", self)
      bus ! BusPublish("sport/tennis/player2", "1")
      expectMsg(PublishPayload("1", false))

      bus ! BusPublish("sport/tennis/player2/ranking", "2")

      expectNoMessage(UserTimer.wait_time_50mil)
    }

    "SubscribeFunction: square for parent level - ok" in {
      //“sport/#” also matches the singular “sport”, since # includes the parent level
      val bus = system.actorOf(Props[EventBusActor])
      bus ! BusSubscribe("parent/#", self)
      bus ! BusPublish("parent", "1")
      expectMsg(PublishPayload("1", false))

      expectNoMessage(UserTimer.wait_time_50mil)

      bus ! BusSubscribe("#", self)
      bus ! BusPublish("parent", "2")
      expectMsg(PublishPayload("2", false))

      expectNoMessage(UserTimer.wait_time_50mil)
    }

    "SubscribeFunction: sub all - ok" in {
      //“#” is valid and will receive every Application Message
      val bus = system.actorOf(Props[EventBusActor])
      bus ! BusSubscribe("#", self)
      bus ! BusPublish("parent", "1")
      expectMsg(PublishPayload("1", false))

      bus ! BusPublish("any", "2")
      expectMsg(PublishPayload("2", false))

      bus ! BusPublish("any/1/2/3/values", "3")
      expectMsg(PublishPayload("3", false))

      expectNoMessage(UserTimer.wait_time_50mil)
    }

    "is parent/f1/# a valid topic? - ok" in {
      //“sport/tennis/#” is valid

      val bus = system.actorOf(Props[EventBusActor])
      bus ! BusSubscribe("sport/tennis/#", self)
      bus ! BusPublish("sport/tennis/123", "1")
      expectMsg(PublishPayload("1", false))

      expectNoMessage(UserTimer.wait_time_50mil)
//      success
    }

//    "“sport/tennis#” is not valid" in {
//      MqttTopicClassificator.checkTopicName("sport/tennis#") must throwA[BadSubscriptionException]
//    }
//
//    "“sport/tennis/#/ranking”" in {
//
//      MqttTopicClassificator.checkTopicName("sport/tennis/#/ranking") must throwA[BadSubscriptionException]
//    }

    "SubscribeFunction: single level wildcard (+) - ok" in {
      val bus = system.actorOf(Props[EventBusActor])
      bus ! BusSubscribe("parent/f1/+", self)
      bus ! BusPublish("parent/f1/f2", "1")//correct
      expectMsg(PublishPayload("1", false))

      bus ! BusPublish("parent/f1/f2", "2")//correct
      expectMsg(PublishPayload("2", false))

      bus ! BusPublish("parent/f1/f2/f3", "3")//incorrect
      expectNoMessage(UserTimer.wait_time_50mil)
    }

    "SubscribeFunction: check no parent level for plus - ok" in {
      val bus = system.actorOf(Props[EventBusActor])
      bus ! BusSubscribe("parent/+", self)
      bus ! BusPublish("parent", "1")//incorrect
      expectNoMessage(UserTimer.wait_time_50mil)

      bus ! BusPublish("parent/", "2")//correct
      expectMsg(PublishPayload("2", false))
    }

    "SubscribeFunction: check level for double plus - ok" in {
      //“/parent” matches “+/+”
      val bus = system.actorOf(Props[EventBusActor])
      bus ! BusSubscribe("+/+", self)
      bus ! BusPublish("/parent", "1")
      expectMsg(PublishPayload("1", false))
    }

    "SubscribeFunction: check the same level - ok" in {
      //“/parent” matches “/+”"
      val bus = system.actorOf(Props[EventBusActor])
      bus ! BusSubscribe("/+", self)
      bus ! BusPublish("/finance", "1")
      expectMsg(PublishPayload("1", false))
    }

    "SubscribeFunction: chech different levels" in {
      //“/parent” does not match “+”
      val bus = system.actorOf(Props[EventBusActor])
      bus ! BusSubscribe("+", self)
      bus ! BusPublish("/parent", "1")
      expectNoMessage(UserTimer.wait_time_50mil)
    }

    "SubscribeFunction: check both (+) and (#)" in {
      //“+/tennis/#” is valid
      val bus = system.actorOf(Props[EventBusActor])
      bus ! BusSubscribe("+/f1/#", self)
      bus ! BusPublish("parent/f1/f2", "1")
      expectMsg(PublishPayload("1", false))

      bus ! BusPublish("otherparent/f1/f99", "2")
      expectMsg(PublishPayload("2", false))
    }

//    "sport+” is not valid" in {
//
//      MqttTopicClassificator.checkTopicName("sport+") must throwA[BadSubscriptionException]
//    }

    "SubscribeFunction: check (+) in a middle" in {
      //“sport/+/player1” is valid
      val bus = system.actorOf(Props[EventBusActor])
      bus ! BusSubscribe("parent/+/f2", self)
      bus ! BusPublish("parent/f1/f2", "1")
      expectMsg(PublishPayload("1", false))

      bus ! BusPublish("parent/f1/f2", "2")
      expectMsg(PublishPayload("2", false))
    }

    "PubSubFuntions: check retain function - ok" in {
      val bus = system.actorOf(Props[EventBusActor])
      //not published yet - fail
      bus ! BusSubscribe("game/score", self)
      expectNoMessage(UserTimer.wait_time_50mil)

      bus ! BusUnsubscribe("game/score", self)
      //publish with retain
      bus ! BusPublish("game/score", "1", true)

      bus ! BusSubscribe("game/score", self)
      expectMsg(PublishPayload("1", true))

      bus ! BusPublish("game/score", "2", true)
      expectMsg(PublishPayload("2", false))

      bus ! BusSubscribe("#", self)
      expectMsg(PublishPayload("2", true))//receive last value
    }

    "PubSubFuntions: check retain message + clean session - ok" in {
      val bus = system.actorOf(Props[EventBusActor])

      bus ! BusSubscribe("game/score", self)
      expectNoMessage(UserTimer.wait_time_50mil)

      bus ! BusUnsubscribe("game/score", self)

      bus ! BusPublish("game/score", "1", true)

      bus ! BusSubscribe("game/score", self)
      expectMsg(PublishPayload("1", true))

      bus ! BusPublish("game/score", "2", true)
      expectMsg(PublishPayload("2", false))

      bus ! BusPublish("game/score", "3", true, true)
      expectMsg(PublishPayload("3", false))

      bus ! BusUnsubscribe("game/score", self)

      bus ! BusSubscribe("game/score", self)
      expectNoMessage(UserTimer.wait_time_50mil)

      bus ! BusSubscribe("#", self)
      expectNoMessage(UserTimer.wait_time_50mil)

    }

    "SubFuntions: complex scenario with (#) - ok" in {
      val bus = system.actorOf(Props[EventBusActor])

      bus ! BusSubscribe("/#", self)
      expectNoMessage(UserTimer.wait_time_50mil)

      bus ! BusUnsubscribe("/Topic/C", self)
      expectNoMessage(UserTimer.wait_time_50mil)

      bus ! BusPublish("TopicA/B", "1", true)
      expectNoMessage(UserTimer.wait_time_50mil)

      bus ! BusPublish("TopicA/B", "2", false)
      expectNoMessage(UserTimer.wait_time_50mil)

      bus ! BusPublish("Topic/C", "3", true)
      expectNoMessage(UserTimer.wait_time_50mil)

      bus ! BusPublish("TopicA", "4", false)
      expectNoMessage(UserTimer.wait_time_50mil)

      bus ! BusPublish("/TopicA", "5", false)
      expectMsg(PublishPayload("5", false))

      bus ! BusSubscribe("Topic/C", self)
      expectMsg(PublishPayload("3", true))

      bus ! BusPublish("/TopicA", "6", true)
      expectMsg(PublishPayload("6", false))

      bus ! BusPublish("TopicA/C", "7", true)
      expectNoMessage(UserTimer.wait_time_50mil)

      bus ! BusPublish("/TopicA", "8", true)
      expectMsg(PublishPayload("8", false))

    }
  }
}
