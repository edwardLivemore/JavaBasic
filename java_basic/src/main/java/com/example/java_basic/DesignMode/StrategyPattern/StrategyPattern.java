package com.example.java_basic.DesignMode.StrategyPattern;

// 策略模式
public class StrategyPattern {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.excuteStrategy(10, 5));

        context = new Context(new OperationSubstract());
        System.out.println("10 - 5 = " + context.excuteStrategy(10, 5));

//        Strategy strategy = new OperationAdd();
//        System.out.println("10 + 5 = " + strategy.operate(10, 5));
//
//        strategy = new OperationSubstract();
//        System.out.println("10 + 5 = " + strategy.operate(10, 5));
    }
}
