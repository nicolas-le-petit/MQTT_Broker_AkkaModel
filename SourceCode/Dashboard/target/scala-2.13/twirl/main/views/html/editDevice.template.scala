
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object editDevice extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,String,AssetsFinder,play.twirl.api.HtmlFormat.Appendable] {

  /*
* This template takes a two arguments, a String containing a
* message to display and an AssetsFinder to locate static assets.
*/
  def apply/*8.2*/(message: String, clientID: String)(implicit assetsFinder: AssetsFinder):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*8.74*/("""

"""),format.raw/*14.3*/("""

"""),_display_(/*16.2*/main("create Device")/*16.23*/ {_display_(Seq[Any](format.raw/*16.25*/("""

    """),format.raw/*18.5*/("""<div class="container">
        <div class="row justify-content-md-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">EDIT DEVICE</div>
                    <div class="card-body">
                        <form action=""""),_display_(/*24.40*/routes/*24.46*/.HomeController.createDevice),format.raw/*24.74*/("""" method="post">
                            <div class="form-group">
                                <label for="">Device Name</label>
                                <input type="text" name="device_name" id="device_name" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="">Device ID</label>
                                <input type="text" name="device_code" id="device_code" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="">Description</label>
                                <input type="text" name="device_description" id="device_description" class="form-control">
                            </div>
                            <input type="hidden" name="clientID_old" id="clientID_old" value="""),_display_(/*37.95*/clientID),format.raw/*37.103*/(""" """),format.raw/*37.104*/("""class="form-control">
                            <div class="form-group">
                                <button class="btn btn-primary" type="submit">Save change</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


""")))}),format.raw/*49.2*/("""
"""))
      }
    }
  }

  def render(message:String,clientID:String,assetsFinder:AssetsFinder): play.twirl.api.HtmlFormat.Appendable = apply(message,clientID)(assetsFinder)

  def f:((String,String) => (AssetsFinder) => play.twirl.api.HtmlFormat.Appendable) = (message,clientID) => (assetsFinder) => apply(message,clientID)(assetsFinder)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/editDevice.scala.html
                  HASH: 6b8033b9f68d8639e33186998a8d5cadfe58c188
                  MATRIX: 885->144|1052->216|1083->414|1114->419|1144->440|1184->442|1219->450|1544->748|1559->754|1608->782|2560->1707|2590->1715|2620->1716|3001->2067
                  LINES: 24->8|29->8|31->14|33->16|33->16|33->16|35->18|41->24|41->24|41->24|54->37|54->37|54->37|66->49
                  -- GENERATED --
              */
          