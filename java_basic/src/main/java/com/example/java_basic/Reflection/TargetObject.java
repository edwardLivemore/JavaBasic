package com.example.java_basic.Reflection;

public class TargetObject {
    private String value;

    public TargetObject(){
        value = "target";
    }

    public void publicMethod(String s){
        System.out.println("public method : " + s);
    }

    private void privateMethod(String s){
        System.out.println("private method: " + s);
    }

    public void value(){
        System.out.println("value : " + value);
    }
}