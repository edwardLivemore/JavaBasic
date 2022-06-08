package com.example.java_basic.DesignMode.BuilderPattern;

import java.math.BigDecimal;

public class VegBurger extends Burger {
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal("25.5");
    }
}
