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

  
    // @LINE:37
    def loadForm1: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.loadForm1",
      """
        function(device_code0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "form1/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("device_code", device_code0))})
        }
      """
    )
  
    // @LINE:36
    def MQTTpublishPOST: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.MQTTpublishPOST",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "publishPost"})
        }
      """
    )
  
    // @LINE:29
    def listAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.listAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "device/listDevice"})
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
  
    // @LINE:31
    def getTopicSubscribe: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getTopicSubscribe",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "subscribe/getTopic"})
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
  
    // @LINE:33
    def loadForm2: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.loadForm2",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "form2"})
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
  
    // @LINE:32
    def MQTTsubscribe: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.MQTTsubscribe",
      """
        function(topic0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "subscribe/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("topic", topic0))})
        }
      """
    )
  
    // @LINE:25
    def loadDevicePage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.loadDevicePage",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "device/loadDevicePage"})
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
