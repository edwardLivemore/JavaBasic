package com.example.java_basic.MultiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo2 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 20, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(2000), new ThreadPoolExecutor.AbortPolicy());

        Inner inner = new Inner();

        List<Integer> list = new ArrayList<>();
        int count = 1000;
        for (int i = 0; i < count; i++) {
            list.add(i);
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            int finalI = i;
            executor.execute(() -> inner.showNum(finalI));
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println("done, cost : " + (end - start) + "ms");
    }
}

class Inner {
    public void showNum(int i) {
        System.out.println(i);
    }
}
