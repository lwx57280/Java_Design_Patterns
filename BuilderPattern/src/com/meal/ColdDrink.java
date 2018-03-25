package com.meal;

/**
 * 一杯冷饮
 */
public abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }

    public abstract float price();
}
