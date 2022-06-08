package com.example.java_basic.DesignMode.BuilderPattern;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Meal {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public BigDecimal getCost(){
        BigDecimal cost = BigDecimal.valueOf(0);
        for(Item item : items){
            cost = cost.add(item.price());
        }
        return cost;
    }

    public void showItems(){
        for (Item item : items){
            System.out.println("name : " + item.name());
            System.out.println("price : " + item.price());
        }
    }
}
