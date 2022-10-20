
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
                                <div>
                                    <label for="">QoS</label>
                                    <select name="qos" id="qos">
                                        <option value=0>0</option>
                                        <option value=1>1</option>
                                        <option value=2>2</option>
                                    </select>
                                </div>
                                <input type="hidden" name="clientID" id="clientID" value="""),_display_(/*24.91*/clientID),format.raw/*24.99*/(""" """),format.raw/*24.100*/("""class="form-control">
                                <div class="form-group">
                                    <button class="btn btn-primary" type="submit">Subscribe</button>
                                </div>
                            </form>
                            <div id="test">

                            </div>
"""),format.raw/*32.58*/("""
"""),format.raw/*33.99*/("""
"""),format.raw/*34.56*/("""
"""),format.raw/*35.45*/("""
"""),format.raw/*36.70*/("""
"""),format.raw/*37.62*/("""
"""),format.raw/*38.42*/("""
"""),format.raw/*39.46*/("""
"""),format.raw/*40.43*/("""
"""),format.raw/*41.34*/("""
                        """),format.raw/*42.25*/("""</ul>
                    </ul>
                </div>
            </div>
        </div>
        </div>
        </div>
"""),format.raw/*49.65*/("""

""")))}),format.raw/*51.2*/("""

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
                  HASH: 9179a081da9e77726ac26aa4504d73f7fa239e3f
                  MATRIX: 763->1|955->98|985->103|1006->116|1044->117|1085->225|1126->239|1394->480|1423->488|1529->567|1544->573|1595->602|2458->1438|2487->1446|2517->1447|2888->1847|2918->1947|2948->2004|2978->2050|3008->2121|3038->2184|3068->2227|3098->2274|3128->2318|3158->2353|3212->2379|3366->2569|3401->2574
                  LINES: 21->1|26->1|28->3|28->3|28->3|29->5|30->6|34->10|34->10|35->11|35->11|35->11|48->24|48->24|48->24|56->32|57->33|58->34|59->35|60->36|61->37|62->38|63->39|64->40|65->41|66->42|73->49|75->51
                  -- GENERATED --
              */
          