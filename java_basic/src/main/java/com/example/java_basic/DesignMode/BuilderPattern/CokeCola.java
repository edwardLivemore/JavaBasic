package com.example.java_basic.DesignMode.BuilderPattern;

import java.math.BigDecimal;

public class CokeCola extends Drink {
    @Override
    public String name() {
        return "Coke Cola";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal("10.5");
    }
}
