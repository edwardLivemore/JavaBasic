package com.example.java_basic.MultiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SychronizedDemo {
    public static void main(String[] args) {
        Account from = new Account(100);
        Account to = new Account(0);

        ExecutorService executor = new ThreadPoolExecutor(4, 8,
                60, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(10), new ThreadPoolExecutor.AbortPolicy());

        int i = 0;
        while (i++ < 10) {
            executor.execute(() -> {
                while (from.getBalance() > 10) {
                    from.transfer(to, 10);
//                    try {
//                        Thread.sleep(0);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            });
        }
        executor.shutdown();
    }
}


class Account {
    private int balance;
    private Allocator allocator = Allocator.getInstance();

    public Account(int balance){
        this.balance = balance;
    }

    public synchronized int getBalance(){
        return this.balance;
    }

    void transfer(Account target, int money){
        while (!allocator.apply(this, target));

        try {
            synchronized (this){
                synchronized (target){
                    System.out.println(Thread.currentThread().getName() + ": Before from.balance : " + this.balance);
                    System.out.println(Thread.currentThread().getName() + ": Before to.balance : " + target.balance);
                    if(this.balance >= money){
                        this.balance -= money;
                        target.balance += money;
                        System.out.println(Thread.currentThread().getName() + ": After from.balance : " + this.balance);
                        System.out.println(Thread.currentThread().getName() + ": After to.balance : " + target.balance);
                    }
                }
            }
        }finally {
            allocator.free(this, target);
        }
    }

}

class Allocator {
    private static volatile Allocator instance;
    private final List<Account> als = new ArrayList<>();
    private Allocator(){}

    public static Allocator getInstance() {
        if(instance == null){
            synchronized (Allocator.class){
                if(instance == null){
                    instance = new Allocator();
                }
            }
        }
        return instance;
    }

    synchronized boolean apply(Account from, Account to){
        while (als.contains(from) || als.contains(to)){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        als.add(from);
        als.add(to);
        return true;
    }

    synchronized void free(Account from, Account to){
        als.remove(from);
        als.remove(to);
        notifyAll();
    }

}

// class Test {
//     public static <T> void show(T one){
//         return;
//     }
// }