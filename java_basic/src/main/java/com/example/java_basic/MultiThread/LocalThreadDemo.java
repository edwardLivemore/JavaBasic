package com.example.java_basic.MultiThread;

import org.springframework.util.Assert;

import java.text.SimpleDateFormat;
import java.util.concurrent.Callable;

public class LocalThreadDemo {
    private static final ThreadLocal<SimpleDateFormat> fomatter = ThreadLocal.withInitial(() -> new SimpleDateFormat());

    private void test() {
        fomatter.remove();
    }
}

class MyThreadA implements Runnable{

    @Override
    public void run() {

    }
}

class MyThreadB implements Callable<String>{

    @Override
    public String call() throws Exception {
        return null;
    }
}
