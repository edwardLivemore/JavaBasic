package com.example.java_basic.MultiThread;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class SpringGiftDemo {
    public static ConcurrentLinkedQueue<SpringGift> queue;
    public static SpringGift cuurGift;
    public static AtomicInteger count = new AtomicInteger();

    static class MyThread implements Runnable {
        @Override
        public void run() {
            handleEvent();
        }
    }

    public static void handleEvent() {
        try {
            SpringGift gift = getGift();
            if (gift == null || gift.getRemainCount() <= 0) {
                System.out.println("没有了");
                return;
            }
            if (gift != null && gift.getGift().getAndDecrement() > 0) {
                System.err.println("抢到一个红包");
                count.getAndIncrement();
            }
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static SpringGift getGift() {
        // 防止多条线程同时弹出队首
        synchronized (queue) {
            if (cuurGift == null || cuurGift.getRemainCount() <= 0) {
                cuurGift = queue.poll();
            }
            return cuurGift;
        }
    }

    public static void main(String[] args) {
        final ArrayList<Integer> a = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
            }
        };

        a.add(3);
        // System.out.println(a.size());

        queue = new ConcurrentLinkedQueue<SpringGift>();
        for (int i = 0; i < 10; i++) {
            SpringGift gift = new SpringGift();
            gift.setRole("role" + i);
            gift.setGift(new AtomicInteger(50));
            queue.add(gift);
        }

        MyThread myThread = new MyThread();
        for (int i = 0; i < 1000; i++) {
            new Thread(myThread).start();
        }

        System.out.println("总共收到" + count.get());
    }

}

class SpringGift {
    private String role;
    private AtomicInteger gift;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public AtomicInteger getGift() {
        return gift;
    }

    public void setGift(AtomicInteger gift) {
        this.gift = gift;
    }

    public int getRemainCount() {
        return this.gift.get();
    }
}