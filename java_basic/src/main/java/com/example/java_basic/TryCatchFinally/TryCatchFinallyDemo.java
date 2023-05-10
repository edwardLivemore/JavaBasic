package com.example.java_basic.TryCatchFinally;

import java.util.ArrayList;
import java.util.List;

public class TryCatchFinallyDemo {
    public static void main(String[] args) throws MyException {
//        demo1();

//        int i = demo2();
//        System.out.println(i);

//        demo3();

        demo4();
    }

    private static void demo4() {
        List<Integer> arrays = new ArrayList<>();
        arrays.add(0);
        arrays.add(1);
        arrays.add(2);

        for (Integer num : arrays) {
            try {
                if (num == 1) {
                    throw new Exception();
                }
                System.out.println(num);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void demo3() {
        Long num = 0L;
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(num);
    }

    private static int demo2() {
        try {
            if(true){
                throw new MyException("");
            }
            return 0;
        }catch (Exception e){
            return 1;
        }finally {
            return 2;
        }
    }

    private static void demo1() throws MyException {
        try {
            System.out.println("main method");
            // System.exit(1);
            // return;
            throw new MyException("main exception");
        } catch (Exception e) {
            // System.exit(1);
            throw new MyException("catch exception");
            // System.out.println("catch myException");
        } finally {
            throw new MyException("finally exception");
        }
    }
}

class MyException extends Exception{
    public MyException(String msg){
        System.out.println(msg);
    }
}
