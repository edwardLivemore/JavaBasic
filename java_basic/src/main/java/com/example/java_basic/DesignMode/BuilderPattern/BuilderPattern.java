package com.example.java_basic.DesignMode.BuilderPattern;

public class BuilderPattern {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.getVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost : " + vegMeal.getCost());

        Meal chickenMeal = mealBuilder.getChickenMeal();
        System.out.println("Chicken Meal");
        chickenMeal.showItems();
        System.out.println("Total Cost : " + chickenMeal.getCost());
    }
}
