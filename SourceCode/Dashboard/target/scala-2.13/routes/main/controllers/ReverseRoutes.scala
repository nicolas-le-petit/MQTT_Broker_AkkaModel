// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:8
package controllers {

  // @LINE:8
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:33
    def MQTTsubscribe: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "subscribe")
    }
  
    // @LINE:37
    def loadForm1(device_code:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "form1/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("device_code", device_code)))
    }
  
    // @LINE:36
    def MQTTpublishPOST: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "publishPost")
    }
  
    // @LINE:26
    def deleteDevice(device_code:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "device/delete/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("device_code", device_code)))
    }
  
    // @LINE:29
    def listAllDevice: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "device/listDevice")
    }
  
    // @LINE:9
    def welcome: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "welcome")
    }
  
    // @LINE:28
    def createDevice: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "device/create")
    }
  
    // @LINE:34
    def loadForm2(device_code:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "form2/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("device_code", device_code)))
    }
  
    // @LINE:8
    def index: Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:30
    def loadEditDevicePage(device_code:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "device/edit/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("device_code", device_code)))
    }
  
    // @LINE:25
    def loadCreateDevicePage: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "device/loadDevicePage")
    }
  
  }

  // @LINE:12
  class ReverseCountController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def count: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "count")
    }
  
  }

  // @LINE:14
  class ReverseAsyncController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def message: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "message")
    }
  
  }

  // @LINE:17
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def versioned(file:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
    // @LINE:18
    def at(file:String): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }


}
