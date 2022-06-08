package com.example.java_basic.MultiThread;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = ThreadPoolDemo.getExecutor();

        for(int i = 0; i < 100; i++) {
            executor.execute(MyClass::showNum);
        }

        executor.shutdown();
    }

    public static ThreadPoolExecutor getExecutor(){
        return new ThreadPoolExecutor(4, 8, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10), new CallerRunsPolicy());
    }
}

@Slf4j
class MyClass {
    private static final Random random = new Random();

    public static void showNum(){
        log.info("thread: {} , num : {}", Thread.currentThread().getName(), random.nextInt(10));
    }
}
