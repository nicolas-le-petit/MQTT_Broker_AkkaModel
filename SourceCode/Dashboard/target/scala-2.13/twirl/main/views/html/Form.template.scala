
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
                                <label for="retain">Retained Flag</label>
                                <input type="checkbox" id="retain_flag" name="retain_flag" value=true>
                            </div>

                            <div>
                                <label for="">QoS</label>
                                <select name="qos" id="qos">
                                    <option value=0>0</option>
                                    <option value=1>1</option>
                                    <option value=2>2</option>
                                </select>
                            </div><br>
                            <input type="hidden" name="PubClientID" id="PubClientID" value="""),_display_(/*42.93*/clientID),format.raw/*42.101*/(""" """),format.raw/*42.102*/("""class="form-control">
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
"""),format.raw/*53.74*/("""
                        """),format.raw/*54.25*/("""<div class="card bg-dark text-white">
                            <div class="card-header">SUBSCRIBE FORM</div>
                        </div><br>
                        <form id="subscribeForm" method="post" action=""""),_display_(/*57.73*/routes/*57.79*/.HomeController.MQTTsubscribe),format.raw/*57.108*/("""">
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
                            </div><br>
                            <input type="hidden" name="SubClientID" id="SubClientID" value="""),_display_(/*70.93*/clientID),format.raw/*70.101*/(""" """),format.raw/*70.102*/("""class="form-control">
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
                $('#publishForm').submit(function(e)"""),format.raw/*93.53*/("""{"""),format.raw/*93.54*/("""
                    """),format.raw/*94.21*/("""e.preventDefault();
                    toastr.warning('Publish ...');
                    console.log('publishForm');
                    $.ajax("""),format.raw/*97.28*/("""{"""),format.raw/*97.29*/("""
                        """),format.raw/*98.25*/("""type: "POST",
                        url: $(this).attr('action'),
                        data: $(this).serialize(),
                        success: function (response) """),format.raw/*101.54*/("""{"""),format.raw/*101.55*/("""
                            """),format.raw/*102.29*/("""toastr.success('Publish Success');
                            //console.log(response)
                            $('#pubTopic').val('');
                            $('#pubPayload').val('');
                        """),format.raw/*106.25*/("""}"""),format.raw/*106.26*/("""
                    """),format.raw/*107.21*/("""}"""),format.raw/*107.22*/(""");
                """),format.raw/*108.17*/("""}"""),format.raw/*108.18*/(""");
                $('#subscribeForm').submit(function(e)"""),format.raw/*109.55*/("""{"""),format.raw/*109.56*/("""
                    """),format.raw/*110.21*/("""e.preventDefault();
                    toastr.warning('Subscribe ...');
                    console.log('subscribeForm');
                    $.ajax("""),format.raw/*113.28*/("""{"""),format.raw/*113.29*/("""
                        """),format.raw/*114.25*/("""type: "POST",
                        url: $(this).attr('action'),
                        data: $(this).serialize(),
                        success: function (response) """),format.raw/*117.54*/("""{"""),format.raw/*117.55*/("""
                            """),format.raw/*118.29*/("""toastr.success('Subscribe Success');
                            //console.log(response);
                            $('#subTopic').val('');
                        """),format.raw/*121.25*/("""}"""),format.raw/*121.26*/("""
                    """),format.raw/*122.21*/("""}"""),format.raw/*122.22*/(""");
                """),format.raw/*123.17*/("""}"""),format.raw/*123.18*/(""");
                    setInterval(function()"""),format.raw/*124.43*/("""{"""),format.raw/*124.44*/("""
                        """),format.raw/*125.25*/("""$.ajax("""),format.raw/*125.32*/("""{"""),format.raw/*125.33*/("""
                            """),format.raw/*126.29*/("""type: "GET",
                            url: "/form/update/"""),_display_(/*127.49*/clientID),format.raw/*127.57*/("""",
                            data: """),format.raw/*128.35*/("""{"""),format.raw/*128.36*/("""
                                """),format.raw/*129.33*/("""clientID: $('#SubClientID').val()
                            """),format.raw/*130.29*/("""}"""),format.raw/*130.30*/(""",
                            dataType: "text",
                            success: function (response) """),format.raw/*132.58*/("""{"""),format.raw/*132.59*/("""
                                """),format.raw/*133.33*/("""let resArr = response.split("\n");
                                $("#result").find('tbody').append(`
                                    <tr>
                                        <td>$"""),format.raw/*136.46*/("""{"""),format.raw/*136.47*/("""resArr[0] != undefined ? resArr[0] : ''"""),format.raw/*136.86*/("""}"""),format.raw/*136.87*/("""</td>
                                        <td>$"""),format.raw/*137.46*/("""{"""),format.raw/*137.47*/("""resArr[1] != undefined ? resArr[1] : ''"""),format.raw/*137.86*/("""}"""),format.raw/*137.87*/("""</td>
                                        <td>$"""),format.raw/*138.46*/("""{"""),format.raw/*138.47*/("""resArr[2] != undefined ? resArr[2] : ''"""),format.raw/*138.86*/("""}"""),format.raw/*138.87*/("""</td>
                                    </tr>
                                `);
                            """),format.raw/*141.29*/("""}"""),format.raw/*141.30*/("""
                        """),format.raw/*142.25*/("""}"""),format.raw/*142.26*/(""");
                    """),format.raw/*143.21*/("""}"""),format.raw/*143.22*/(""", 1000);
            </script>
"""),format.raw/*145.73*/("""

            """),format.raw/*147.13*/("""</div>
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
                  HASH: e7081b5fcfa59e33452a99b053cd556460705308
                  MATRIX: 825->84|992->156|1020->159|1044->175|1082->176|1114->182|1148->190|1176->198|1241->236|1269->237|1315->256|1343->257|1384->271|1419->279|1447->280|1494->300|1522->301|1555->307|1601->326|1630->334|2105->782|2120->788|2173->819|3514->2133|3544->2141|3574->2142|4033->2646|4087->2672|4336->2894|4351->2900|4402->2929|5223->3723|5253->3731|5283->3732|6422->4843|6451->4844|6501->4866|6678->5015|6707->5016|6761->5042|6964->5216|6994->5217|7053->5247|7303->5468|7333->5469|7384->5491|7414->5492|7463->5512|7493->5513|7580->5571|7610->5572|7661->5594|7843->5747|7873->5748|7928->5774|8131->5948|8161->5949|8220->5979|8418->6148|8448->6149|8499->6171|8529->6172|8578->6192|8608->6193|8683->6239|8713->6240|8768->6266|8804->6273|8834->6274|8893->6304|8983->6366|9013->6374|9080->6412|9110->6413|9173->6447|9265->6510|9295->6511|9431->6618|9461->6619|9524->6653|9745->6845|9775->6846|9843->6885|9873->6886|9954->6938|9984->6939|10052->6978|10082->6979|10163->7031|10193->7032|10261->7071|10291->7072|10435->7187|10465->7188|10520->7214|10550->7215|10603->7239|10633->7240|10695->7345|10740->7361
                  LINES: 23->4|28->4|29->5|29->5|29->5|30->6|30->6|30->6|32->8|32->8|32->8|32->8|33->9|33->9|33->9|33->9|33->9|34->10|35->11|35->11|44->20|44->20|44->20|66->42|66->42|66->42|77->53|78->54|81->57|81->57|81->57|94->70|94->70|94->70|117->93|117->93|118->94|121->97|121->97|122->98|125->101|125->101|126->102|130->106|130->106|131->107|131->107|132->108|132->108|133->109|133->109|134->110|137->113|137->113|138->114|141->117|141->117|142->118|145->121|145->121|146->122|146->122|147->123|147->123|148->124|148->124|149->125|149->125|149->125|150->126|151->127|151->127|152->128|152->128|153->129|154->130|154->130|156->132|156->132|157->133|160->136|160->136|160->136|160->136|161->137|161->137|161->137|161->137|162->138|162->138|162->138|162->138|165->141|165->141|166->142|166->142|167->143|167->143|169->145|171->147
                  -- GENERATED --
              */
          