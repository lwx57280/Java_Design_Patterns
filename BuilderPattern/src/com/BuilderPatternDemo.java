package com;

import com.meal.Meal;
import com.meal.MealBuilder;

/**
 * BuiderPatternDemo 使用 MealBuider 来演示建造者模式（Builder Pattern）。
 */
public class BuilderPatternDemo {
    public static void main(String[] args){
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total cost:"+vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\\n\\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total cost:"+nonVegMeal.getCost());
    }
}
