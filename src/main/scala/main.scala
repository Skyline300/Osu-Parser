import scodec.bits._
import scodec.codecs._
import upickle.default._

import java.io.{BufferedInputStream, FileInputStream}
import java.nio.ByteBuffer
import java.nio.ByteOrder
import scala.collection.mutable.ArrayBuffer
import scala.io.Source



object main{
  def main(array: Array[String]): Unit = {
    val otp = hex"54686973206973206e6f74206120676f6f642070616420746f2075736521".bits
    // otp: scodec.bits.BitVector = BitVector(240 bits, 0x54686973206973206e6f74206120676f6f642070616420746f2075736521)
    val bits = hex"746be39ece241e0da28b7acd4fad63632249ec5e2e402d5a0b2cd95d0a05".bits
    // bits: scodec.bits.BitVector = BitVector(240 bits, 0x746be39ece241e0da28b7acd4fad63632249ec5e2e402d5a0b2cd95d0a05)
    val filename = "C:\\Users\\Marcus\\AppData\\Local\\osu!\\Replays\\Skyline_300 - Rameses B - Timeless ft. Veela [Insane] (Monstercat Release) (2023-06-29) Osu.osr"

    val fileContents = new FileInputStream(filename)
    val bufferFileStream = new BufferedInputStream(fileContents)
    val arrBuffer = ArrayBuffer[Byte]()
    while (bufferFileStream.available() > 0) {
      val read = bufferFileStream.read().toByte
      // println(read)
      arrBuffer += read
    }
    println("---------The whole Buffer---------")
    //println(arrBuffer)
    val gameMode = decode.getMode(arrBuffer(0))
    println(gameMode)
    val version = arrBuffer.slice(1,5)
    val Hashmap = arrBuffer.drop(5)
    //val intVersion =  decode.decodeInt(version)
    println(decode.decodeString(Hashmap))
    // println(Hashmap)
    // val res = decode.decodeFrom(otp, bits)
    // val something = writeBinary(55)
    // println(something)
    // println(fileContents)
  }
}