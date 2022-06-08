package com.example.java_basic.MultiThread;

import java.util.concurrent.*;

public class ScheduleThreadPoolDemo {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor =
                new ScheduledThreadPoolExecutor(4, new ThreadPoolExecutor.AbortPolicy());

        executor.scheduleAtFixedRate(() -> System.out.println(System.currentTimeMillis()),
                0, 1, TimeUnit.SECONDS);

        executor.scheduleWithFixedDelay(() -> System.out.println("ABC"),
                0, 5, TimeUnit.SECONDS);
    }
}
