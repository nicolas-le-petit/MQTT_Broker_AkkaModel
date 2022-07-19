//package Core.Connection
//
//import akka.actor.ActorRef
//import akka.stream.stage.GraphStageLogic.StageActor
//import akka.stream.stage.{GraphStage, GraphStageLogic, OutHandler, StageLogging}
//import akka.stream.{Attributes, Outlet, SourceShape}
//import akka.util.ByteString
//import com.keenworks.sample.sampleactorstage.SampleActorStage.AssignStageActor
//import shapeless.T
//
//import scala.collection.immutable.Queue
//
//class MessageSource(sourceFeeder: ActorRef) extends GraphStage[SourceShape[ByteString]] {
//  val out: Outlet[ByteString] = Outlet("MessageSource")
//  override val shape: SourceShape[ByteString] = SourceShape(out)
//
//  override def createLogic(inheritedAttributes: Attributes): GraphStageLogic =
//    new GraphStageLogic(shape) with StageLogging {
//      lazy val self: StageActor = getStageActor(onMessage)
//      var messages: Queue[ByteString] = Queue()//create a empty queue
//
//      setHandler(out, new OutHandler {
//        override def onPull(): Unit = {
//          log.info("onPull() called...")
//          pump()
//        }
//      })
//
//      private def pump(): Unit = {
//        if (isAvailable(out) && messages.nonEmpty) {
//          log.info("ready to dequeue")
//          messages.dequeue match {
//            case (msg: ByteString, newQueue: Queue[ByteString]) =>
//              log.info("got message from queue, pushing: {} ", msg)
//              push(out, msg)
//              messages = newQueue
//          }
//        }
//      }
//
//      override def preStart(): Unit = {
//        log.info("pre-starting stage, assigning StageActor to sourceFeeder")
//        sourceFeeder ! AssignStageActor(self.ref)
//      }
//
//      private def onMessage(x: (ActorRef, Any)): Unit =
//      {
//        x match {
//          case (_, msg: ByteString) =>
//            log.info("received msg, queueing: {} ", msg)
//            messages = messages.enqueue(msg)
//            pump()
//        }
//      }
//    }
//}
