package com.example.java_basic.DesignMode.StrategyPattern;

public class OperationSubstract implements Strategy {
    @Override
    public int operate(int num1, int num2) {
        return num1 - num2;
    }
}
