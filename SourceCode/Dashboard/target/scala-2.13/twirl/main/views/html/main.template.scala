
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
    </head>
    <body>
        """),format.raw/*19.32*/("""
        """),_display_(/*20.10*/content),format.raw/*20.17*/("""
            """),format.raw/*21.13*/("""<script src=""""),_display_(/*21.27*/assetsFinder/*21.39*/.path("js/jquery-3.6.1.min.js")),format.raw/*21.70*/(""""></script>
            <script src=""""),_display_(/*22.27*/assetsFinder/*22.39*/.path("js/bootstrap.min.js")),format.raw/*22.67*/(""""></script>
    </body>
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
                  HASH: e5bb3d1fb992b6dd7a77e930d98fdca66e1bc99d
                  MATRIX: 1067->327|1228->395|1256->396|1336->501|1372->510|1407->518|1433->523|1507->570|1528->582|1575->608|1637->732|1674->742|1702->749|1743->762|1784->776|1805->788|1857->819|1922->857|1943->869|1992->897
                  LINES: 27->8|32->9|33->10|36->13|37->14|37->14|37->14|38->15|38->15|38->15|41->19|42->20|42->20|43->21|43->21|43->21|43->21|44->22|44->22|44->22
                  -- GENERATED --
              */
          