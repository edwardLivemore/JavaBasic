package com.example.java_basic.MultiThread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
class ZeroEvenOdd {
    private int n;

    private AtomicInteger i = new AtomicInteger(1);
    private volatile boolean zeroFlag = true;
    private ReentrantLock lock = new ReentrantLock();
    private Condition zeroCond = lock.newCondition();
    private Condition evenCond = lock.newCondition();
    private Condition oddCond = lock.newCondition();


    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (i.get() <= n) {
            lock.lock();
            try {
                while (!zeroFlag) {
                    zeroCond.await();
                }
                if (i.get() <= n) {
                    printNumber.accept(0);
                } else {
                    log.info("zero do nothing, i: " + i.get());
                }
                zeroFlag = false;
                evenCond.signalAll();
                oddCond.signalAll();
            } finally {
                lock.unlock();
            }
        }
        log.info("zero method end");
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (i.get() <= n) {
            lock.lock();
            try {
                while (zeroFlag) {
                    evenCond.await();
                }
                if (i.get() % 2 == 0 && i.get() <= n)  {
                    printNumber.accept(i.getAndIncrement());
                    zeroFlag = true;
                } else {
                    log.info("even do nothing, i: " + i.get());
                }
                zeroCond.signalAll();
                oddCond.signalAll();
            } finally {
                lock.unlock();
            }
        }
        log.info("even method end");
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (i.get() <= n) {
            lock.lock();
            try {
                while (zeroFlag) {
                    oddCond.await();
                }
                if (i.get() % 2 == 1 && i.get() <= n) {
                    printNumber.accept(i.getAndIncrement());
                    zeroFlag = true;
                } else {
                    log.info("odd do nothing, i: " + i.get());
                }
                zeroCond.signalAll();
                evenCond.signalAll();
            } finally {
                lock.unlock();
            }
        }
        log.info("odd method end");
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);
        IntConsumer intConsumer = new IntConsumer();

        new Thread(() -> {
            try {
                zeroEvenOdd.zero(intConsumer);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }).start();
    }
}

@Slf4j
class IntConsumer {
    public void accept(int value) {
        log.info(String.valueOf(value));
    }
}
