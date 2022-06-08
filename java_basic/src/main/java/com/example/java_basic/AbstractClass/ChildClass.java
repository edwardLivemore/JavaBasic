package com.example.java_basic.AbstractClass;

public class ChildClass extends ParentClass {
    public ChildClass(String name) {
        super(name);
        System.out.println(getName());
    }
}
