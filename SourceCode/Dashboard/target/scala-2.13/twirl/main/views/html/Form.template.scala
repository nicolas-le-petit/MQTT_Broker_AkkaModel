
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

object Form extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,String,AssetsFinder,play.twirl.api.HtmlFormat.Appendable] {

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
                    <div class="card-header">PUBLISH FORM</div>
                    <form id="dataForm" method="post" action=""""),_display_(/*12.64*/routes/*12.70*/.HomeController.MQTTpublishPOST),format.raw/*12.101*/("""">
                        <div class="form-group">
                            <label for="">Topic</label>
                            <input type="text" name="topic" id="topic" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="">Payload</label>
                            <input type="text" name="payload" id="payload" class="form-control">
                        </div>
                        <input type="hidden" name="clientID" id="clientID" value="""),_display_(/*21.83*/clientID),format.raw/*21.91*/(""" """),format.raw/*21.92*/("""class="form-control">
                        <div class="form-group">
                            <button class="btn btn-primary" type="submit">Publish</button>
                        </div>
                    </form>
                </div>


                <div class="card-header">SUBSCRIBE FORM</div>
                <form id="dataForm" method="post" action=""""),_display_(/*30.60*/routes/*30.66*/.HomeController.MQTTsubscribe),format.raw/*30.95*/("""">
                    <div class="form-group">
                        <label for="">Subscibe to Topic</label>
                        <input type="text" name="subTopic" id="subTopic" class="form-control">
                    </div>
                    <input type="hidden" name="clientID" id="clientID" value="""),_display_(/*35.79*/clientID),format.raw/*35.87*/(""" """),format.raw/*35.88*/("""class="form-control">
                    <div class="form-group">
                        <button class="btn btn-primary" type="submit">Subscribe</button>
                    </div>
                </form>
            </div>


            </div>
        </div>
    </div>
    </div>
""")))}),format.raw/*47.2*/("""
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
                  SOURCE: app/views/Form.scala.html
                  HASH: d739d128e4a4dc6a2f3d238f635d7ba514d68121
                  MATRIX: 825->84|992->156|1020->159|1041->172|1079->173|1113->181|1418->459|1433->465|1486->496|2071->1054|2100->1062|2129->1063|2532->1439|2547->1445|2597->1474|2941->1791|2970->1799|2999->1800|3326->2097
                  LINES: 23->4|28->4|29->5|29->5|29->5|31->7|36->12|36->12|36->12|45->21|45->21|45->21|54->30|54->30|54->30|59->35|59->35|59->35|71->47
                  -- GENERATED --
              */
          