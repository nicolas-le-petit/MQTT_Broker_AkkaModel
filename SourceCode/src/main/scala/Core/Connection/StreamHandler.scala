package Core.Connection

import akka.stream.{Attributes, FlowShape, Inlet, Outlet}
import akka.stream.stage.{AsyncCallback, GraphStage, GraphStageLogic, InHandler, OutHandler}
import akka.util.ByteString

import scala.collection.immutable.Queue
import scala.collection.mutable

//external system
object Injector {
  var callback: AsyncCallback[ByteString] = null
  def inject(m: ByteString) = {
    println("Go to inject")
    if (callback != null) {
      println("Got something")
      callback.invoke(m)
    }
  }
}
class InjectControl(injector: Injector.type) extends GraphStage[FlowShape[ByteString,ByteString]] {
  val inport = Inlet[ByteString]("input")
  val outport = Outlet[ByteString]("output")
  val shape = FlowShape.of(inport,outport)

  override def createLogic(inheritedAttributes: Attributes): GraphStageLogic =
    new GraphStageLogic(shape) {
//      var extMessage: ByteString = null
      var extMessage: Queue[ByteString] = Queue()
      override def preStart(): Unit = {
        println("preStart()...")
//        pull(inport)
        val callback = getAsyncCallback[ByteString] { m =>
          if (m != null){
            m match {
              //              case "Stop" => completeStage()
              case s: ByteString => {
                println("callback got ByteString: " + s)
//                extMessage = s
                extMessage = extMessage.enqueue(s)
              }
            }
            //              case msg: String => extMessage = msg
          }

        }
        injector.callback = callback
      }

      setHandler(inport, new InHandler {
        override def onPush(): Unit = {
          println("onPush()")
          if (extMessage != null) {
            println("InHandler got queue: " + extMessage)
//            push(outport,extMessage)
            extMessage = null// xóa buffer
          }
          else
            push(outport, grab(inport))
        }
      })
      setHandler(outport, new OutHandler {
        override def onPull(): Unit = pull(inport)
      })
    }

}