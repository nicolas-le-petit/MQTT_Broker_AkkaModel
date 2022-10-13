
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
    """),format.raw/*20.5*/("""<title> MQTT DASH BOARD</title>
    <div class="container">
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
                        """),_display_(/*40.26*/for(device <- devicesList) yield /*40.52*/ {_display_(Seq[Any](format.raw/*40.54*/("""
                        """),format.raw/*41.25*/("""<tr>
                                <td>"""),_display_(/*42.38*/device/*42.44*/.id),format.raw/*42.47*/("""</td>
                                <td>"""),_display_(/*43.38*/device/*43.44*/.name),format.raw/*43.49*/("""</td>
                                <td>"""),_display_(/*44.38*/device/*44.44*/.code),format.raw/*44.49*/("""</td>
                                <td>"""),_display_(/*45.38*/device/*45.44*/.des),format.raw/*45.48*/("""</td>
                                <td>
                                    <a href="http://localhost:9000/form1/"""),_display_(/*47.75*/device/*47.81*/.code),format.raw/*47.86*/("""" target="_blank" rel="noopener noreferrer" class="btn btn-sm btn-primary">Publish</a>
                                    <a href="http://localhost:9000/form2/"""),_display_(/*48.75*/device/*48.81*/.code),format.raw/*48.86*/("""" target="_blank" rel="noopener noreferrer" class="btn btn-sm btn-primary">Subscribe</a>
                                    <a href="" class="btn btn-sm btn-warning">Edit</a>
                                    <a href="http://localhost:9000/device/delete/"""),_display_(/*50.83*/device/*50.89*/.code),format.raw/*50.94*/("""" class="btn btn-sm btn-danger">Delete</a>
                                </td>
                        </tr>
                        """)))}),format.raw/*53.26*/("""
                    """),format.raw/*54.21*/("""</tbody>
                </table>
            </div>
        </div>
    </div>


""")))}),format.raw/*61.2*/("""
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
                  HASH: 8ef9e0f62f29627768d8e5ba89a65f87e2a93825
                  MATRIX: 977->360|1157->446|1185->641|1214->644|1246->667|1286->669|1318->674|2172->1501|2214->1527|2254->1529|2307->1554|2376->1596|2391->1602|2415->1605|2485->1648|2500->1654|2526->1659|2596->1702|2611->1708|2637->1713|2707->1756|2722->1762|2747->1766|2891->1883|2906->1889|2932->1894|3120->2055|3135->2061|3161->2066|3446->2324|3461->2330|3487->2335|3654->2471|3703->2492|3815->2574
                  LINES: 25->11|30->12|31->17|33->19|33->19|33->19|34->20|54->40|54->40|54->40|55->41|56->42|56->42|56->42|57->43|57->43|57->43|58->44|58->44|58->44|59->45|59->45|59->45|61->47|61->47|61->47|62->48|62->48|62->48|64->50|64->50|64->50|67->53|68->54|75->61
                  -- GENERATED --
              */
          