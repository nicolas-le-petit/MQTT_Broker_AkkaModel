
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
                <a href="http://localhost:9000/device/loadDevicePage" rel="noopener noreferrer" class="btn btn-sm btn-primary">+ New Device</a>
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
                  HASH: 639ea750fc3064d51db6d2c1b7e45295c10f3de2
                  MATRIX: 977->360|1157->446|1185->641|1214->644|1245->666|1285->668|1317->673|2187->1516|2229->1542|2269->1544|2322->1569|2391->1611|2406->1617|2430->1620|2500->1663|2515->1669|2541->1674|2611->1717|2626->1723|2652->1728|2722->1771|2737->1777|2762->1781|2905->1897|2920->1903|2946->1908|3062->2170|3092->2348|3157->2385|3228->2429|3243->2435|3269->2440|3420->2564|3435->2570|3461->2575|3628->2711|3677->2732|3789->2814
                  LINES: 25->11|30->12|31->17|33->19|33->19|33->19|34->20|55->41|55->41|55->41|56->42|57->43|57->43|57->43|58->44|58->44|58->44|59->45|59->45|59->45|60->46|60->46|60->46|62->48|62->48|62->48|63->49|64->50|65->51|65->51|65->51|65->51|66->52|66->52|66->52|69->55|70->56|77->63
                  -- GENERATED --
              */
          