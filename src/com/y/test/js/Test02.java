package com.y.test.js;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wangjiayao@kungeek.com
 * @version 1.0.0
 * @date 2022/4/22 15:58
 */
public class Test02 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<String> strList = new ArrayList<String>();
        while(sc.hasNext()){
            String str = sc.next();
            strList.add(str.replace("0x",""));
        }
        for(String s : strList){
            Integer i = Integer.parseInt(s,16);
            System.out.println(i);
        }
    }

}
