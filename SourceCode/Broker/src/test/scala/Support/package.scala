import Core.Supporter.SupportFunction.StringHelper

package object packetList {
  /* ------------------ List of request packets ------------------ */

  //Connect(Header(false,0,false),ConnectFlags(false,false,false,0,false,true,0),myclientid,None,None,None,None)
  val connectPack1 = "101600044d51545404020000000a6d79636c69656e746964".toByteString
  //Connect(Header(false,0,false),ConnectFlags(false,false,false,0,false,true,0),myclientid2,None,None,None,None)
  val connectPack2 = "101700044d51545404020000000b6d79636c69656e74696432".toByteString
  //Connect(Header(false,0,false),ConnectFlags(false,false,false,0,false,true,0),myclientid3,None,None,None,None)
  val connectPack3 = "101700044d51545404020000000b6d79636c69656e74696433".toByteString
  //Connect(Header(false,0,false),ConnectFlags(false,false,false,0,false,true,0),myclientid4,None,None,None,None)
  val connectPack4 = "101700044d51545404020000000b6d79636c69656e74696434".toByteString
  //Connect(Header(false,0,false),ConnectFlags(false,false,false,0,false,true,0),myclientid5,None,None,None,None)
  val connectPack5 = "101700044d51545404020000000b6d79636c69656e74696435".toByteString


  //Connect(Header(false,0,false),ConnectFlags(false,false,false,0,false,true,0),clean retained,None,None,None,None)
  val connectPackRetainedFlag = "101a00044d51545404020000000e636c65616e2072657461696e6564".toByteString
  //Disconnect(Header(false,0,false))
  val disconnectPack = "e000".toByteString
  val conackPack = "20020000".toByteString //Connack(Header(false,0,false),0)

  /* ------------------ List of sub test packets ------------------ */

  val subPack1 = "8206000200012300".toByteString //Subscribe(Header(false,1,false),2,Vector((#,0)))
  val subACK1 = "9003000200".toByteString //Suback(Header(false,0,false),2,Vector(0))

  val subPack2 = "820b00020006546f7069634102".toByteString //Subscribe(Header(false,1,false),2,Vector((TopicA,2)))
  val subACK2 = "9003000202".toByteString //Suback(Header(false,0,false),2,Vector(2))

  /* ------------------ List of pub test packets ------------------ */
  //qos = 0 -> no ACK
  //qos = 1 -> ACK
  //qos = 2 -> Pub(c) - Pubrec(b) - Pubrel(c) - Pubcomp(b)

  //publish qos = 0
  val pubPack0 = "300d0006546f70696341716f732030".toByteString //Publish(Header(false,0,false),TopicA,0,ByteVector(5 bytes, 0x716f732030))

  //publish qos = 1
  val pubPack1 = "320f0006546f706963410001716f732031".toByteString //Publish(Header(false,1,false),TopicA,1,ByteVector(5 bytes, 0x716f732031))
  val pubACK1 = "40020001".toByteString //Puback(Header(false,0,false),1)

  //publish qos = 2
  val pubPack2 = "340f0006546f706963410002716f732032".toByteString //Publish(Header(false,2,false),TopicA,2,ByteVector(5 bytes, 0x716f732032)) -> qos = 2
  val pubrel2 = "62020002".toByteString //Pubrel(Header(false,1,false),2)
  val pubrec2 = "50020002".toByteString //Pubrec(Header(false,0,false),2)
  val pubcomp2 = "70020002".toByteString //Pubcomp(Header(false,0,false),2)
}
