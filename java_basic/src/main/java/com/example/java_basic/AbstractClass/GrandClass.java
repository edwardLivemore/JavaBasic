package com.example.java_basic.AbstractClass;

public abstract class GrandClass {
    private String name;

    public String getName(){
        return name;
    }

    public GrandClass(String name){
        this.name = name;
        System.out.println("grand");
        System.out.println(getName());
    }
}
