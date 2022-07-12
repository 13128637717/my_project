package com.y.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangjiayao@kungeek.com
 * @version 1.0.0
 * @date 2022/7/3 16:25
 */
public class ExecutorsTest {

    static ExecutorService executor = Executors.newSingleThreadExecutor();

    public void test1 () {
        System.out.println(executor);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程：" + Thread.currentThread().getName() + "===" + finalI);
                }
            });
        }
    }

    public void shutdown(){
        executor.shutdown();
    }

}
