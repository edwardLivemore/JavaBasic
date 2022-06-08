package com.example.java_basic.DesignMode.BuilderPattern;

import java.math.BigDecimal;

public class PepsiCola extends Drink {
    @Override
    public String name() {
        return "Pepsi Cola";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal("9.5");
    }
}
