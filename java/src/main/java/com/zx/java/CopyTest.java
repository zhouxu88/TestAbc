package com.zx.java;

import java.util.ArrayList;
import java.util.Arrays;

import static com.zx.java.ByteUtils.byteArray2Hex;
import static com.zx.java.ByteUtils.hexToByteArray;

/**
 * @author zhouxu
 * @descripe
 * @e-mail 374952705@qq.com
 * @time 2022/5/27
 */


class CopyTest {

    private static int mMkiLength = 8;
    private static int AUTH_TAG_LEN = 16;

    public static void main(String[] args) {
//        String mode = Integer.toHexString(3);
//        System.out.println("mode: "+mode);

        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        list.add("abc");
        list.add("abc");
        for (int i = 0; i < list.size(); i++) {
            if (i == 1) {
                list.remove(i);
            }
        }

    }


    private static void removeMki(byte[] srtpBuffer, int srtpBufferLen) {
        int mkiLen = mMkiLength / 2;
        int authTagLen = AUTH_TAG_LEN / 2;
        int tailLen = mkiLen + authTagLen;

        System.out.println("removeMki enter, mkiLen:" + mkiLen + " tailLen: " + tailLen);
        System.out.println("removeMki, srtpBuffer:" + byteArray2Hex(srtpBuffer));
        byte[] newBuffer = new byte[srtpBufferLen - mkiLen];
        byte[] mki = new byte[mkiLen];
        System.arraycopy(srtpBuffer, 0, newBuffer, 0, srtpBufferLen - tailLen);
        System.out.println("removeMki, newBuffer:" + byteArray2Hex(newBuffer));

        System.arraycopy(
                srtpBuffer, srtpBufferLen - authTagLen,
                newBuffer, srtpBufferLen - tailLen, authTagLen
        );

        System.out.println("removeMki, newBuffer:" + byteArray2Hex(newBuffer));


        System.arraycopy(
                srtpBuffer, srtpBufferLen - tailLen,
                mki, 0, mkiLen
        );
        System.out.println("removeMki, mki:" + byteArray2Hex(mki));
    }
}
