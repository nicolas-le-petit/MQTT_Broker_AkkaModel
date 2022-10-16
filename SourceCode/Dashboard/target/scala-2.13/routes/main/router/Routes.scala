// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  webjars_Routes_0: webjars.Routes,
  // @LINE:8
  HomeController_0: controllers.HomeController,
  // @LINE:12
  CountController_1: controllers.CountController,
  // @LINE:14
  AsyncController_2: controllers.AsyncController,
  // @LINE:17
  Assets_3: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    webjars_Routes_0: webjars.Routes,
    // @LINE:8
    HomeController_0: controllers.HomeController,
    // @LINE:12
    CountController_1: controllers.CountController,
    // @LINE:14
    AsyncController_2: controllers.AsyncController,
    // @LINE:17
    Assets_3: controllers.Assets
  ) = this(errorHandler, webjars_Routes_0, HomeController_0, CountController_1, AsyncController_2, Assets_3, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, webjars_Routes_0, HomeController_0, CountController_1, AsyncController_2, Assets_3, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    prefixed_webjars_Routes_0_0.router.documentation,
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """welcome""", """controllers.HomeController.welcome"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """count""", """controllers.CountController.count"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message""", """controllers.AsyncController.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """device/loadDevicePage""", """controllers.HomeController.loadCreateDevicePage"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """device/delete/""" + "$" + """device_code<[^/]+>""", """controllers.HomeController.deleteDevice(device_code:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """device/create""", """controllers.HomeController.createDevice"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """device/listDevice""", """controllers.HomeController.listAllDevice"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """device/edit/""" + "$" + """device_code<[^/]+>""", """controllers.HomeController.loadEditDevicePage(device_code:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """subscribe""", """controllers.HomeController.MQTTsubscribe"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """form2/""" + "$" + """device_code<[^/]+>""", """controllers.HomeController.loadForm2(device_code:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """publishPost""", """controllers.HomeController.MQTTpublishPOST"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """form1/""" + "$" + """device_code<[^/]+>""", """controllers.HomeController.loadForm1(device_code:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] val prefixed_webjars_Routes_0_0 = Include(webjars_Routes_0.withPrefix(this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + "webjars"))

  // @LINE:8
  private[this] lazy val controllers_HomeController_index1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index1_invoker = createInvoker(
    HomeController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_HomeController_welcome2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("welcome")))
  )
  private[this] lazy val controllers_HomeController_welcome2_invoker = createInvoker(
    HomeController_0.welcome,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "welcome",
      Nil,
      "GET",
      this.prefix + """welcome""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_CountController_count3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("count")))
  )
  private[this] lazy val controllers_CountController_count3_invoker = createInvoker(
    CountController_1.count,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CountController",
      "count",
      Nil,
      "GET",
      this.prefix + """count""",
      """ An example controller showing how to use dependency injection""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_AsyncController_message4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message")))
  )
  private[this] lazy val controllers_AsyncController_message4_invoker = createInvoker(
    AsyncController_2.message,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AsyncController",
      "message",
      Nil,
      "GET",
      this.prefix + """message""",
      """ An example controller showing how to write asynchronous code""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_Assets_versioned5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned5_invoker = createInvoker(
    Assets_3.versioned(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_Assets_at6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at6_invoker = createInvoker(
    Assets_3.at(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_HomeController_loadCreateDevicePage7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("device/loadDevicePage")))
  )
  private[this] lazy val controllers_HomeController_loadCreateDevicePage7_invoker = createInvoker(
    HomeController_0.loadCreateDevicePage,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "loadCreateDevicePage",
      Nil,
      "GET",
      this.prefix + """device/loadDevicePage""",
      """ Funtions""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_HomeController_deleteDevice8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("device/delete/"), DynamicPart("device_code", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_deleteDevice8_invoker = createInvoker(
    HomeController_0.deleteDevice(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "deleteDevice",
      Seq(classOf[String]),
      "GET",
      this.prefix + """device/delete/""" + "$" + """device_code<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_HomeController_createDevice9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("device/create")))
  )
  private[this] lazy val controllers_HomeController_createDevice9_invoker = createInvoker(
    HomeController_0.createDevice,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "createDevice",
      Nil,
      "POST",
      this.prefix + """device/create""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_HomeController_listAllDevice10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("device/listDevice")))
  )
  private[this] lazy val controllers_HomeController_listAllDevice10_invoker = createInvoker(
    HomeController_0.listAllDevice,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "listAllDevice",
      Nil,
      "GET",
      this.prefix + """device/listDevice""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_HomeController_loadEditDevicePage11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("device/edit/"), DynamicPart("device_code", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_loadEditDevicePage11_invoker = createInvoker(
    HomeController_0.loadEditDevicePage(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "loadEditDevicePage",
      Seq(classOf[String]),
      "GET",
      this.prefix + """device/edit/""" + "$" + """device_code<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:33
  private[this] lazy val controllers_HomeController_MQTTsubscribe12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subscribe")))
  )
  private[this] lazy val controllers_HomeController_MQTTsubscribe12_invoker = createInvoker(
    HomeController_0.MQTTsubscribe,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "MQTTsubscribe",
      Nil,
      "POST",
      this.prefix + """subscribe""",
      """POST    /subscribe/getTopic          controllers.HomeController.getTopicSubscribe""",
      Seq()
    )
  )

  // @LINE:34
  private[this] lazy val controllers_HomeController_loadForm213_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("form2/"), DynamicPart("device_code", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_loadForm213_invoker = createInvoker(
    HomeController_0.loadForm2(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "loadForm2",
      Seq(classOf[String]),
      "GET",
      this.prefix + """form2/""" + "$" + """device_code<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:36
  private[this] lazy val controllers_HomeController_MQTTpublishPOST14_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("publishPost")))
  )
  private[this] lazy val controllers_HomeController_MQTTpublishPOST14_invoker = createInvoker(
    HomeController_0.MQTTpublishPOST,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "MQTTpublishPOST",
      Nil,
      "POST",
      this.prefix + """publishPost""",
      """""",
      Seq()
    )
  )

  // @LINE:37
  private[this] lazy val controllers_HomeController_loadForm115_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("form1/"), DynamicPart("device_code", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_loadForm115_invoker = createInvoker(
    HomeController_0.loadForm1(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "loadForm1",
      Seq(classOf[String]),
      "GET",
      this.prefix + """form1/""" + "$" + """device_code<[^/]+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case prefixed_webjars_Routes_0_0(handler) => handler
  
    // @LINE:8
    case controllers_HomeController_index1_route(params@_) =>
      call { 
        controllers_HomeController_index1_invoker.call(HomeController_0.index)
      }
  
    // @LINE:9
    case controllers_HomeController_welcome2_route(params@_) =>
      call { 
        controllers_HomeController_welcome2_invoker.call(HomeController_0.welcome)
      }
  
    // @LINE:12
    case controllers_CountController_count3_route(params@_) =>
      call { 
        controllers_CountController_count3_invoker.call(CountController_1.count)
      }
  
    // @LINE:14
    case controllers_AsyncController_message4_route(params@_) =>
      call { 
        controllers_AsyncController_message4_invoker.call(AsyncController_2.message)
      }
  
    // @LINE:17
    case controllers_Assets_versioned5_route(params@_) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_Assets_versioned5_invoker.call(Assets_3.versioned(file))
      }
  
    // @LINE:18
    case controllers_Assets_at6_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at6_invoker.call(Assets_3.at(path, file))
      }
  
    // @LINE:25
    case controllers_HomeController_loadCreateDevicePage7_route(params@_) =>
      call { 
        controllers_HomeController_loadCreateDevicePage7_invoker.call(HomeController_0.loadCreateDevicePage)
      }
  
    // @LINE:26
    case controllers_HomeController_deleteDevice8_route(params@_) =>
      call(params.fromPath[String]("device_code", None)) { (device_code) =>
        controllers_HomeController_deleteDevice8_invoker.call(HomeController_0.deleteDevice(device_code))
      }
  
    // @LINE:28
    case controllers_HomeController_createDevice9_route(params@_) =>
      call { 
        controllers_HomeController_createDevice9_invoker.call(HomeController_0.createDevice)
      }
  
    // @LINE:29
    case controllers_HomeController_listAllDevice10_route(params@_) =>
      call { 
        controllers_HomeController_listAllDevice10_invoker.call(HomeController_0.listAllDevice)
      }
  
    // @LINE:30
    case controllers_HomeController_loadEditDevicePage11_route(params@_) =>
      call(params.fromPath[String]("device_code", None)) { (device_code) =>
        controllers_HomeController_loadEditDevicePage11_invoker.call(HomeController_0.loadEditDevicePage(device_code))
      }
  
    // @LINE:33
    case controllers_HomeController_MQTTsubscribe12_route(params@_) =>
      call { 
        controllers_HomeController_MQTTsubscribe12_invoker.call(HomeController_0.MQTTsubscribe)
      }
  
    // @LINE:34
    case controllers_HomeController_loadForm213_route(params@_) =>
      call(params.fromPath[String]("device_code", None)) { (device_code) =>
        controllers_HomeController_loadForm213_invoker.call(HomeController_0.loadForm2(device_code))
      }
  
    // @LINE:36
    case controllers_HomeController_MQTTpublishPOST14_route(params@_) =>
      call { 
        controllers_HomeController_MQTTpublishPOST14_invoker.call(HomeController_0.MQTTpublishPOST)
      }
  
    // @LINE:37
    case controllers_HomeController_loadForm115_route(params@_) =>
      call(params.fromPath[String]("device_code", None)) { (device_code) =>
        controllers_HomeController_loadForm115_invoker.call(HomeController_0.loadForm1(device_code))
      }
  }
}
