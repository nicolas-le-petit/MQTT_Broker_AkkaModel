
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

object Form2_Backup extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Seq[String],Seq[String],AssetsFinder,RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(topicList: Seq[String], payloadList: Seq[String])(implicit assetsFinder: AssetsFinder, request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.113*/("""

"""),_display_(/*3.2*/main("Form2")/*3.15*/{_display_(Seq[Any](format.raw/*3.16*/("""

    """),format.raw/*5.5*/("""<div class="container">
        <div class="row justify-content-md-center">
            <ul class="col-md-8">
                <ul class="card">
                    <div class="card-header">SUBSCRIBE FORM</div>
                        <form id="dataForm" method="post" action=""""),_display_(/*10.68*/routes/*10.74*/.HomeController.getTopicSubscribe),format.raw/*10.107*/("""">
                            <div class="form-group">
                                <label for="">Subscibe to Topic</label>
                                <input type="text" name="subTopic" id="subTopic" class="form-control">
                            </div>

                            <div class="form-group">
                                <button class="btn btn-primary" type="submit">Subscribe</button>
                            </div>
                        </form>
                        <ul>
                            """),_display_(/*21.30*/for(topic <- topicList) yield /*21.53*/{_display_(Seq[Any](format.raw/*21.54*/("""
                                """),format.raw/*22.33*/("""<li>"""),_display_(/*22.38*/topic),format.raw/*22.43*/("""</li>
                                """),_display_(/*23.34*/for(payload <- payloadList) yield /*23.61*/{_display_(Seq[Any](format.raw/*23.62*/("""
                                    """),format.raw/*24.37*/("""<li>"""),_display_(/*24.42*/payload),format.raw/*24.49*/("""</li>
                                """)))}),format.raw/*25.34*/("""
                            """)))}),format.raw/*26.30*/("""
                        """),format.raw/*27.25*/("""</ul>

                </ul>
            </ul>
                </div>
            </div>
        </div>
    </div>
    </div>
""")))}),format.raw/*36.2*/("""
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
                  SOURCE: app/views/Form2_Backup.scala.html
                  HASH: ebfa0174f030a139e468780e3ef9bdf6159ec7de
                  MATRIX: 780->1|987->112|1017->117|1038->130|1076->131|1110->139|1419->421|1434->427|1489->460|2069->1013|2108->1036|2147->1037|2209->1071|2241->1076|2267->1081|2334->1121|2377->1148|2416->1149|2482->1187|2514->1192|2542->1199|2613->1239|2675->1270|2729->1296|2895->1432
                  LINES: 21->1|26->1|28->3|28->3|28->3|30->5|35->10|35->10|35->10|46->21|46->21|46->21|47->22|47->22|47->22|48->23|48->23|48->23|49->24|49->24|49->24|50->25|51->26|52->27|61->36
                  -- GENERATED --
              */
          