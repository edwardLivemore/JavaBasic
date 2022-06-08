package com.example.java_basic.MultiThread;

import java.util.concurrent.*;

public class ThreadLocalDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        ThreadLocal<String> tl = new ThreadLocal<>();

        es.execute(() -> System.out.println("thread: " + Thread.currentThread().getName() + " running..."));
        Future<String> result = es.submit(() -> {
            String r;
            try {
                tl.set("done");
                r = tl.get();
                System.out.println("thread: " + Thread.currentThread().getName() + " running...");
                System.out.println("r == tl.get() ? " + r == tl.get());
            } finally {
                tl.remove();
            }

            return r;
        });

        System.out.println("thread: " + Thread.currentThread().getName() + " running...");
        System.out.println("result: " + result.get());
        es.shutdown();
    }
}