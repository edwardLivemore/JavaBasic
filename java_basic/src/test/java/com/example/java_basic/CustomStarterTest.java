package com.example.java_basic;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class CustomStarterTest {
    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    @Test
    public void test() {
        log.info("corePoolSize: {}, maxPoolSize:{}, keepAliveTime: {}", threadPoolExecutor.getCorePoolSize(),
                threadPoolExecutor.getMaximumPoolSize(), threadPoolExecutor.getKeepAliveTime(TimeUnit.SECONDS));
    }
}
