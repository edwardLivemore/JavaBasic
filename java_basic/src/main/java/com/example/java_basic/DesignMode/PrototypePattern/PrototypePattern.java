package com.example.java_basic.DesignMode.PrototypePattern;

public class PrototypePattern {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape square = ShapeCache.getShape("1");
        System.out.println("Shape : " + square.getType());

        Shape rectangle = ShapeCache.getShape("2");
        System.out.println("Shape : " + rectangle.getType());
    }
}
