package com.example.java_basic.DesignMode.StrategyPattern;

public class Context {
    private final Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int excuteStrategy(int num1, int num2){
        return strategy.operate(num1, num2);
    }
}
