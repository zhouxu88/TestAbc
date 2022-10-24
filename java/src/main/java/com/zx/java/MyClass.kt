package com.zx.java

import com.zx.java.ByteUtils.byteArray2Hex
import com.zx.java.ByteUtils.hexToByteArray
import java.lang.Exception
import java.util.*


fun main() {
    val rawData = "80e60022849e799a0b2b6a00e5d005d9a0e798dd749e329bd0b357dc2490d777b6ba0585fe90b05702a9f6ff9cabf67c8a9dc2f2d61348e4732989e4f436560c44d84d51845ae2bc7e89a16a06993ace6d75fa421fa2f75a6fe3f329b339e71737a4ad04a288b5f95e7fc7df38a3403fa3b9bbb463136001efe9e4feaa0bede62904b1d2cfa22c17abb7de885021b99f155ab6da36fdd8c61505076c8cf92743b63e4a812fcf4495ba1cc158d390c182684856f7a5a19a88d0a3499eb3d05139af41d085d13a389f6e6e86de486667925761373f81c88118d19c3f05396b58df83457f877fea89bcf4b4c8"
    val srtpBuffer = hexToByteArray(rawData)
//   MyClass().removeMki(srtpBuffer,srtpBuffer.size)


}

class MyClass {
    private val mMkiLength = 8
    private val AUTH_TAG_LEN = 16

    /**
     * 收到的srtp密文数据中删除mki
     * @param srtpBuffer 密文srtp包buffer
     * @param srtpBufferLen srtp数据长度
     * @return 删除mki后的srtp密文包
     */
    fun removeMki(
        srtpBuffer: ByteArray,
        srtpBufferLen: Int
    ) {
        val mkiLen = mMkiLength /2
        val authTagLen = AUTH_TAG_LEN/2
        val tailLen = mkiLen + authTagLen
        println("removeMki enter, mkiLen: $mkiLen , tailLen: $tailLen")

        val newBuffer = ByteArray(srtpBufferLen - mkiLen)
        val mki = ByteArray(mkiLen)
        System.arraycopy(srtpBuffer, 0, newBuffer, 0, srtpBufferLen - tailLen)
        println("removeMki, newBuffer:" + byteArray2Hex(newBuffer))
        System.arraycopy(
            srtpBuffer, srtpBufferLen - authTagLen,
            newBuffer, srtpBufferLen - tailLen, authTagLen
        )
        println("removeMki, srtpBuffer:" + byteArray2Hex(srtpBuffer))
        println("removeMki, newBuffer:" + byteArray2Hex(newBuffer))
        val rawBuffer = byteArray2Hex(srtpBuffer)
        println("removeMki, rawBuffer:$rawBuffer")
//        val mkis = rawBuffer.substring(newBuffer.size, 8)
//        MediaLog.dd("removeMki", "mkis:" + mkis)
//        val mki = mkis.toByteArray()
        System.arraycopy(
            srtpBuffer, srtpBufferLen - tailLen,
            mki, 0, mkiLen
        )
        println("removeMki, mki:" + byteArray2Hex(mki))
//        return InnerData(newBuffer, mki, srtpBufferLen - mkiLen)
    }


}