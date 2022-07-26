package Core.PacketHandler

import scodec.Attempt.{Failure, Successful}
import scodec.bits.BitVector
import scodec.{Attempt, Codec, DecodeResult}

/*
@Brief: Encode and decode packets
@Note : None
*/
object PacketsHelper {
  //Either: nó sẽ chấp nhận 1 trong 2 kiểu dữ liệu được khai báo: Left hoặc Right
  def decode(b: BitVector): List[Either[Packet, Failure]] = {
    //decode here

    try {
      val packet = Codec[Packet].decode(b)

      packet match {
        case Successful(DecodeResult(p: Packet, r)) if r.length > 0 => {
          return Left(p) :: decode(r)
        }
        case Successful(DecodeResult(p: Packet, r)) if r.length == 0 => {
          return List(Left(p))
        }
        case x: Failure => {
          return List(Right(x))
        }
      }
    } catch {
      case err: Throwable => return List(Right(Failure(scodec.Err(err.getMessage))))

    }
  }

  //encode here
  def encode(b: Packet): Attempt[BitVector] = {

    val bytes = Codec[Packet].encode(b)
    return bytes
  }

  def format(l: List[Either[Packet, Failure]]): String = {
    l.map(format).mkString(", ")
  }

  def format(e: Either[Packet, Failure]): String = {
    e match {
      case Left(x) => {
        x.toString
      }
      case Right(f) => {
        f.toString
      }
    }
  }
}
