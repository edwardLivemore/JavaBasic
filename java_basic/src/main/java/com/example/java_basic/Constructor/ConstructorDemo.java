package com.example.java_basic.Constructor;

public class ConstructorDemo {
    public static void main(String[] args) {
        // new A();
        // new B();
        new B(1);
    }

}

class A {
    public A() {
        System.out.println("1");
    }
    public A(int i){
        System.out.println("2");
    }
    static {
        System.out.println("3");
    }
    {
        System.out.println("4");
    }
}

class B extends A {
    public B() {
        // super();
        System.out.println("5");
    }
    public B(int i) {
        // super(1);
        System.out.println("6");
    }
    static {
        System.out.println("7");
    }
    {
        System.out.println("8");
    }
}