package com.y.test.proxy;

/**
 * @author wangjiayao@kungeek.com
 * @version 1.0.0
 * @date 2023/1/31 9:22
 */
public class RenterProxy implements Person {

    Person person = new Renter();

    @Override
    public void rentHouse() {
        System.out.println("中介带看房");
        person.rentHouse();
        System.out.println("收中介费");
    }

    /**
     * 静态代理测试方法
     * @param args
     */
    public static void main(String[] args) {
        RenterProxy proxy = new RenterProxy();
        proxy.rentHouse();
    }
}
