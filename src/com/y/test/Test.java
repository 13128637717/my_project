package com.y.test;

/**
 * @author wangjiayao@kungeek.com
 * @version 1.0.0
 * @date 2022/7/4 14:00
 */
public class Test {
    public static void main(String[] args) {
        ExecutorsTest executorsTest = new ExecutorsTest();
        ExecutorsTest executorsTest2 = new ExecutorsTest();
        ExecutorsTest executorsTest3 = new ExecutorsTest();

        executorsTest.test1();
        executorsTest2.test1();
        executorsTest3.test1();

        executorsTest.shutdown();
        executorsTest2.shutdown();
        executorsTest3.shutdown();
    }

}
