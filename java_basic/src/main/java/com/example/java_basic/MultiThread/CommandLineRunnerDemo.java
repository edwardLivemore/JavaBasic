package com.example.java_basic.MultiThread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class CommandLineRunnerDemo implements CommandLineRunner {
    private static ExecutorService pool = Executors.newFixedThreadPool(8);

    public static void main(String[] args) {
        SpringApplication.run(CommandLineRunnerDemo.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for(int i = 0; i < 10; i++){
            pool.execute(() -> System.out.println(Thread.currentThread().getName() +  " : 1"));
        }
    }
}
