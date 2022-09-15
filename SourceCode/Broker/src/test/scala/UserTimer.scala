package Test


import scala.concurrent.duration.FiniteDuration
import scala.concurrent.duration._

object UserTimer {
  val wait_time_50mil: FiniteDuration = 50.milliseconds//this number is depended on application
  val wait_time_100mil: FiniteDuration = 100.milliseconds//this number is depended on application
  val wait_time_500mil: FiniteDuration = 500.milliseconds//this number is depended on application
  val one_sec: FiniteDuration = 1.seconds//this number is depended on application
  val ten_sec:FiniteDuration = 10.seconds
}
