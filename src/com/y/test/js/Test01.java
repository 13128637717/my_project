package com.y.test.js;

import java.util.*;

/**
 * @author wangjiayao@kungeek.com
 * @version 1.0.0
 * @date 2022/4/20 16:52
 */
public class Test01 {
//    3.输入整型数组和排序标识，对其元素按照升序或降序进行排序
//            描述
//    输入整型数组和排序标识，对其元素按照升序或降序进行排序
//
//    数据范围： 1  n \ 1000 \1≤n≤1000  ，元素大小满足 0  val  100000 \0≤val≤100000
//
//    输入描述：
//    第一行输入数组元素个数
//    第二行输入待排序的数组，每个数用空格隔开
//    第三行输入一个整数0或1。0代表升序排序，1代表降序排序
//
//    输出描述：
//    输出排好序的数字
//
//            示例1
//    输入：
//
//            8
//            1 2 4 9 3 55 64 25
//            0
//    输出：
//
//            1 2 3 4 9 25 55 64
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        Integer[] arr = new Integer[count];
        for (int i = 0; i < count; i++) {
            arr[i] = sc.nextInt();
        }
        int sortType = sc.nextInt();
        if(sortType == 0){
            Arrays.sort(arr, new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });

        }
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
