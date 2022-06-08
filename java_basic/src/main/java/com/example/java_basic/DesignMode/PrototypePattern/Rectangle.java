package com.example.java_basic.DesignMode.PrototypePattern;

public class Rectangle extends Shape {
    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Rectangle.draw() method.");
    }
}
