package com.example.java_basic.AbstractClass;

public abstract class ParentClass extends GrandClass {
    public ParentClass(String name) {
        super(name);
        System.out.println("parent");
        System.out.println(getName());
    }
}
