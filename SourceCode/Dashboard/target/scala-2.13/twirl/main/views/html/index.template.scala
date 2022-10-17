
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

"""),_display_(/*19.2*/main("Welcome to Play")/*19.25*/ {_display_(Seq[Any](format.raw/*19.27*/("""
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
                                    <a href="http://localhost:9000/form1/"""),_display_(/*48.75*/device/*48.81*/.code),format.raw/*48.86*/("""" target="_blank" rel="noopener noreferrer" class="btn btn-sm btn-primary">Publish</a>
                                    <a href="http://localhost:9000/form2/"""),_display_(/*49.75*/device/*49.81*/.code),format.raw/*49.86*/("""" target="_blank" rel="noopener noreferrer" class="btn btn-sm btn-primary">Subscribe</a>
                                    <a href="http://localhost:9000/device/edit/"""),_display_(/*50.81*/device/*50.87*/.code),format.raw/*50.92*/("""" class="btn btn-sm btn-warning">Edit</a>
                                    <a href="http://localhost:9000/device/delete/"""),_display_(/*51.83*/device/*51.89*/.code),format.raw/*51.94*/("""" class="btn btn-sm btn-danger">Delete</a>
                                </td>
                        </tr>
                        """)))}),format.raw/*54.26*/("""
                    """),format.raw/*55.21*/("""</tbody>
                </table>
            </div>
        </div>
    </div>


""")))}),format.raw/*62.2*/("""
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
                  HASH: 20a0ed98caaa8a4788d9076e2c1e159758877a81
                  MATRIX: 977->360|1157->446|1185->641|1214->644|1246->667|1286->669|1318->674|2204->1533|2246->1559|2286->1561|2339->1586|2408->1628|2423->1634|2447->1637|2517->1680|2532->1686|2558->1691|2628->1734|2643->1740|2669->1745|2739->1788|2754->1794|2779->1798|2923->1915|2938->1921|2964->1926|3152->2087|3167->2093|3193->2098|3389->2267|3404->2273|3430->2278|3581->2402|3596->2408|3622->2413|3789->2549|3838->2570|3950->2652
                  LINES: 25->11|30->12|31->17|33->19|33->19|33->19|34->20|55->41|55->41|55->41|56->42|57->43|57->43|57->43|58->44|58->44|58->44|59->45|59->45|59->45|60->46|60->46|60->46|62->48|62->48|62->48|63->49|63->49|63->49|64->50|64->50|64->50|65->51|65->51|65->51|68->54|69->55|76->62
                  -- GENERATED --
              */
          