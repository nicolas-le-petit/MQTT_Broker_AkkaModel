
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

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,Html,AssetsFinder,play.twirl.api.HtmlFormat.Appendable] {

  /*
 * This template is called from the `index` template. This template
 * handles the rendering of the page header and body tags. It takes
 * three arguments, a `String` for the title of the page and an `Html`
 * object to insert into the body of the page and an `AssetFinder`
 * to define to reverse route static assets.
 */
  def apply/*8.2*/(title: String)(content: Html)(implicit assetsFinder: AssetsFinder):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*9.1*/("""
"""),format.raw/*10.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        """),format.raw/*13.62*/("""
        """),format.raw/*14.9*/("""<title>"""),_display_(/*14.17*/title),format.raw/*14.22*/("""</title>
        <link rel="stylesheet" href=""""),_display_(/*15.39*/assetsFinder/*15.51*/.path("css/bootstrap.css")),format.raw/*15.77*/("""">
        <link rel="stylesheet" href=""""),_display_(/*16.39*/assetsFinder/*16.51*/.path("toastr/toastr.min.css")),format.raw/*16.81*/("""">
        <script src=""""),_display_(/*17.23*/assetsFinder/*17.35*/.path("js/jquery-3.6.1.min.js")),format.raw/*17.66*/(""""></script>
        <script src=""""),_display_(/*18.23*/assetsFinder/*18.35*/.path("js/bootstrap.min.js")),format.raw/*18.63*/(""""></script>
        <script src=""""),_display_(/*19.23*/assetsFinder/*19.35*/.path("toastr/toastr.min.js")),format.raw/*19.64*/(""""></script>
    </head>
    <body>
        """),format.raw/*23.32*/("""
        """),_display_(/*24.10*/content),format.raw/*24.17*/("""

    """),format.raw/*26.5*/("""</body>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html,assetsFinder:AssetsFinder): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)(assetsFinder)

  def f:((String) => (Html) => (AssetsFinder) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => (assetsFinder) => apply(title)(content)(assetsFinder)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/main.scala.html
                  HASH: ac1fd1f85dc3b9afbec60694062d66c73153aafd
                  MATRIX: 1067->327|1228->395|1256->396|1336->501|1372->510|1407->518|1433->523|1507->570|1528->582|1575->608|1643->649|1664->661|1715->691|1767->716|1788->728|1840->759|1901->793|1922->805|1971->833|2032->867|2053->879|2103->908|2174->1041|2211->1051|2239->1058|2272->1064
                  LINES: 27->8|32->9|33->10|36->13|37->14|37->14|37->14|38->15|38->15|38->15|39->16|39->16|39->16|40->17|40->17|40->17|41->18|41->18|41->18|42->19|42->19|42->19|45->23|46->24|46->24|48->26
                  -- GENERATED --
              */
          