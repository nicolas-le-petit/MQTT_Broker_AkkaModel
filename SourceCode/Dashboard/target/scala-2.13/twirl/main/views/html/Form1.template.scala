
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

object Form1 extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,String,AssetsFinder,play.twirl.api.HtmlFormat.Appendable] {

  /*
@(message: String, clientID: String)(implicit assetsFinder: AssetsFinder)
*/
  def apply/*4.2*/(message: String, clientID: String)(implicit assetsFinder: AssetsFinder):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.74*/("""
"""),_display_(/*5.2*/main("Form1")/*5.15*/{_display_(Seq[Any](format.raw/*5.16*/("""

    """),format.raw/*7.5*/("""<div class="container">
        <div class="row justify-content-md-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">PUBLISH FORM """),_display_(/*11.60*/clientID),format.raw/*11.68*/("""</div>
                        <form id="dataForm" method="post" action=""""),_display_(/*12.68*/routes/*12.74*/.HomeController.MQTTpublishPOST),format.raw/*12.105*/("""">
                            <div>
                                <label for="retain">Retained Flag</label>
                                <input type="checkbox" id="retain_flag" name="retain_flag" value=true>
                            </div>
                            <div class="form-group">
                                <label for="">Topic</label>
                                <input type="text" name="topic" id="topic" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="">Payload</label>
                                <input type="text" name="payload" id="payload" class="form-control">
                            </div>
                            <div>
                                <label for="">QoS</label>
                                <select name="qos" id="qos">
                                    <option value=0>0</option>
                                    <option value=1>1</option>
                                    <option value=2>2</option>
                                </select>
                            </div>

                            <input type="hidden" name="clientID" id="clientID" value="""),_display_(/*34.87*/clientID),format.raw/*34.95*/(""" """),format.raw/*34.96*/("""class="form-control">
                            <div class="form-group">
                                <button class="btn btn-primary" type="submit">Publish</button>
                            </div>
                        </form>
                </div>
            </div>
        </div>
    </div>
    </div>
""")))}),format.raw/*44.2*/("""
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
                  SOURCE: app/views/Form1.scala.html
                  HASH: 8002b5fc28c26c9b3928a7660d5ddecfa6873d66
                  MATRIX: 826->84|993->156|1021->159|1042->172|1080->173|1114->181|1350->390|1379->398|1481->473|1496->479|1549->510|2849->1783|2878->1791|2907->1792|3264->2119
                  LINES: 23->4|28->4|29->5|29->5|29->5|31->7|35->11|35->11|36->12|36->12|36->12|58->34|58->34|58->34|68->44
                  -- GENERATED --
              */
          