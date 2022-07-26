package Core.Supporter

import akka.io.Tcp
import akka.util.ByteString
import scodec.Attempt
import scodec.bits.{BitVector, ByteVector}

import java.nio.charset.StandardCharsets
/*
@Brief: Utilities
@Note : None
*/
object SupportFunction {


  implicit class ByteStringConvert(val s: ByteString) extends AnyVal {

    def toBitVector: BitVector = {
      BitVector(s)
    }

  }

  implicit class BitVectorHelper(val a: Attempt[BitVector]) extends AnyVal {

    def toTcpWrite: Tcp.Write = {
      Tcp.Write(ByteString(a.require.toByteBuffer))
    }

    def toTcpReceived: Tcp.Received = {

      Tcp.Received(ByteString(a.require.toByteBuffer))
    }
  }

  implicit class StringHelper(val s: String) extends AnyVal {

    def toBin: Array[Byte] = {

      s.replaceAll("[^0-9A-Fa-f]", "").sliding(2, 2).toArray.map(Integer.parseInt(_, 16).toByte)
    }

    def toByteVector: ByteVector = {
      ByteVector.encodeString(s)(StandardCharsets.UTF_8) match {
        case Right(res) => return res
        case Left(x) => throw x
      }
    }

    def toByteString: ByteString = {
      ByteString(s.toBin)
    }

    def toTcpReceived: Tcp.Received = {

      Tcp.Received(s.toByteString)

    }

    def toTcpWrite: Tcp.Write = {
      Tcp.Write(s.toByteString)
    }

  }

}
