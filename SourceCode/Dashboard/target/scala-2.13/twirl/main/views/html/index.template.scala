
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,List[DeviceItem],AssetsFinder,play.twirl.api.HtmlFormat.Appendable] {

  /*
@(message: String, devicesNameList: List[String], devicesCodeList: List[String], devicesDesList: List[String])
@(message: String, devicesList: List[(String, String, String)])
@devicesList = @{TSData.getDeviceList()}
*/
  def apply/*11.2*/(message: String, devicesList: List[DeviceItem])(implicit assetsFinder: AssetsFinder):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*12.1*/("""
"""),format.raw/*17.4*/("""

"""),_display_(/*19.2*/main("MQTT Dashboard")/*19.24*/ {_display_(Seq[Any](format.raw/*19.26*/("""
    """),format.raw/*20.5*/("""<title>MQTT DASH BOARD</title>
    <div class="container">
        <h1>MQTT WEB CLIENT</h1>
        <div class="row">
            <div class="col-md-12">
                <a href="http://localhost:9000/device/loadDevicePage" target="_blank" rel="noopener noreferrer" class="btn btn-sm btn-primary">+ New Device</a>
            </div>
        </div>
        <div class="row">
            <div class="table-responsive">
                <table class="table table-borded">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Name</th>
                            <th>ClientID</th>
                            <th>Description</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        """),_display_(/*41.26*/for(device <- devicesList) yield /*41.52*/ {_display_(Seq[Any](format.raw/*41.54*/("""
                        """),format.raw/*42.25*/("""<tr>
                                <td>"""),_display_(/*43.38*/device/*43.44*/.id),format.raw/*43.47*/("""</td>
                                <td>"""),_display_(/*44.38*/device/*44.44*/.name),format.raw/*44.49*/("""</td>
                                <td>"""),_display_(/*45.38*/device/*45.44*/.code),format.raw/*45.49*/("""</td>
                                <td>"""),_display_(/*46.38*/device/*46.44*/.des),format.raw/*46.48*/("""</td>
                                <td>
                                    <a href="http://localhost:9000/form/"""),_display_(/*48.74*/device/*48.80*/.code),format.raw/*48.85*/("""" target="_blank" rel="noopener noreferrer" class="btn btn-sm btn-primary">Explore</a>
"""),format.raw/*49.176*/("""
"""),format.raw/*50.178*/("""
                                    """),format.raw/*51.37*/("""<a href="http://localhost:9000/device/edit/"""),_display_(/*51.81*/device/*51.87*/.code),format.raw/*51.92*/("""" class="btn btn-sm btn-warning">Edit</a>
                                    <a href="http://localhost:9000/device/delete/"""),_display_(/*52.83*/device/*52.89*/.code),format.raw/*52.94*/("""" class="btn btn-sm btn-danger">Delete</a>
                                </td>
                        </tr>
                        """)))}),format.raw/*55.26*/("""
                    """),format.raw/*56.21*/("""</tbody>
                </table>
            </div>
        </div>
    </div>


""")))}),format.raw/*63.2*/("""
"""))
      }
    }
  }

  def render(message:String,devicesList:List[DeviceItem],assetsFinder:AssetsFinder): play.twirl.api.HtmlFormat.Appendable = apply(message,devicesList)(assetsFinder)

  def f:((String,List[DeviceItem]) => (AssetsFinder) => play.twirl.api.HtmlFormat.Appendable) = (message,devicesList) => (assetsFinder) => apply(message,devicesList)(assetsFinder)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/index.scala.html
                  HASH: d96aed7cd01a2829d6922e2a4c0e78b8bd191fa5
                  MATRIX: 977->360|1157->446|1185->641|1214->644|1245->666|1285->668|1317->673|2203->1532|2245->1558|2285->1560|2338->1585|2407->1627|2422->1633|2446->1636|2516->1679|2531->1685|2557->1690|2627->1733|2642->1739|2668->1744|2738->1787|2753->1793|2778->1797|2921->1913|2936->1919|2962->1924|3078->2186|3108->2364|3173->2401|3244->2445|3259->2451|3285->2456|3436->2580|3451->2586|3477->2591|3644->2727|3693->2748|3805->2830
                  LINES: 25->11|30->12|31->17|33->19|33->19|33->19|34->20|55->41|55->41|55->41|56->42|57->43|57->43|57->43|58->44|58->44|58->44|59->45|59->45|59->45|60->46|60->46|60->46|62->48|62->48|62->48|63->49|64->50|65->51|65->51|65->51|65->51|66->52|66->52|66->52|69->55|70->56|77->63
                  -- GENERATED --
              */
          