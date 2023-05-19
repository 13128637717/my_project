package com.y.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.BoundZSetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangjiayao@kungeek.com
 * @version 1.0.0
 * @date 2022/10/28 10:56
 */
@Service
public class RedisServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisServer.class);

    ExecutorService executor = Executors.newFixedThreadPool(2);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void runLock () {
        while (true) {
            try {
                Thread.sleep(1000);
                if(getLock("com:test:lock")){
                    LOGGER.error("获取到锁com:test:lock");
                }
                Thread.sleep(5000);
            } catch (Exception e) {
            } finally {
                deleteLock("com:test:lock");
            }

        }
    }

    public boolean getLock(String key){
//        return Boolean.TRUE.equals(stringRedisTemplate.opsForValue().setIfAbsent(key, String.valueOf(System.currentTimeMillis())));

        BoundZSetOperations<String, String> ipCache =
                stringRedisTemplate.boundZSetOps("com:y:test");
        ipCache.add("aa", 14);
        ipCache.add("bb", 44);
        ipCache.remove("aa");

        BoundSetOperations<String, String> aa =
                stringRedisTemplate.boundSetOps("com:y:testb");
        aa.add("aa");
        aa.add("bb", "cc");
        aa.remove("aa");

        BoundListOperations<String, String> bb = stringRedisTemplate.boundListOps("com:y:testc");
        bb.leftPush("11");
        bb.leftPush("22");
        bb.leftPush("33");
        bb.rightPush("44");
        bb.set(1, "22222222222");
        bb.remove(3, "yyyy");
        return true;
    }

    public void deleteLock(String key) {
        if (stringRedisTemplate.opsForValue().get(key) != null) {
            stringRedisTemplate.delete(key);
            LOGGER.error("释放锁成功{}", key);
        }
    }

}
