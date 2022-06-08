package com.example.java_basic.DesignMode.AbstractFactoryPattern;

// 抽象工厂模式
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        // 形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");

        Shape square = shapeFactory.getShape("square");
        square.draw();

        Shape rectangle = shapeFactory.getShape("rectangle");
        rectangle.draw();

        // 颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("color");

        Color red = colorFactory.getColor("red");
        red.fill();

        Color green = colorFactory.getColor("green");
        green.fill();
    }
}
