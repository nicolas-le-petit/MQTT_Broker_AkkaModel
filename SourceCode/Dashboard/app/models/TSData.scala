package models

import akka.actor.Status.Success

import scala.collection.mutable
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import slick.jdbc.SQLiteProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.language.postfixOps

case class Device(id: Option[Int], name: String, device_code: String, description: String)
// Definition of the SUPPLIERS table
class Devices(tag: Tag) extends Table[Device](tag, "devices") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc) // This is the primary key column
  def name = column[String]("name")
  def description = column[String]("description")
  def device_code = column[String]("device_code", O.PrimaryKey)
  def * = (id.?, name, device_code, description) <> (Device.tupled, Device.unapply)
  // Every table needs a * projection with the same type as the table's type parameter
//  def * = (id.?, name, device_code, description)
}

class Topics(tag: Tag) extends Table[(String, String)](tag, "topics") {
  def name = column[String]("name")
  def device_code = column[String]("device_code", O.PrimaryKey)
  // Every table needs a * projection with the same type as the table's type parameter
  def * = (name, device_code)
}

class Payloads(tag: Tag) extends Table[(String, Int, Int, String)](tag, "payloads") {
  //  def id = column[Int]("id", O.PrimaryKey, O.AutoInc) // This is the primary key column
  def msg = column[String]("name")
  def topicID = column[Int]("device_code", O.PrimaryKey)
  def created = column[Int]("created")
  def device_code = column[String]("device_code")

  // Every table needs a * projection with the same type as the table's type parameter
  def * = (msg, topicID, created, device_code)
}

class DeviceItem(val _id: Option[Int], val _name: String, val _code: String, val _des: String) {
  var id: Option[Int] = _id
  var name: String = _name
  var code: String = _code
  var des: String = _des
}

object TSData{
  val devicesTable = TableQuery[Devices]
  val topicsTable = TableQuery[Topics]
  val payloadsTable = TableQuery[Payloads]

  val db = Database.forConfig("dbSqlite.db")

  var devicesCodeList = List[String]("")
  var devicesDesList = List[String]("")
  var devicesNameList = List[String]("")

  private val devices = mutable.Map[String, String]("device1" -> "client1")
  private val complex = mutable.Map[String, List[List[String]]]("device1" -> List(List()))
  private val topics = mutable.Map[String, List[String]]("device1" -> List())
  private val payloads = mutable.Map[String, List[String]]("alo" -> List())

  def validateDevices(deviceName: String, deviceID: String): Boolean = ???

  def createDevice(deviceName: String, deviceID: String): Boolean = {
    if (devices.contains(deviceName)) {
      false
    } //if the device already exists
    else {
      devices(deviceName) = deviceID
      true
    }
  }

  def getTopicList(deviceName: String): Seq[String] = {
    topics.get(deviceName).getOrElse(Nil)
  }

  def addTopic(deviceName: String, topic: String): Boolean = {
    if (topics(deviceName).contains(topic)) {
      println(s"opps!")
      false
    } //if the topic already exists
    else {
      topics(deviceName) = topic :: topics.get(deviceName).getOrElse(Nil)
      true
    }
  }

  def addData(topic: String, data: String): Unit = {
    payloads(topic) = data :: topics.get(topic).getOrElse(Nil)
    println(s"topic $topic now contains: " + topics(topic))
  }

  def getData(topic: String): Seq[String] = {
    println(s"get data: " + payloads.get(topic).getOrElse(Nil))
    payloads.get(topic).getOrElse(Nil)
  }

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
      .map(devicesTable=>(devicesTable.name, devicesTable.device_code, devicesTable.description))
    val editDevice = query.update(nName, nCode, nDes)
    val update = Await.result(db.run(editDevice), 10 seconds)
  }

  def deleteItem(device_code: String): Unit = {
    val query = devicesTable.filter(_.device_code === device_code)
    val deleteDevice = query.delete
    val delete = Await.result(db.run(deleteDevice), 10 seconds)
  }
}
