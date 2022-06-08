package com.example.java_basic.DesignMode.SingletonPattern;

public class SingletonDemo {
    public static void main(String[] args) {
        Singleton1.getInstance();
        Singleton2.getInstance();
        Singleton3.getInstance();
        Singleton4.getInstance();
        Singleton5.getInstance();
        Singleton6.INSTANCE.getInstance();
    }
}

// 懒汉式(线程安全: 否, 延迟加载: 是)
class Singleton1 {
    private static Singleton1 instance;

    private Singleton1(){}

    public static Singleton1 getInstance(){
        if(instance == null){
            instance = new Singleton1();
            System.out.println("懒汉式(线程安全: 否, 延迟加载: 是)");
        }
        return instance;
    }
}

// 懒汉式(线程安全: 是, 延迟加载: 是, 效率低)
class Singleton2 {
    private static Singleton2 instance;

    private Singleton2(){}

    public static synchronized Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
            System.out.println("懒汉式(线程安全: 是, 延迟加载: 是, 效率低)");
        }
        return instance;
    }
}

// 饿汉式(线程安全: 是, 延迟加载: 否)
class Singleton3 {
    private static Singleton3 instance = new Singleton3();

    private Singleton3(){}

    public static Singleton3 getInstance(){
        System.out.println("饿汉式(线程安全: 是, 延迟加载: 否)");
        return instance;
    }
}

// 双检锁(线程安全: 是, 延迟加载: 是)
class Singleton4 {
    private static volatile Singleton4 instance;

    private Singleton4(){}

    public static Singleton4 getInstance(){
        if(instance == null){
            synchronized (Singleton4.class){
                if(instance == null){
                    instance = new Singleton4();
                    System.out.println("双检锁(线程安全: 是, 延迟加载: 是)");
                }
            }
        }
        return instance;
    }
}

// 静态内部类(线程安全: 是, 延迟加载: 是)
class Singleton5 {
    private Singleton5(){}

    public static Singleton5 getInstance(){
        System.out.println("静态内部类(线程安全: 是, 延迟加载: 是)");
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        //        public SingletonHolder(){
//            System.out.println("SingletonHolder initializing...");
//        }
//
//        static {
//            System.out.println("SingletonHolder static initializing...");
//        }
        private static final Singleton5 INSTANCE = new Singleton5();
    }
}

// 枚举(线程安全: 是, 延迟加载: 否)
enum Singleton6 {
    INSTANCE;

    public void getInstance(){
        System.out.println("枚举(线程安全: 是, 延迟加载: 否)");
    }
}