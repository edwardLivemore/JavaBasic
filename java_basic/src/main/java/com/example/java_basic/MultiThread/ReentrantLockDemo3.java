package com.example.java_basic.MultiThread;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ReentrantLockDemo3 {
    public static void main(String[] args) {
        RedBag bag = new RedBag(100, 10, 0);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20,
                60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(1000),
                new CustomizableThreadFactory("redbag-pool"),
                new ThreadPoolExecutor.CallerRunsPolicy());

        // 模拟1000个用户同时抢红包
        IntStream.range(0, 500).forEach( i -> executor.execute(bag::getBag));
    }
}

@Data
@AllArgsConstructor
@Slf4j
class RedBag {
    private int sum;      // 总金额
    private int replica;    // 份数
    private int cRep; // 当前份数
    private final Random random = new Random();
    private final ReentrantLock lock = new ReentrantLock();

    public void getBag() {
        lock.lock();
        try {
            if (cRep >= replica) {
                log.info("红包抢完啦");
            } else {
                if (cRep < replica - 1) {
                    int current = random.nextInt(sum/replica) + 1;
                    log.info("恭喜你抢到了红包" + current + "元, cRep:" + (cRep + 1));
                    sum -= current;
                } else {
                    log.info("恭喜你抢到了红包" + sum + "元, cRep:" + (cRep + 1));
                }
                cRep++;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

