
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

object Form2 extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[String,String,AssetsFinder,RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(messages: String, clientID: String)(implicit assetsFinder: AssetsFinder, request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.99*/("""

"""),_display_(/*3.2*/main("Form2")/*3.15*/{_display_(Seq[Any](format.raw/*3.16*/("""
            """),format.raw/*5.35*/("""
            """),format.raw/*6.13*/("""<div class="container">
                <div class="row justify-content-md-center">
                    <ul class="col-md-8">
                        <ul class="card">
                            <div class="card-header">SUBSCRIBE FORM """),_display_(/*10.70*/clientID),format.raw/*10.78*/("""</div>
                            <form id="dataForm" method="post" action=""""),_display_(/*11.72*/routes/*11.78*/.HomeController.MQTTsubscribe),format.raw/*11.107*/("""">
                                <div class="form-group">
                                    <label for="">Subscibe to Topic</label>
                                    <input type="text" name="subTopic" id="subTopic" class="form-control">
                                </div>
                                <input type="hidden" name="clientID" id="clientID" value="""),_display_(/*16.91*/clientID),format.raw/*16.99*/(""" """),format.raw/*16.100*/("""class="form-control">
                                <div class="form-group">
                                    <button class="btn btn-primary" type="submit">Subscribe</button>
                                </div>
                            </form>
                            <div id="test">

                            </div>
"""),format.raw/*24.58*/("""
"""),format.raw/*25.99*/("""
"""),format.raw/*26.56*/("""
"""),format.raw/*27.45*/("""
"""),format.raw/*28.70*/("""
"""),format.raw/*29.62*/("""
"""),format.raw/*30.42*/("""
"""),format.raw/*31.46*/("""
"""),format.raw/*32.43*/("""
"""),format.raw/*33.34*/("""
                        """),format.raw/*34.25*/("""</ul>
                    </ul>
                </div>
            </div>
        </div>
        </div>
        </div>
"""),format.raw/*41.65*/("""

""")))}),format.raw/*43.2*/("""

"""))
      }
    }
  }

  def render(messages:String,clientID:String,assetsFinder:AssetsFinder,request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(messages,clientID)(assetsFinder,request)

  def f:((String,String) => (AssetsFinder,RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (messages,clientID) => (assetsFinder,request) => apply(messages,clientID)(assetsFinder,request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/Form2.scala.html
                  HASH: c85c4af4253dc95ce5d2d5fdada3dfb96a8346e9
                  MATRIX: 763->1|955->98|985->103|1006->116|1044->117|1085->225|1126->239|1394->480|1423->488|1529->567|1544->573|1595->602|1999->979|2028->987|2058->988|2429->1388|2459->1488|2489->1545|2519->1591|2549->1662|2579->1725|2609->1768|2639->1815|2669->1859|2699->1894|2753->1920|2907->2110|2942->2115
                  LINES: 21->1|26->1|28->3|28->3|28->3|29->5|30->6|34->10|34->10|35->11|35->11|35->11|40->16|40->16|40->16|48->24|49->25|50->26|51->27|52->28|53->29|54->30|55->31|56->32|57->33|58->34|65->41|67->43
                  -- GENERATED --
              */
          