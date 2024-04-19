package com.example.java_basic.MultiThread;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo3 {
    public static void main(String[] args) {
        Vector<Integer> result = new Vector<>();
        CountDownLatch latch = new CountDownLatch(5);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 5, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100), new CustomizableThreadFactory("myThread"),
                new ThreadPoolExecutor.AbortPolicy());

        for(int i = 0; i < 5; i++) {
            executor.execute(new MyTask(i, result, latch));
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("result: " + result);
    }
}

class MyTask implements Runnable {
    private int i;
    private Vector<Integer> list;
    private CountDownLatch latch;

    public MyTask (int i, Vector<Integer> list, CountDownLatch latch) {
        this.i = i;
        this.list = list;
        this.latch = latch;
    }

    @Override
    public void run() {
        list.add(i);
        latch.countDown();
    }
}
