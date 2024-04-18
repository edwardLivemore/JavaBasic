package com.example.java_basic.MultiThread;

import java.util.concurrent.*;

public class FutureTaskDemo {
    public static void main(String[] args) {
        FutureTask<Integer> task = new FutureTask<>(() -> 1 + 2);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(task);
        try {
            System.out.println(task.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        new Thread(task).start();
        try {
            System.out.println(task.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
