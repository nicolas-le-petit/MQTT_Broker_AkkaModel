// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:8
package controllers.javascript {

  // @LINE:8
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:33
    def MQTTsubscribe: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.MQTTsubscribe",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "subscribe"})
        }
      """
    )
  
    // @LINE:34
    def MQTTpublishPOST: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.MQTTpublishPOST",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "publishPost"})
        }
      """
    )
  
    // @LINE:36
    def updatePayload: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.updatePayload",
      """
        function(device_code0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "form/update/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("device_code", device_code0))})
        }
      """
    )
  
    // @LINE:26
    def deleteDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.deleteDevice",
      """
        function(device_code0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "device/delete/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("device_code", device_code0))})
        }
      """
    )
  
    // @LINE:29
    def listAllDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.listAllDevice",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "device/listDevice"})
        }
      """
    )
  
    // @LINE:9
    def welcome: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.welcome",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "welcome"})
        }
      """
    )
  
    // @LINE:28
    def createDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.createDevice",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "device/create"})
        }
      """
    )
  
    // @LINE:8
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:30
    def loadEditDevicePage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.loadEditDevicePage",
      """
        function(device_code0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "device/edit/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("device_code", device_code0))})
        }
      """
    )
  
    // @LINE:25
    def loadCreateDevicePage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.loadCreateDevicePage",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "device/loadDevicePage"})
        }
      """
    )
  
    // @LINE:35
    def loadForm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.loadForm",
      """
        function(device_code0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "form/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("device_code", device_code0))})
        }
      """
    )
  
  }

  // @LINE:12
  class ReverseCountController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def count: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CountController.count",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "count"})
        }
      """
    )
  
  }

  // @LINE:14
  class ReverseAsyncController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def message: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AsyncController.message",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "message"})
        }
      """
    )
  
  }

  // @LINE:17
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file0)})
        }
      """
    )
  
    // @LINE:18
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
