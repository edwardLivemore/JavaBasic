package com.example.java_basic.MultiThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        A a = new A();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 100, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(100));

        while (a.getNum() < 10) {
            CountDownLatch latch = new CountDownLatch(2);

            executor.execute(() -> {
                a.add();
                System.out.println(Thread.currentThread().getName() + " num: " + a.getNum());
                latch.countDown();
            });

            executor.execute(() -> {
                a.add();
                System.out.println(Thread.currentThread().getName() + " num: " + a.getNum());
                latch.countDown();
            });

            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " num: " + a.getNum());
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
    }
}
