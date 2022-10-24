package com.zx.java;

import java.util.ArrayList;

/**
 * @author zhouxu
 * @descripe
 * @e-mail 374952705@qq.com
 * @time 2022/10/9
 */


class Test {
    public static void main(String[] args) {
        System.out.println("abc");
        ArrayList<String> list = new ArrayList<>();
        list.add("ab");
        list.add("abc");
        list.add("abcd");
        for (String s : list) {
//            if (s.equals("abc")){
//                list.remove(s);
//            }
            list.add("qqq");
        }
    }
}
