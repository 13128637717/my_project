package com.y.test;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author wangjiayao@kungeek.com
 * @version 1.0.0
 * @date 2022/3/14 10:00
 */
public class MyExecutor {

    private LinkedBlockingDeque<Runnable> task;

    private boolean isRuning = true;


    public MyExecutor(int coreSize, int queueSize) {
        task = new LinkedBlockingDeque<>(queueSize);
        for (int i = 0; i < coreSize; i++) {
            new MyThread().start();
        }
    }

    class MyThread extends Thread{
        @Override
        public void run() {
            while (isRuning || task.size() > 0){
                Runnable runnable = task.poll();
                if(runnable != null){
                    runnable.run();
                }
            }
        }
    }

    public void execute(Runnable runnable){
        task.offer(runnable);
    }

    public static void main(String[] args) {
        MyExecutor myExecutor = new MyExecutor(2, 10);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            myExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "====" + finalI);
                }
            });
        }
        myExecutor.isRuning = false;
    }
}

