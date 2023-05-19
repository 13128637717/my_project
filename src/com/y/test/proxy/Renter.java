package com.y.test.proxy;

/**
 * @author wangjiayao@kungeek.com
 * @version 1.0.0
 * @date 2023/1/31 9:21
 */
public class Renter implements Person{
    @Override
    public void rentHouse() {
        System.out.println("房东租房！");
    }
}
