package com.example.java_basic.DesignMode.AbstractFactoryPattern;

public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
