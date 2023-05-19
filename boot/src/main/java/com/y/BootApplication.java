package com.y;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author wangjiayao@kungeek.com
 * @version 1.0.0
 * @date 2022/10/20 10:37
 */
@SpringBootApplication
@EnableScheduling
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

}
