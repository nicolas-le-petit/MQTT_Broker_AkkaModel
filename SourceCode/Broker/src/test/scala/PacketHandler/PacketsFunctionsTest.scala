package PacketHandler

import Core.PacketHandler.{Connack, Connect, ConnectFlags, Header, Packet, Puback, Pubcomp, Publish, Pubrec, Pubrel, Suback, Subscribe}
import Core.Supporter.SupportFunction.StringHelper
import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestKit}
import akka.util.ByteString
import org.scalatest.BeforeAndAfterAll
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike
import org.specs2.mutable._
import scodec.Codec
import scodec.bits._

/*
@Brief: Test list below validates Packets_Handler's functions
        Trying to decode/encode the packets which
@Note : None
*/
class PacketsFunctionsTest extends TestKit(ActorSystem("PacketsSpec")) with ImplicitSender
                                                          with AnyWordSpecLike
                                                          with Matchers
                                                          with BeforeAndAfterAll  {

  "Test list with Packets Handler:" should {
    "HEADERs are decoded successfully with valid input - ok!" in {
      Codec[Header].decode(bin"0000").require.value mustEqual Header(false, 0, false)
      Codec[Header].decode(bin"1000").require.value mustEqual Header(true, 0, false)
      Codec[Header].decode(bin"0010").require.value mustEqual Header(false, 1, false)
      Codec[Header].decode(bin"0100").require.value mustEqual Header(false, 2, false)
      Codec[Header].decode(bin"0001").require.value mustEqual Header(false, 0, true)
    }

    "HEADER is encoded successfully with valid input - ok" in {
      Codec[Header].encode(Header(true, 1, true)).require mustEqual bin"1011"
    }

    "CONNECT is decoded successfully with valid input! - ok" in {
      Codec[Packet].decode(hex"100c00044d515454040200000000".bits).require.value mustEqual Connect(Header(false, 0, false), ConnectFlags(false, false, false, 0, false, true, 0), "")
    }

    "CONNACK is decoded successfully with valid input! - ok" in {
      Codec[Packet].decode(hex"20020000".bits).require.value mustEqual Connack(Header(false, 0, false), 0)
    }

    "SUBSCRIBE is decoded and encoded successfully with valid input! - ok" in {
      val p = Subscribe(Header(false,1,false),2,Vector(("TopicA",2)))
      Codec[Packet].decode(hex"820b00020006546f7069634102".bits).require.value mustEqual (p)
      Codec[Packet].encode(p).require mustEqual (hex"820b00020006546f7069634102".bits)
    }

    "SUBACK is decoded and encoded successfully with valid input! - ok" in {
      val p = Suback(Header(false,0,false),2,Vector(2))
      Codec[Packet].decode(hex"9003000202".bits).require.value mustEqual (p)
      Codec[Packet].encode(p).require mustEqual (hex"9003000202".bits)
    }

    "PUBLISH is decoded and encoded successfully with valid input! - ok" in {
      val p = Publish(Header(false,0,false),"TopicA",0,"qos 0")
      Codec[Packet].decode(hex"300d0006546f70696341716f732030".bits).require.value mustEqual (p)
      Codec[Packet].encode(p).require mustEqual (hex"300d0006546f70696341716f732030".bits)
    }

    "PUBACK is decoded and encoded successfully with valid input! - ok" in {
      val p = Puback(Header(false,0,false),1)
      Codec[Packet].decode(hex"40020001".bits).require.value mustEqual (p)
      Codec[Packet].encode(p).require mustEqual (hex"40020001".bits)
    }

    "PUBREL is decoded and encoded successfully with valid input! - ok" in {
      val p = Pubrel(Header(false,1,false),2)
      Codec[Packet].decode(hex"62020002".bits).require.value mustEqual (p)
      Codec[Packet].encode(p).require mustEqual (hex"62020002".bits)
    }

    "PUBREC is decoded and encoded successfully with valid input! - ok" in {
      val p = Pubrec(Header(false,0,false),2)
      Codec[Packet].decode(hex"50020002".bits).require.value mustEqual (p)
      Codec[Packet].encode(p).require mustEqual (hex"50020002".bits)
    }

    "PUBCOMP is decoded and encoded successfully with valid input! - ok" in {
      val p = Pubcomp(Header(false,0,false),2)
      Codec[Packet].decode(hex"70020002".bits).require.value mustEqual (p)
      Codec[Packet].encode(p).require mustEqual (hex"70020002".bits)
    }

    "Special case: PUBLISH with empty body - ok" in {
      val p = Publish(Header(false, 0, false), "TopicA/B", 0, "")
      Codec[Packet].decode(hex"300a0008546f706963412f42".bits).require.value mustEqual (p)
      Codec[Packet].encode(p).require mustEqual (hex"300a0008546f706963412f42".bits)
    }
  }
}
