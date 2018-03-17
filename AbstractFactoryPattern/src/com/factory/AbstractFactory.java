package com.factory;

import com.Color;
import com.Shape;

/**
 * 为 Color 和 Shape 对象创建抽象类来获取工厂。
 * 无需去改动现成的代码。这样做，拓展性较好！
 */
public abstract class AbstractFactory {

    public abstract Color getColor(String color);
    //抽象类中抽象方法，方法调用的类和抽象类不在同一个包的话就要加public来修饰
    public abstract Shape getShape(String shape);
}
