package com.factory;

import prototype.Shape;
import com.*;
import prototype.Rectangle;

/**
 * 创建扩展了 AbstractFactory 的工厂类，基于给定的信息生成实体类的对象。
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase(String.valueOf(ShapeType.CIRCLE))) {
            return new prototype.Circle();
        }else if (shapeType.equalsIgnoreCase(String.valueOf(ShapeType.RECTANGLE))) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase(String.valueOf(ShapeType.SQUARE))) {
            return new prototype.Square();
        }
        return null;
    }
}
