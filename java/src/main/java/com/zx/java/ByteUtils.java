package com.zx.java;

/**
 * @author zhouxu
 * @descripe
 * @e-mail 374952705@qq.com
 * @time 2022/5/27
 */


class ByteUtils {

    private static char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String byteArray2Hex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        int num;
        for (byte b : bytes) {
            num = b < 0 ? 256 + b : b;
            sb.append(HEX_CHAR[num / 16]).append(HEX_CHAR[num % 16]);
        }
        return sb.toString();
    }


    /**
     * hex字符串转byte数组
     *
     * @param inHex 待转换的Hex字符串
     * @return 转换后的byte数组结果
     */

    public static byte[] hexToByteArray(String inHex) {

        int hexlen = inHex.length();

        byte[] result;

        if (hexlen % 2 == 1) {

            hexlen++;
            result = new byte[(hexlen / 2)];
            inHex = "0" + inHex;

        } else {
            result = new byte[(hexlen / 2)];

        }

        int j = 0;

        for (int i = 0; i < hexlen; i += 2) {
            result[j] = hexToByte(inHex.substring(i, i + 2));
            j++;
        }

        return result;
    }

    public static byte hexToByte(String inHex){

        return (byte)Integer.parseInt(inHex,16);

    }
}
