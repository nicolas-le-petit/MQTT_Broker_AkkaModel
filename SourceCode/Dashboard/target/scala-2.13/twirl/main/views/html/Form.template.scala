
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
"""),_display_(/*5.2*/main("FormMQTT")/*5.18*/{_display_(Seq[Any](format.raw/*5.19*/("""
    """),format.raw/*6.5*/("""<title>"""),_display_(/*6.13*/clientID),format.raw/*6.21*/("""</title>
    <style>
            h1 """),format.raw/*8.16*/("""{"""),format.raw/*8.17*/("""text-align: center;"""),format.raw/*8.36*/("""}"""),format.raw/*8.37*/("""
            """),format.raw/*9.13*/("""p.ridge """),format.raw/*9.21*/("""{"""),format.raw/*9.22*/("""border-style: ridge;"""),format.raw/*9.42*/("""}"""),format.raw/*9.43*/("""
    """),format.raw/*10.5*/("""</style>
    <h1>"""),_display_(/*11.10*/clientID),format.raw/*11.18*/("""</h1>
    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <div class="card bg-dark text-white">
                            <div class="card-header">PUBLISH FORM</div>
                        </div><br>
                        <form id="publishForm" method="post" action=""""),_display_(/*20.71*/routes/*20.77*/.HomeController.MQTTpublishPOST),format.raw/*20.108*/("""">
                            <div class="form-group">
                                <label for="">Topic</label>
                                <input type="text" name="pubTopic" id="pubTopic" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="">Payload</label>
                                <input type="text" name="pubPayload" id="pubPayload" class="form-control">
                            </div>
                            <div class="form-group">
"""),format.raw/*30.78*/("""
                                """),format.raw/*31.33*/("""<div>
                                    <label for="">Retained Flag</label>
                                    <select name="retain_flag" id="retain_flag">
                                        <option value="false">False</option>
                                        <option value="true">True</option>
                                    </select>
                                </div>
