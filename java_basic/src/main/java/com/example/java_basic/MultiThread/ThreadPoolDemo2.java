package com.example.java_basic.MultiThread;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadPoolDemo2 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 20, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100), new ThreadPoolExecutor.AbortPolicy());

        Map<Long, String> map = new HashMap<>();
        map.put(1L, "A");
        map.put(null, "B");
        System.out.println(map.getOrDefault(1L, null));
        System.out.println(map.getOrDefault(null, null));

        Inner inner = new Inner();

        List<Integer> list = new ArrayList<>();
        int count = 1000;
        for (int i = 0; i < count; i++) {
            list.add(i);
        }

        long start = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            int index = i;
            executor.execute(() -> inner.showNum(list, index));
        }
        executor.shutdown();

        long end = System.currentTimeMillis();
        log.info("done, cost : {} ms", end - start);
    }
}

@Slf4j
class Inner {
    public void showNum(List<Integer> list, int index) {
        if (index == 3) {
            throw new RuntimeException("Exception occurred");
        }
        list.forEach(x -> log.info("{}", x));
    }
}
