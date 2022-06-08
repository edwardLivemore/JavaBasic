package com.example.java_basic.DesignMode.AbstractFactoryPattern;

public class FactoryProducer {
    public static AbstractFactory getFactory(String factory){
        switch (factory.toLowerCase()){
            case "shape":
                return new ShapeFactory();
            case "color":
                return new ColorFactory();
            default:
                return null;
        }
    }
}
