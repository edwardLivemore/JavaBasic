package com.example.java_basic.MultiThread;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolDemo3 {
    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(0);
        CountDownLatch latch = new CountDownLatch(5);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 5, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100), new CustomizableThreadFactory("myThread"),
                new ThreadPoolExecutor.AbortPolicy());

        for(int i = 0; i < 5; i++) {
            executor.execute(new MyTask(integer, latch));
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("result: " + integer.get());
    }
}

class MyTask implements Runnable {
    private AtomicInteger i;
    private CountDownLatch latch;

    public MyTask (AtomicInteger i, CountDownLatch latch) {
        this.i = i;
        this.latch = latch;
    }

    @Override
    public void run() {
        i.getAndIncrement();
        latch.countDown();
    }
}
