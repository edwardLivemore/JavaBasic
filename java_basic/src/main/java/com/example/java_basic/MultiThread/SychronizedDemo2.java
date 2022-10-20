package com.example.java_basic.MultiThread;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SychronizedDemo2 {
    final List<String> strList = new ArrayList<>();
    Random random = new Random();

    private void test() throws InterruptedException {
        synchronized (strList) {
            int count = random.nextInt(2);
            if (count == 0) {
                strList.add("a");
            } else {
                strList.clear();
            }
            while (strList.size() == 0) {
                log.info("Line AAA, {}", Thread.currentThread().getName());
                strList.wait();
                log.info("Line BBB, {}", Thread.currentThread().getName());
            }
            strList.notifyAll();
        }
    }

    public static void main(String[] args) {
        SychronizedDemo2 demo = new SychronizedDemo2();
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for(int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                try {
                    demo.test();
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                    throw new RuntimeException(e);
                }
            });
        }
        executorService.shutdown();
    }
}
