package com.example.java_basic.DesignMode.AbstractFactoryPattern;

public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }

        switch (color.toLowerCase()){
            case "red":
                return new Red();
            case "green":
                return new Green();
            default:
                return null;
        }
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
