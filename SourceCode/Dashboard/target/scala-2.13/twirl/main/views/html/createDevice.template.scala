
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

object createDevice extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,AssetsFinder,play.twirl.api.HtmlFormat.Appendable] {

  /*
* This template takes a two arguments, a String containing a
* message to display and an AssetsFinder to locate static assets.
*/
  def apply/*8.2*/(message: String)(implicit assetsFinder: AssetsFinder):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*8.56*/("""

"""),format.raw/*14.3*/("""

"""),_display_(/*16.2*/main("create Device")/*16.23*/ {_display_(Seq[Any](format.raw/*16.25*/("""

    """),format.raw/*18.5*/("""<div class="container">
        <div class="row justify-content-md-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">CREATE NEW DEVICE</div>
                    <div class="card-body">
                        <form action=""""),_display_(/*24.40*/routes/*24.46*/.HomeController.createDevice),format.raw/*24.74*/("""" method="post">
                            <div class="form-group">
                                <label for="">Device Name</label>
                                <input type="text" name="device_name" id="device_name" placeholder="eg. Device_1" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="">Device ID</label>
                                <input type="text" name="device_code" id="device_code" placeholder="eg. Client_1" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="">Description</label>
                                <input type="text" name="device_description" id="device_description" placeholder="eg. This is Device_1" class="form-control">
                            </div>
                            <div class="form-group">
                                <button class="btn btn-primary" type="submit">Create</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


""")))}),format.raw/*48.2*/("""
"""))
      }
    }
  }

  def render(message:String,assetsFinder:AssetsFinder): play.twirl.api.HtmlFormat.Appendable = apply(message)(assetsFinder)

  def f:((String) => (AssetsFinder) => play.twirl.api.HtmlFormat.Appendable) = (message) => (assetsFinder) => apply(message)(assetsFinder)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/createDevice.scala.html
                  HASH: b80d703c98ee6745ef7a3e363ab9cb2ea8d2482a
                  MATRIX: 880->144|1029->198|1060->396|1091->401|1121->422|1161->424|1196->432|1527->736|1542->742|1591->770|2864->2013
                  LINES: 24->8|29->8|31->14|33->16|33->16|33->16|35->18|41->24|41->24|41->24|65->48
                  -- GENERATED --
              */
          