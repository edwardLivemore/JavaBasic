package com.example.java_basic.DesignMode.FactoryPattern;

import javafx.scene.shape.Circle;

public class ShapeFactory {
    public Shape getShape(String type){
        if(type == null){
            return null;
        }

        switch (type.toLowerCase()){
            case "square":
                return new Square();
            case "rectangle":
                return new Rectangle();
            default:
                return null;
        }
    }
}
