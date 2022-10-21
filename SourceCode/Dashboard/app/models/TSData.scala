package models

import play.api.libs.json._
import services.MQTTServices
import slick.jdbc.SQLiteProfile.api._

import scala.collection.mutable
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.language.postfixOps

case class Device(id: Option[Int], name: String, device_code: String, description: String)
// Definition of the SUPPLIERS table
class Devices(tag: Tag) extends Table[Device](tag, "devices") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc) // This is the primary key column
  def name = column[String]("name")
  def description = column[String]("description")
  def device_code = column[String]("device_code", O.PrimaryKey)
  def * = (id.?, name, device_code, description) <> (Device.tupled, Device.unapply)
}

//case class Payload(id: Option[Int], msg: String, topic: String, time: Int, device_code: String)
//class Payload(tag: Tag) extends Table[Device](tag, "payloads") {
//  def id = column[Int]("id", O.PrimaryKey, O.AutoInc) // This is the primary key column
//  def msg = column[String]("msg")
//  def topic = column[String]("topic")
//  def time = column[Int]("time")
//  def device_code = column[String]("device_code", O.PrimaryKey)
//  def * = (id.?, msg, topic, time, device_code) <> (Payload.tupled, Payload.unapply)
//  // Every table needs a * projection with the same type as the table's type parameter
//  //  def * = (id.?, name, device_code, description)
//}
class DeviceItem(val _id: Option[Int], val _name: String, val _code: String, val _des: String) {
  var id: Option[Int] = _id
  var name: String = _name
  var code: String = _code
  var des: String = _des
}

class PayloadItem(val _clientID: String, val _topic: String, val _payload: String) {
  var clientID: String = _clientID
  var topic: String = _topic
  var payload: String = _payload
}
case class data(clientID: String, topic: String, payload: String)
object TSData{
  val devicesTable = TableQuery[Devices]
  val db = Database.forConfig("dbSqlite.db")
  var sessions = mutable.Map[String, MQTTServices]()

  def createSession(device_code: String): Boolean = {
    if (sessions.contains(device_code)) {
      false
    } //if the device already exists
    else {
      sessions(device_code) = new MQTTServices(device_code)
      true
    }
  }

  //for device management
  def addItem(device_name: String, device_code: String, device_description: String): Unit = {
    val query = db.run(devicesTable.filter(i => i.device_code === device_code || i.name === device_name).exists.result)
    val check = Await.result(query, 5 seconds).asInstanceOf[Boolean]
    if (!check) {
      val addNewDevice = (devicesTable returning devicesTable.map(_.id)) += Device(None, device_name, device_code, device_description)
      val test = Await.result(db.run(addNewDevice), 20 seconds)
    }
  }

  def getDeviceList(): List[DeviceItem] = {
    var devicesList: List[DeviceItem] = List()
    val action = db.run(devicesTable.result)
    val future = Await.result(action, 20 seconds)

    future.foreach (row => {
        devicesList = new DeviceItem(row.id, row.name, row.device_code, row.description) :: devicesList
    })
    println(devicesList)
    devicesList
  }

  def editItem(device_code: String, nName: String, nCode: String, nDes: String): Unit = {
    val query = devicesTable.filter(_.device_code === device_code)
      .map(devicesTable=>(devicesTable.name, devicesTable.device_code, devicesTable.description)).update(nName, nCode, nDes)
//    val editDevice = query.update(nName, nCode, nDes)
    val update = Await.result(db.run(query), 10 seconds)
  }

  def deleteItem(device_code: String): Unit = {
    val query = devicesTable.filter(_.device_code === device_code)
    val deleteDevice = query.delete
    val delete = Await.result(db.run(deleteDevice), 10 seconds)
  }
}
