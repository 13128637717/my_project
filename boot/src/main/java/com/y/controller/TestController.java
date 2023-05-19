package com.y.controller;

import com.y.server.RedisServer;
import com.y.server.TestServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangjiayao@kungeek.com
 * @version 1.0.0
 * @date 2022/10/20 10:36
 */
@RestController
public class TestController {

    @Autowired
    private TestServer testServer;
    @Autowired
    private RedisServer redisServer;

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/hello")
    public String hello(){
        testServer.test1();
        LOGGER.error("hello");
        return "hello";
    }

    @GetMapping("/runLock")
    public String runLock(){
        redisServer.runLock();
        LOGGER.error("runLock");
        return "runLock";
    }

    @GetMapping("/getLock")
    public boolean getLock(String key){
        return redisServer.getLock(key);
    }

    @GetMapping("/delLock")
    public String delLock(String key){
        redisServer.deleteLock(key);
        return "delLock";
    }

    /**
     * 清理过期的超时插队执行的数据
     */
//    @Scheduled(fixedRate = 10000)
    public void syncJumpTheQueue() {
        LOGGER.error("xxxxxxxx定时任务Test2");
    }

}
