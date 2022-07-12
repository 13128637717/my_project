package com.y.test.js;

import java.util.Scanner;

/**
 * @author wangjiayao@kungeek.com
 * @version 1.0.0
 * @date 2022/4/19 17:19
 */
public class Hj1 {
//    描述
//    计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
//    输入描述：
//    输入一行，代表要计算的字符串，非空，长度小于5000。
//
//    输出描述：
//    输出一个整数，表示输入字符串最后一个单词的长度。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
//        a = a.substring(a.lastIndexOf(" ") + 1);
//        System.out.println(a.length());
        String[] ss = a.split(" ");
        System.out.println(ss[ss.length-1].length());
    }
}
