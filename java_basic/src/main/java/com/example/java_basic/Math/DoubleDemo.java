package com.example.java_basic.Math;

public class DoubleDemo {
    public static void main(String[] args) {
        int total = 3;
        int a = 1;
        double rateA = Double.parseDouble(String.valueOf(a)) / total;
        rateA = (double) (Math.round(rateA * 100)) / 100;
        double rateB = (double) (Math.round( (1 - rateA) * 100 )) / 100;
        System.out.println(rateA);
        System.out.println(rateB);
    }
    
}