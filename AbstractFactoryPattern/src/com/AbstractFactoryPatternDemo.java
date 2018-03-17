package com;

import com.Shape;
import com.factory.AbstractFactory;
import com.factory.FactoryProducer;

/**
 * 使用 FactoryProducer 来获取 AbstractFactory，通过传递类型信息来获取实体类的对象。
 */
public class AbstractFactoryPatternDemo {
    public static void main(String[] args){
        //获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        //获取形状为 Circle 的对象
        Shape shape1 = shapeFactory.getShape("CIRCLE");     //抽象类中抽象方法，方法调用的类和抽象类不在同一个包的话就要加public来修饰
        //调用 Circle 的 draw 方法
        shape1.draw();

        //获取形状为 Rectangle 的对象
        Shape shape2 = shapeFactory.getShape(String.valueOf(ShapeType.RECTANGLE));
        //调用 Rectangle 的 draw 方法
        shape2.draw();

        //获取形状为 Square 的对象
        Shape shape3 = shapeFactory.getShape(String.valueOf(ShapeType.SQUARE));
        //调用 Square 的 draw 方法
        shape3.draw();

        //获取颜色工厂
        AbstractFactory colorFactor = FactoryProducer.getFactory("COLOR");
        //获取颜色为 Red 的对象
        Color red = colorFactor.getColor("RED");
        //调用 Red 的 fill 方法
        red.fill();
        //获取颜色为 Green 的对象
        Color green = colorFactor.getColor("Green");
        green.fill();
        //获取颜色为 BLUE 的对象
        Color blue = colorFactor.getColor("BLUE");
        blue.fill();
    }
}
