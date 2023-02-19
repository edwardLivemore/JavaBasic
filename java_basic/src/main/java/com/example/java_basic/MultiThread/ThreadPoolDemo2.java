package com.example.java_basic.MultiThread;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

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

        long start = System.currentTimeMillis();
        Inner inner = new Inner();
        int[] array = IntStream.range(0, 1000).toArray();

        IntStream.range(0, 10).forEach(index -> executor.execute(() -> inner.showNum(array, index)));
        executor.shutdown();

        long end = System.currentTimeMillis();
        log.info("done, cost : {} ms", end - start);
    }
}

@Slf4j
class Inner {
    public void showNum(int[] array, int index) {
        if (index == 3) {
            throw new RuntimeException("Exception occurred");
        }
        for (int num : array) {
            log.info("index: {}, value: {}", index, num);
        }
    }
}
