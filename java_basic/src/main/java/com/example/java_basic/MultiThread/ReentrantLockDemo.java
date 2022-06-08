package com.example.java_basic.MultiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReentrantLockDemo {
    public static void main(String[] args) {
        Storage storage = new Storage();
        // 定义生产者个数
        int producerNum = 5;
        // 定义消费者个数
        int consumerNum = 10;

        ExecutorService executorProducer = Executors.newFixedThreadPool(producerNum, Executors.defaultThreadFactory());
        ExecutorService executorConsumer = Executors.newFixedThreadPool(consumerNum, Executors.defaultThreadFactory());

        for (int i = 0; i < producerNum; i++) {
            executorProducer.execute(new Thread(() -> {
                while (true) {
                    try {
                        storage.produce();
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }));
        }

        for (int i = 0; i < consumerNum; i++) {
            executorConsumer.execute(new Thread(() -> {
                while (true) {
                    try {
                        storage.consume();
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }));
        }

        // for (int i = 0; i < producerNum; i++) {
        // new Thread(() -> {
        // while (true) {
        // try {
        // storage.produce();
        // // Thread.sleep(1000);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        // }
        // }).start();
        // }

        // for (int i = 0; i < consumerNum; i++) {
        // new Thread(() -> {
        // while (true) {
        // try {
        // storage.consume();
        // // Thread.sleep(1000);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        // }
        // }).start();
        // }

    }
}

@Slf4j
class Storage {
    // 定义消费品列表
    private final List<Integer> goods = new ArrayList<>();
    // private final Vector<Integer> goods = new Vector<>();
    private final ReentrantLock lock = new ReentrantLock(true);
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();
    private final Integer maxGoodsNum = 10;
    private final Random random = new Random();

    public void produce() {
        lock.lock();
        try {
            while (goods.size() >= maxGoodsNum) {
                // 等待有空余
                log.info("goods full !");
                notFull.await();
            }
            Integer goodsNumber = random.nextInt(10);
            goods.add(goodsNumber);
            log.info("{} produced goods: {}", Thread.currentThread().getName(), goodsNumber);
            notEmpty.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        lock.lock();
        try {
            while (goods.size() == 0) {
                // 等待有货物
                log.info("goods empty !");
                notEmpty.await();
            }
            Integer goodsNumber = goods.remove(0);
            log.info("{} consumed goods: {}", Thread.currentThread().getName(), goodsNumber);
            notFull.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}