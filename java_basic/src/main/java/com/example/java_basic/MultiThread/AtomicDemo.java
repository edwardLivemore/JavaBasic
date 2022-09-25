package com.example.java_basic.MultiThread;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class AtomicDemo {
    // plan A
    AtomicInteger count = new AtomicInteger(0);
    List<Integer> list = new ArrayList<>();
    Vector<Integer> vector = new Vector<>();
    CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

    public void addToTotal() {
//        while (count.get() < 1000) {
////            System.out.println(i);
//            int value = count.incrementAndGet();
//            list.add(value);
//            System.out.println(Thread.currentThread().getName() + ":" + value);
////            if (value == total) {
////                System.out.println("end");
////            }
//        }

        while (true) {
            if (count.incrementAndGet() <= 100000) {
                int value = count.get();
//                log.info("{}", value);
//                list.add(value);
//                vector.add(value);
                copyOnWriteArrayList.add(value);
            } else {
                break;
            }
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

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20,
                60, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(10), new ThreadPoolExecutor.AbortPolicy());

        log.info("start...");
        long startTime = System.currentTimeMillis();
        int i = 0;
        while (i++ < 10) {
            executor.execute(atomicDemo::addToTotal);
        }
        executor.shutdown();
        while (!executor.isTerminated()) ;
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        long endTime = System.currentTimeMillis();
        System.out.println("duration : " + (endTime - startTime) + "ms");
        System.out.println("count = " + atomicDemo.count.get());
//        System.out.println("list size = " + atomicDemo.list.size());
//        System.out.println("vector size = " + atomicDemo.vector.size());
//        System.out.println("vector max value = " + Collections.max(atomicDemo.vector));
        System.out.println("copyOnWriteArrayList size = " + atomicDemo.copyOnWriteArrayList.size());
        System.out.println("copyOnWriteArrayList max value = " + Collections.max(atomicDemo.copyOnWriteArrayList));
        log.info("end");
    }
}
