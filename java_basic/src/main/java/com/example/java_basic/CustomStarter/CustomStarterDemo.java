package com.example.java_basic.CustomStarter;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class CustomStarterDemo implements ApplicationRunner {
    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    public static void main(String[] args) {
        SpringApplication.run(CustomStarterDemo.class, args);

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("corePoolSize: {}, maxPoolSize:{}, keepAliveTime: {}", threadPoolExecutor.getCorePoolSize(),
                threadPoolExecutor.getMaximumPoolSize(), threadPoolExecutor.getKeepAliveTime(TimeUnit.SECONDS));
    }
}
