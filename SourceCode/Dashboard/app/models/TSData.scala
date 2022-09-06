//package models
//
//import play.api.libs.json.{JsValue, Writes, Json}
//import sorm.Persisted
//
//case class TSData(station: String, status: Boolean, temp: Double, humid: Double)
//
//object TSData {
//  implicit val tsdataWrites = new Writes[TSData with Persisted] {
//    def writes(tsdata: TSData with Persisted): JsValue = {
//      Json.obj(
//        "id" -> tsdata.id,
//        "station" -> tsdata.station,
//        "status" -> tsdata.status,
//        "temp" -> tsdata.temp,
//        "humid" -> tsdata.humid
//      )
//    }
//  }
//  implicit val tsdataReads = Json.reads[TSData]
//}
//
//import sorm._
//class DB extends Instance(
//  entities = Set(Entity[TSData]()),
//  url = "jdbc:h2:mem:test"
//)
