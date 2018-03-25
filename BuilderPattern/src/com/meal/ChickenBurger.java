package com.meal;

public class ChickenBurger extends Burger {
    @Override
    public String name() {
        // 鸡肉汉堡
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 50.5f;
    }
}
