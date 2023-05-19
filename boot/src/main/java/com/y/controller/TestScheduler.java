package com.y.controller;

import com.y.server.TestServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author wangjiayao@kungeek.com
 * @version 1.0.0
 * @date 2022/10/20 11:03
 */
@Component
public class TestScheduler {

    @Autowired
    private TestServer testServer;

    private static final Logger LOGGER = LoggerFactory.getLogger(TestScheduler.class);

    /**
     * 定时任务
     */
//    @Scheduled(fixedRate = 5000)
    public void syncJumpTheQueue() {
        testServer.test1();
        LOGGER.error("定时任务Test1");
    }
}
