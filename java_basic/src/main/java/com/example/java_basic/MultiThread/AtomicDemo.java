package com.example.java_basic.MultiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    // plan A
    AtomicInteger count = new AtomicInteger(0);
    List<Integer> arrays = new ArrayList<>();

    public void addTo(int total) {
        while (count.get() < total) {
//            System.out.println(i);
            int value = count.incrementAndGet();
            arrays.add(value);
            System.out.println(Thread.currentThread().getName() + ":" + value);
//            if (value == total) {
//                System.out.println("end");
//            }
        }
    }

    // plan B
//    private int count = 0;
//
//    public synchronized void add(int num) {
//        while (count < num) {
//            count++;
//            System.out.println(Thread.currentThread().getName() + ":" + count);
//            if (count == 100) {
//                System.out.println("end");
//            }
//        }
//    }

    public static void main(String[] args) {
        AtomicDemo atomicDemo = new AtomicDemo();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(8, 8,
                60, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(10), new ThreadPoolExecutor.AbortPolicy());

        long startTime = System.currentTimeMillis();
        int i = 0;
        while (i++ < 10) {
            executor.execute(() -> {
                atomicDemo.addTo(1000);
            });
        }
        executor.shutdown();
        while (!executor.isTerminated()) ;
        long endTime = System.currentTimeMillis();
        System.out.println("duration : " + (endTime - startTime) + "ms");
        System.out.println("count = " + atomicDemo.count.get());
        System.out.println("array size = " + atomicDemo.arrays.size());
    }
}
