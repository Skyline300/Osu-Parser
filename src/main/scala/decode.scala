
import scodec.bits._
import scodec.codecs._
import upickle.default._
import java.nio.ByteBuffer


import java.io.{BufferedInputStream, FileInputStream}
import scala.collection.mutable.ArrayBuffer

object decode {
    var offset = 0
  // val otp = hex"54686973206973206e6f74206120676f6f642070616420746f2075736521".bits
  // otp: scodec.bits.BitVector = BitVector(240 bits, 0x54686973206973206e6f74206120676f6f642070616420746f2075736521)

  // val bits = hex"746be39ece241e0da28b7acd4fad63632249ec5e2e402d5a0b2cd95d0a05".bits
  // bits: scodec.bits.BitVector = BitVector(240 bits, 0x746be39ece241e0da28b7acd4fad63632249ec5e2e402d5a0b2cd95d0a05)

  // val decoded = (bits ^ otp) rotateLeft 3
  // decoded: scodec.bits.BitVector = BitVector(240 bits, 0x001c576f726b696e6720776974682062696e617279206973206561737921)

  // val msg = variableSizeBytes(uint16, utf8).decode(decoded).require.value
  //msg: String = Working with binary is easy!
  
  def decodeFrom(otp: BitVector, bits: BitVector): Any = {
    val decoded = (bits ^ otp) rotateLeft 3
    variableSizeBytes(uint16, utf8).decode(decoded).require.value
  }

  def getMode(buffer: Byte): String = {
    buffer match {
      case 0 => "STD"
      case 1 => "Taiko"
      case 2 => "CtB"
      case 3 => "Mania"
      case _ => "could not find game mode"
    }
  }
  def decodeInt(buffer: ArrayBuffer[Byte]): Int ={
    val decodedBuffer = ByteBuffer.wrap(buffer.toArray.reverse)
    decodedBuffer.getInt
  }
  def decodeShort(buffer: ArrayBuffer[Byte]): Short = {
    val decodedBuffer = ByteBuffer.wrap(buffer.toArray.reverse)
    decodedBuffer.getShort()
  }
  def decodeLong(buffer: ArrayBuffer[Byte]): Long = {
    val decodedBuffer = ByteBuffer.wrap(buffer.toArray.reverse)
    decodedBuffer.getLong()
  }
  def decodeByte(buffer: ArrayBuffer[Byte]): Byte ={
      1
  }
  def decodeString(buffer: ArrayBuffer[Byte]): Any = {
    buffer(0) match {
      case 11 => "something"
      case 0 => "nothing"
    }
  }
  def decodeWithUpickle(file: BufferedInputStream): Any = {

  }

  def getStringLength(buffer: ArrayBuffer[Byte]): Any ={
    var result = 0
    var shift = 0
    while (true) {
      buffer
    }
  }

}
