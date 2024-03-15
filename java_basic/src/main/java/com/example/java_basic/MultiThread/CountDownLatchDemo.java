package com.example.java_basic.MultiThread;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(100);
        A a = new A();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100), new CustomizableThreadFactory("myPool-"), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " current num: " + a.getNum());
                a.add();
                latch.countDown();
            });
        }

        try {
            latch.await();
            System.out.println("task over! " + Thread.currentThread().getName() + " num: " + a.getNum());
            executor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class A {
    private int num = 0;

    synchronized int getNum() {
        return this.num;
    }

    synchronized void add() {
        this.num++;
        System.out.println("add: " + Thread.currentThread().getName() + " num: " + this.num);
    }
}
