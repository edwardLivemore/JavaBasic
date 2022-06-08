package com.example.java_basic.DesignMode.FactoryPattern;

// 工厂模式
public class FactoryPattern {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape square = shapeFactory.getShape("square");

        square.draw();

        Shape rectangle = shapeFactory.getShape("rectangle");

        rectangle.draw();
    }
}
