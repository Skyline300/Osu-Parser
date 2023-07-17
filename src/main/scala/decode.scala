
import scodec.bits._
import scodec.codecs._
import upickle.default._

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
  def decodeInt(buffer: ArrayBuffer[Byte]): Int ={
    offset += 4
     1
  }
  def decodeShort(buffer: ArrayBuffer[Byte]): Short = {
      1
  }
  def decodeLong(buffer: ArrayBuffer[Byte]): Long = {
      1
  }
  def decodeByte(buffer: ArrayBuffer[Byte]): Byte ={
      1
  }
  def decodeString(buffer: ArrayBuffer[Byte]): String = {
    ""
  }
  def decodeWithUpickle(file: BufferedInputStream): Any = {

  }
  
}
