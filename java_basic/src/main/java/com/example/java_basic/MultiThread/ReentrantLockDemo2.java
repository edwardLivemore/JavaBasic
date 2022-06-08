package com.example.java_basic.MultiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo2 {
    public static void main(String[] args) {
        Account2 from = new Account2(100);
        Account2 to = new Account2(0);

        ExecutorService executor = new ThreadPoolExecutor(4, 8,
                60, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(10), new ThreadPoolExecutor.AbortPolicy());

        int i = 0;
        while (i++ < 10){
            executor.execute(() -> {
                while (from.getBalance() > 10){
                    from.transfer(to, 10);
                }
            });
        }

        executor.shutdown();
    }
}

class Account2{
    private int balance;
    private Allocator2 allocator = Allocator2.getInstance();

    public Account2(int balance){
        this.balance = balance;
    }

    public synchronized int getBalance(){
        return this.balance;
    }

    public void transfer(Account2 target, int money){
        while (!allocator.apply(this, target));

        try {
            synchronized (this){
                synchronized (target){
                    System.out.println(Thread.currentThread().getName() + " Before from.balance : " + this.balance);
                    System.out.println(Thread.currentThread().getName() + " Before to.balance : " + target.balance);
                    if(balance >= money){
                        balance -= money;
                        target.balance += money;
                        System.out.println(Thread.currentThread().getName() + " After from.balance : " + this.balance);
                        System.out.println(Thread.currentThread().getName() + " After to.balance : " + target.balance);
                    }
                }
            }
        }finally {
            allocator.free(this, target);
        }
    }


}

class Allocator2 {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private final List<Account2> als = new ArrayList<>();

    private Allocator2(){}

    public static Allocator2 getInstance(){
        return Allocator2Holder.INSTANCE;
    }

    private static class Allocator2Holder{
        private final static Allocator2 INSTANCE = new Allocator2();
    }

    public boolean apply(Account2 from, Account2 to){
        lock.lock();
        try {
            while (als.contains(from) || als.contains(to)){
                condition.await();
            }
            als.add(from);
            als.add(to);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return false;
    }

    public void free(Account2 from, Account2 to){
        lock.lock();
        try {
            als.remove(from);
            als.remove(to);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
}