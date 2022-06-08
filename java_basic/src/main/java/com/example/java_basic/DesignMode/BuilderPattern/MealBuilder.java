package com.example.java_basic.DesignMode.BuilderPattern;

public class MealBuilder {

    public Meal getVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new CokeCola());
        return meal;
    }

    public Meal getChickenMeal(){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new PepsiCola());
        return meal;
    }
}
