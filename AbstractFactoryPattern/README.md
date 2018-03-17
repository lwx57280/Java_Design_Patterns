# Java_Design_Patterns
抽象工厂模式
------------
    工厂方法模式有一个问题就是，类的创建依赖工厂类，也就是说，如果想要拓展程序，必须对工厂类进行修改，这违背了闭包原则，所以，从设计角度考虑，有一定的问题，如何解决？就用到抽象工厂模式，创建多个工厂类，这样一旦需要增加新的功能，直接增加新的工厂类就可以了，不需要修改之前的代码。因为抽象工厂不太好理解，我们先看看图，然后就和代码，就比较容易理解。
       
    提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
    
![抽象工厂]()
    
            步骤1
            /**
             * 为形状创建一个接口。
             */
            public interface Shape {
                void draw();
            }
            步骤2
            /**
             * 创建实现接口的实体类。
             */
            public class Rectangle implements Shape {
            
                @Override
                public void draw() {
                    System.out.println("Inside Rectangle::draw() method.");
                }
            }
            
            /**
             * 创建实现接口的实体类。
             */
            public class Square implements Shape {
                @Override
                public void draw() {
                    System.out.println("Inside Square::draw() method.");
                }
            }
            
            public class Circle implements Shape {
                @Override
                public void draw() {
                    System.out.println("Inside Circle::draw() method.");
                }
            }
            
            步骤3
            /**
             * 为颜色创建一个接口
             */
            public interface Color {
                void fill();
            }
            
            步骤4
            /**
             * 创建实现接口的实体类。
             */
            public class Red implements Color {
                @Override
                public void fill() {
                    System.out.println("Inside Red::fill() method.");
                }
            }
            
            public class Green implements Color {
                @Override
                public void fill() {
                    System.out.println("Inside Green::fill() method.");
                }
            }
        
            public class Blue implements Color {
                @Override
                public void fill() {
                    System.out.println("Inside Blue::fill() method.");
                }
            }
            
            步骤 5
            /**
             * 为 Color 和 Shape 对象创建抽象类来获取工厂。
             * 无需去改动现成的代码。这样做，拓展性较好！
             */
            public abstract class AbstractFactory {
            
                public abstract Color getColor(String color);
                //抽象类中抽象方法，方法调用的类和抽象类不在同一个包的话就要加public来修饰
                public abstract Shape getShape(String shape);
            }
            
            步骤 6
            
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
                        return new Circle();
                    }else if (shapeType.equalsIgnoreCase(String.valueOf(ShapeType.RECTANGLE))) {
                        return new Rectangle();
                    } else if (shapeType.equalsIgnoreCase(String.valueOf(ShapeType.SQUARE))) {
                        return new Square();
                    }
                    return null;
                }
            }
            
            public class ColorFactory extends AbstractFactory {
                @Override
                public Color getColor(String color) {
                    if(color==null){
                        return null;
                    }
                    if(color.equalsIgnoreCase("RED")){
                        return new Red();
                    }else if(color.equalsIgnoreCase("GREEN")){
                        return new Green();
                    }else if(color.equalsIgnoreCase("BLUE")){
                        return new Blue();
                    }
                    return null;
                }
            
                @Override
                public Shape getShape(String shape) {
                    return null;
                }
            }
            
            步骤 7
            /**
             * 创建一个工厂创造器/生成器类，通过传递形状或颜色信息来获取工厂。
             */
            public class FactoryProducer {
            
                public static AbstractFactory getFactory(String choice){
                    if(choice.equalsIgnoreCase("SHAPE")){
                        return new ShapeFactory();
                    }else if(choice.equalsIgnoreCase("COLOR")){
                        return new ColorFactory();
                    }
                    return null;
                }
            }
            
            步骤 8
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

    其实这个模式的好处就是，如果你现在想增加一个功能：发及时信息，则只需做一个实现类，实现Sender接口，同时做一个工厂类，实现Shape接口，就OK了，无需去改动现成的代码。这样做，拓展性较好！