"""),format.raw/*38.109*/("""
                            """),format.raw/*39.29*/("""</div>

                            <div>
                                <label for="">QoS</label>
                                <select name="pubQos" id="pubQos">
                                    <option value=0>0</option>
                                    <option value=1>1</option>
                                    <option value=2>2</option>
                                </select>
                            </div><br>
                            <input type="hidden" name="PubClientID" id="PubClientID" value="""),_display_(/*49.93*/clientID),format.raw/*49.101*/(""" """),format.raw/*49.102*/("""class="form-control">
                            <div class="form-group">
                                <button class="btn btn-primary" type="submit">Publish</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <div class="card bg-dark text-white">
                            <div class="card-header">SUBSCRIBE FORM</div>
                        </div><br>
                        <form id="subscribeForm" method="post" action=""""),_display_(/*63.73*/routes/*63.79*/.HomeController.MQTTsubscribe),format.raw/*63.108*/("""">
                            <div class="form-group">
                                <label for="">Subscibe to Topic</label>
                                <input type="text" name="subTopic" id="subTopic" class="form-control">
                            </div>
                            <div>
                                <label for="">QoS</label>
                                <select name="subQos" id="subQos">
                                    <option value=0>0</option>
                                    <option value=1>1</option>
                                    <option value=2>2</option>
                                </select>
                            </div><br>
                            <input type="hidden" name="SubClientID" id="SubClientID" value="""),_display_(/*76.93*/clientID),format.raw/*76.101*/(""" """),format.raw/*76.102*/("""class="form-control">
                            <div class="form-group">
                                <button class="btn btn-primary" type="submit">Subscribe</button>
                            </div>
                        </form>
                        <h4>Data response:</h4>
                        <div id="result" class="table-responsive">
                            <table class="table table-hover table-borded">
                                <thead class="bg-primary">
                                    <tr class="text-white">
                                        <th>Topic</th>
                                        <th>Payload</th>
                                        <th>Time</th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <script>
                $('#publishForm').submit(function(e)"""),format.raw/*99.53*/("""{"""),format.raw/*99.54*/("""
                    """),format.raw/*100.21*/("""e.preventDefault();
                    toastr.warning('Publish ...');
                    console.log('publishForm');
                    $.ajax("""),format.raw/*103.28*/("""{"""),format.raw/*103.29*/("""
                        """),format.raw/*104.25*/("""type: "POST",
                        url: $(this).attr('action'),
                        data: $(this).serialize(),
                        success: function (response) """),format.raw/*107.54*/("""{"""),format.raw/*107.55*/("""
                            """),format.raw/*108.29*/("""toastr.success('Publish Success');
                            //console.log(response)
                            $('#pubTopic').val('');
                            $('#pubPayload').val('');
                        """),format.raw/*112.25*/("""}"""),format.raw/*112.26*/("""
                    """),format.raw/*113.21*/("""}"""),format.raw/*113.22*/(""");
                """),format.raw/*114.17*/("""}"""),format.raw/*114.18*/(""");
                $('#subscribeForm').submit(function(e)"""),format.raw/*115.55*/("""{"""),format.raw/*115.56*/("""
                    """),format.raw/*116.21*/("""e.preventDefault();
                    toastr.warning('Subscribe ...');
                    console.log('subscribeForm');
                    $.ajax("""),format.raw/*119.28*/("""{"""),format.raw/*119.29*/("""
                        """),format.raw/*120.25*/("""type: "POST",
                        url: $(this).attr('action'),
                        data: $(this).serialize(),
                        success: function (response) """),format.raw/*123.54*/("""{"""),format.raw/*123.55*/("""
                            """),format.raw/*124.29*/("""toastr.success('Subscribe Success');
                            //console.log(response);
                            $('#subTopic').val('');
                        """),format.raw/*127.25*/("""}"""),format.raw/*127.26*/("""
                    """),format.raw/*128.21*/("""}"""),format.raw/*128.22*/(""");
                """),format.raw/*129.17*/("""}"""),format.raw/*129.18*/(""");
                    setInterval(function()"""),format.raw/*130.43*/("""{"""),format.raw/*130.44*/("""
                        """),format.raw/*131.25*/("""$.ajax("""),format.raw/*131.32*/("""{"""),format.raw/*131.33*/("""
                            """),format.raw/*132.29*/("""type: "GET",
                            url: "/form/update/"""),_display_(/*133.49*/clientID),format.raw/*133.57*/("""",
                            data: """),format.raw/*134.35*/("""{"""),format.raw/*134.36*/("""
                                """),format.raw/*135.33*/("""clientID: $('#SubClientID').val()
                            """),format.raw/*136.29*/("""}"""),format.raw/*136.30*/(""",
                            dataType: "text",
                            success: function (response) """),format.raw/*138.58*/("""{"""),format.raw/*138.59*/("""
                                """),format.raw/*139.33*/("""let resArr = response.split("\n");
                                $("#result").find('tbody').append(`
                                    <tr>
                                        <td>$"""),format.raw/*142.46*/("""{"""),format.raw/*142.47*/("""resArr[0] != undefined ? resArr[0] : ''"""),format.raw/*142.86*/("""}"""),format.raw/*142.87*/("""</td>
                                        <td>$"""),format.raw/*143.46*/("""{"""),format.raw/*143.47*/("""resArr[1] != undefined ? resArr[1] : ''"""),format.raw/*143.86*/("""}"""),format.raw/*143.87*/("""</td>
                                        <td>$"""),format.raw/*144.46*/("""{"""),format.raw/*144.47*/("""resArr[2] != undefined ? resArr[2] : ''"""),format.raw/*144.86*/("""}"""),format.raw/*144.87*/("""</td>
                                    </tr>
                                `);
                            """),format.raw/*147.29*/("""}"""),format.raw/*147.30*/("""
                        """),format.raw/*148.25*/("""}"""),format.raw/*148.26*/(""");
                    """),format.raw/*149.21*/("""}"""),format.raw/*149.22*/(""", 1000);
            </script>
"""),format.raw/*151.73*/("""

            """),format.raw/*153.13*/("""</div>
        </div>
    </div>
    </div>
""")))}))
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
                  HASH: c79f51dcc020226dd6cf15aecd384edc2f515b3f
                  MATRIX: 825->84|992->156|1020->159|1044->175|1082->176|1114->182|1148->190|1176->198|1241->236|1269->237|1315->256|1343->257|1384->271|1419->279|1447->280|1494->300|1522->301|1555->307|1601->326|1630->334|2105->782|2120->788|2173->819|2775->1470|2837->1504|3269->2015|3327->2045|3893->2584|3923->2592|3953->2593|4657->3270|4672->3276|4723->3305|5550->4105|5580->4113|5610->4114|6749->5225|6778->5226|6829->5248|7007->5397|7037->5398|7092->5424|7295->5598|7325->5599|7384->5629|7634->5850|7664->5851|7715->5873|7745->5874|7794->5894|7824->5895|7911->5953|7941->5954|7992->5976|8174->6129|8204->6130|8259->6156|8462->6330|8492->6331|8551->6361|8749->6530|8779->6531|8830->6553|8860->6554|8909->6574|8939->6575|9014->6621|9044->6622|9099->6648|9135->6655|9165->6656|9224->6686|9314->6748|9344->6756|9411->6794|9441->6795|9504->6829|9596->6892|9626->6893|9762->7000|9792->7001|9855->7035|10076->7227|10106->7228|10174->7267|10204->7268|10285->7320|10315->7321|10383->7360|10413->7361|10494->7413|10524->7414|10592->7453|10622->7454|10766->7569|10796->7570|10851->7596|10881->7597|10934->7621|10964->7622|11026->7727|11071->7743
                  LINES: 23->4|28->4|29->5|29->5|29->5|30->6|30->6|30->6|32->8|32->8|32->8|32->8|33->9|33->9|33->9|33->9|33->9|34->10|35->11|35->11|44->20|44->20|44->20|54->30|55->31|62->38|63->39|73->49|73->49|73->49|87->63|87->63|87->63|100->76|100->76|100->76|123->99|123->99|124->100|127->103|127->103|128->104|131->107|131->107|132->108|136->112|136->112|137->113|137->113|138->114|138->114|139->115|139->115|140->116|143->119|143->119|144->120|147->123|147->123|148->124|151->127|151->127|152->128|152->128|153->129|153->129|154->130|154->130|155->131|155->131|155->131|156->132|157->133|157->133|158->134|158->134|159->135|160->136|160->136|162->138|162->138|163->139|166->142|166->142|166->142|166->142|167->143|167->143|167->143|167->143|168->144|168->144|168->144|168->144|171->147|171->147|172->148|172->148|173->149|173->149|175->151|177->153
                  -- GENERATED --
              */
          