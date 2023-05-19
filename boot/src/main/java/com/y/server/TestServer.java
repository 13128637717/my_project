package com.y.server;

import com.y.controller.TestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangjiayao@kungeek.com
 * @version 1.0.0
 * @date 2022/10/20 16:02
 */
@Service
public class TestServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestServer.class);

    ExecutorService executor = Executors.newFixedThreadPool(2);

    public void test1 () {
        LOGGER.error(this.toString());
        LOGGER.error("线程池：" + executor.toString());
        for (int i = 0; i < 6; i++) {
            int finalI = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    LOGGER.error("线程：" + Thread.currentThread().getName() + "===" + finalI);
                }
            });
        }
    }

}
