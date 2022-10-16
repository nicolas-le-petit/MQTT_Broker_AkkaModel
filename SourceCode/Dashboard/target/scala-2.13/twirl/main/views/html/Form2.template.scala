
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

            """),format.raw/*6.35*/("""
            """),format.raw/*7.13*/("""<div class="container">
                <div class="row justify-content-md-center">
                    <ul class="col-md-8">
                        <ul class="card">
                            <div class="card-header">SUBSCRIBE FORM """),_display_(/*11.70*/clientID),format.raw/*11.78*/("""</div>
                            <form id="dataForm" method="post" action=""""),_display_(/*12.72*/routes/*12.78*/.HomeController.MQTTsubscribe),format.raw/*12.107*/("""">
                                <div class="form-group">
                                    <label for="">Subscibe to Topic</label>
                                    <input type="text" name="subTopic" id="subTopic" class="form-control">
                                </div>
                                <input type="hidden" name="clientID" id="clientID" value="""),_display_(/*17.91*/clientID),format.raw/*17.99*/(""" """),format.raw/*17.100*/("""class="form-control">
                                <div class="form-group">
                                    <button class="btn btn-primary" type="submit">Subscribe</button>
                                </div>
                            </form>
                            <div id="test">

                            </div>
"""),format.raw/*25.58*/("""
"""),format.raw/*26.99*/("""
"""),format.raw/*27.56*/("""
"""),format.raw/*28.45*/("""
"""),format.raw/*29.70*/("""
"""),format.raw/*30.62*/("""
"""),format.raw/*31.42*/("""
"""),format.raw/*32.46*/("""
"""),format.raw/*33.43*/("""
"""),format.raw/*34.34*/("""
                        """),format.raw/*35.25*/("""</ul>
                    </ul>
                </div>
            </div>
        </div>
        </div>
        </div>
"""),format.raw/*42.65*/("""

""")))}),format.raw/*44.2*/("""

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
                  HASH: e62f79c0c87e0f6ff8c36bd982ba00be6b4df7b7
                  MATRIX: 763->1|955->98|985->103|1006->116|1044->117|1087->227|1128->241|1396->482|1425->490|1531->569|1546->575|1597->604|2001->981|2030->989|2060->990|2431->1390|2461->1490|2491->1547|2521->1593|2551->1664|2581->1727|2611->1770|2641->1817|2671->1861|2701->1896|2755->1922|2909->2112|2944->2117
                  LINES: 21->1|26->1|28->3|28->3|28->3|30->6|31->7|35->11|35->11|36->12|36->12|36->12|41->17|41->17|41->17|49->25|50->26|51->27|52->28|53->29|54->30|55->31|56->32|57->33|58->34|59->35|66->42|68->44
                  -- GENERATED --
              */
          