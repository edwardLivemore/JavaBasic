package com.example.java_basic.TryCatchFinally;

public class TryCatchFinallyDemo {
    public static void main(String[] args) throws MyException {
//        demo1();

        int i = demo2();
        System.out.println(i);
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
