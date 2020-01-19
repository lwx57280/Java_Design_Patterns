package com;

import com.factory.ShapeFactory;
import com.factory.ShapeTypeEnum;

/**
 * 使用该工厂，通过传递类型信息来获取实体类的对象。
 */
public class FactoryPatternDemo {
    public static void main(String[] args){
        ShapeFactory shapeFactory = new ShapeFactory();

        //获取 Circle 的对象，并调用它的 draw 方法
        Shape circle = shapeFactory.getShape(String.valueOf(ShapeTypeEnum.CIRCLE));
        //调用 Circle 的 draw 方法
        circle.draw();

        Shape rectangle = shapeFactory.getShape(String.valueOf(ShapeTypeEnum.RECTANGLE));
        //调用 Rectangle 的 draw 方法
        rectangle.draw();

        Shape square = shapeFactory.getShape(String.valueOf(ShapeTypeEnum.SQUARE));
        //获取 Square 的对象，并调用它的 draw 方法
        square.draw();

        System.out.println("===============================");
        Rectangle rect = shapeFactory.getClass(Rectangle.class);
        rect.draw();
    }
}
