
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

object Form2 extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Seq[String],Seq[String],AssetsFinder,RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(topicList: Seq[String], payloadList: Seq[String])(implicit assetsFinder: AssetsFinder, request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.113*/("""

"""),_display_(/*3.2*/main("Form2")/*3.15*/{_display_(Seq[Any](format.raw/*3.16*/("""

            """),format.raw/*6.35*/("""
            """),format.raw/*7.13*/("""<div class="container">
                <div class="row justify-content-md-center">
                    <ul class="col-md-8">
                        <ul class="card">
                            <div class="card-header">SUBSCRIBE FORM</div>
                            <form id="dataForm" method="post" action=""""),_display_(/*12.72*/routes/*12.78*/.HomeController.getTopicSubscribe),format.raw/*12.111*/("""">
                                <div class="form-group">
                                    <label for="">Subscibe to Topic</label>
                                    <input type="text" name="subTopic" id="subTopic" class="form-control">
                                </div>

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
    <script src=""""),_display_(/*42.19*/assetsFinder/*42.31*/.path("js/test.js")),format.raw/*42.50*/(""""></script>

""")))}),format.raw/*44.2*/("""

"""))
      }
    }
  }

  def render(topicList:Seq[String],payloadList:Seq[String],assetsFinder:AssetsFinder,request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(topicList,payloadList)(assetsFinder,request)

  def f:((Seq[String],Seq[String]) => (AssetsFinder,RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (topicList,payloadList) => (assetsFinder,request) => apply(topicList,payloadList)(assetsFinder,request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/Form2.scala.html
                  HASH: fe38811d30c77b6c9fadf2b05ab491b1a8aa9393
                  MATRIX: 773->1|980->112|1010->117|1031->130|1069->131|1112->241|1153->255|1498->573|1513->579|1568->612|2205->1278|2235->1378|2265->1435|2295->1481|2325->1552|2355->1615|2385->1658|2415->1705|2445->1749|2475->1784|2529->1810|2700->1954|2721->1966|2761->1985|2807->2001
                  LINES: 21->1|26->1|28->3|28->3|28->3|30->6|31->7|36->12|36->12|36->12|49->25|50->26|51->27|52->28|53->29|54->30|55->31|56->32|57->33|58->34|59->35|66->42|66->42|66->42|68->44
                  -- GENERATED --
              */
          