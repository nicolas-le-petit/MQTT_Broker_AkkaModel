import akka.actor.ActorSystem
import models.{Device, Devices}
import models.TSData.{db, devicesTable}
import org.scalatestplus.play._
import slick.jdbc.SQLiteProfile.api._

import scala.concurrent.duration._
import scala.concurrent.Await
import scala.language.postfixOps
class DatabaseTest extends PlaySpec {
  val db = Database.forConfig("dbSqlite.db")
  val devicesTable = TableQuery[Devices]
  var _id = 0
  "Database" should {

    "be creatable" in {
      val addNewDevice = (devicesTable returning devicesTable.map(_.id)) += Device(None, "device_name", "device_code", "device_description")
      val add = Await.result(db.run(addNewDevice), 20 seconds)
      (add) must be > 0
      _id = add
    }

    "be accessible" in {
      val query = db.run(devicesTable.filter(i => i.id === _id).exists.result)
      val result = Await.result(query, 5 seconds)
      (result) must equal(true)
    }

    "be editable" in {
      val query = devicesTable.filter(_.id === _id)
        .map(devicesTable => (devicesTable.name, devicesTable.device_code, devicesTable.description)).update("devicesTable.name", "devicesTable.device_code", "devicesTable.description")
      //    val editDevice = query.update(nName, nCode, nDes)
      val update = Await.result(db.run(query), 10 seconds)
      (update) must equal(1)
    }

    "be removable" in {
      val query = devicesTable.filter(_.id === _id).delete
      //    val editDevice = query.update(nName, nCode, nDes)
      val delete = Await.result(db.run(query), 10 seconds)
      (delete) must equal(1)
    }
  }
}
