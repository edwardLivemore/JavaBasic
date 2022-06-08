package com.example.java_basic.MultiThread;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor executor1 = ThreadPoolDemo.getExecutor();
        ThreadPoolExecutor executor2 = ThreadPoolDemo.getExecutor();

        long start = System.currentTimeMillis();

        for(int i = 0; i < 10000; i++) {
            executor1.execute(MyClass::showNum);
        }
        executor1.shutdown();
        while (!executor1.isTerminated());

        for(int i = 0; i < 10000; i++) {
            executor2.execute(MyClass::showNum);
        }
        executor2.shutdown();
        while (!executor2.isTerminated());

        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }

    public static ThreadPoolExecutor getExecutor(){
        return new ThreadPoolExecutor(4, 5, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10000), new AbortPolicy());
    }
}

@Slf4j
class MyClass {
    private static final Random random = new Random();

    public static void showNum(){
        log.info("thread: {} , num : {}", Thread.currentThread().getName(), random.nextInt(10));
    }
}
