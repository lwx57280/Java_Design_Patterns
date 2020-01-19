package com.factory;

import com.Circle;
import com.Rectangle;
import com.Shape;
import com.Square;

import java.lang.reflect.InvocationTargetException;

/**
 * 创建一个工厂，生成基于给定信息的实体类的对象。
 */
public class ShapeFactory {


    //使用 getShape 方法获取形状类型的对象
    public Shape getShape(String shapeType){
        if(null==shapeType){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }else if (shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }

    /**
     * 使用反射机制可以解决每次增加一个产品时，都需要增加一个对象实现工厂的缺点
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getClass(Class<? extends T> clazz){
        T obj =null;
        try{
            obj = clazz.getDeclaredConstructor().newInstance();
//            obj = (T) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
