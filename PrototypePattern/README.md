# Java_Design_Patterns
原型模式
------------
        原型模式虽然是创建型的模式，但是与工程模式没有关系，从名字即可看出，该模式的思想就是将一个对象作为原型，对其进行复制、克隆，产生一个和原对象类似的新对象。本小结会通过对象的复制，进行讲解。在Java中，复制对象是通过clone()实现的，先创建一个原型类：
        
        原型模式(Prototype Pattern)：使用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。原型模式是一种对象创建型模式。
        使用场景： 
             1、资源优化场景。
             2、类初始化需要消化非常多的资源，这个资源包括数据、硬件资源等。 
             3、性能和安全要求的场景。
             4、通过 new 产生一个对象需要非常繁琐的数据准备或访问权限，则可以使用原型模式。 
             5、一个对象多个修改者的场景。 
             6、一个对象需要提供给其他对象访问，而且各个调用者可能都需要修改其值时，可以考虑使用原型模式拷贝多个对象供调用者使用。
             7、在实际项目中，原型模式很少单独出现，一般是和工厂方法模式一起出现，通过 clone 的方法创建一个对象，然后由工厂方法提供给调用者。原型模式已经与 Java 融为浑然一体，大家可以随手拿来使用。    
        
         注意事项：与通过对一个类进行实例化来构造新对象不同的是，原型模式是通过拷贝一个现有对象生成新对象的。浅拷贝实现 Cloneable，重写，深拷贝是通过实现 Serializable 读取二进制流。      
 




![原型模式](https://github.com/lwx57280/Java_Design_Patterns/blob/master/PrototypePattern/img-folder/prototype_pattern_uml_diagram.jpg) 
实现
    
    创建一个抽象类 Shape 和扩展了 Shape 类的实体类。下一步是定义类 ShapeCache，该类把 shape 对象存储在一个 Hashtable 中，并在请求的时候返回它们的克隆。

    PrototypPatternDemo，我们的演示类使用 ShapeCache 类来获取 Shape 对象
    
    步骤1
       /**
        * 创建一个实现了 Clonable 接口的抽象类。
        */
       public abstract class Shape implements Cloneable{
           private String id;
       
           protected String type;
       
           abstract void draw();
       
           public String getId() {
               return id;
           }
       
           public void setId(String id) {
               this.id = id;
           }
       
           public String getType() {
               return type;
           }
       
           public void setType(String type) {
               this.type = type;
           }
       
           public Object clone(){
               Object clone = null;
               try{
                   clone = super.clone();
               }catch (CloneNotSupportedException e){
                   e.printStackTrace();
               }
               return clone;
           }
       }

     步骤2
     
     /**
      * 创建扩展了上面抽象类的实体类。
      */
     public class Rectangle extends Shape {
     
         public Rectangle() {
             type ="Rectangle";
         }
     
         @Override
         void draw() {
             System.out.println("Inside Rectangle::draw() method.");
         }
     }
    
    public class Square extends Shape {
    
        public Square() {
            type = "Square";
        }
    
        @Override
        public void draw() {
            System.out.println("Inside Square::draw() method.");
        }
    }
    
    
    步骤 3
    
    /**
     * 创建一个类，从数据库获取实体类，并把它们存储在一个 Hashtable 中。
     */
    public class ShapeCache {
    
        private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();
    
        public static Shape getShape(String shapeId){
            Shape cachedShape = shapeMap.get(shapeId);
            return (Shape) cachedShape.clone();
        }
    
        // 对每种形状都运行数据库查询，并创建该形状
        // shapeMap.put(shapeKey, shape);
        // 例如，我们要添加三种形状
    
        public static void loadCache(){
            Circle circle = new Circle();
            circle.setId("1");
            shapeMap.put(circle.getId(),circle);
    
            Square square = new Square();
            square.setId("2");
            shapeMap.put(square.getId(),square);
    
            Rectangle rectangle = new Rectangle();
            rectangle.setId("3");
            shapeMap.put(rectangle.getId(),rectangle);
        }
    }
    
    步骤4
    
    //步骤 4
    //PrototypePatternDemo 使用 ShapeCache 类来获取存储在 Hashtable 中的形状的克隆。
    public class PrototypePatternDemo {
        public static void main(String[] args){
            ShapeCache.loadCache();
    
            Shape cloneShape = ShapeCache.getShape("1");
            System.out.println("Shape:"+cloneShape.getType());
    
            Shape cloneShape2 = ShapeCache.getShape("2");
            System.out.println("Shape:"+cloneShape2.getType());
    
            Shape cloneShape3 = ShapeCache.getShape("3");
            System.out.println("Shape:"+cloneShape3.getType());
        }
    }


一个原型类，只需要实现Cloneable接口，覆写clone方法，此处clone方法可以改成任意的名称，因为Cloneable接口是个空接口，你可以任意定义实现类的方法名，如cloneA或者cloneB，因为此处的重点是super.clone()这句话，super.clone()调用的是Object的clone()方法，而在Object类中，clone()是native的，具体怎么实现，我会在另一篇文章中，关于解读Java中本地方法的调用，此处不再深究。在这儿，我将结合对象的浅复制和深复制来说一下，首先需要了解对象深、浅复制的概念：

浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的。

深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。简单来说，就是深复制进行了完全彻底的复制，而浅复制不彻底。

            package proto;
            
            import java.io.*;
            
            /**
             * 深浅复制的例子：
             */
            public class Prototype implements Cloneable, Serializable {
            
                private static final long serialVersionUID = 6196587363529076566L;
            
                private String name;
            
                private SerializableObject obj;
            
                /* 浅复制 */
                public Object clone()throws CloneNotSupportedException{
                    Prototype prototype = (Prototype) super.clone();
                    return prototype;
                }
            
            
                /* 深复制 */
                public Object deepClone()throws IOException,ClassNotFoundException{
                    /* 写入当前对象的二进制流 */
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    ObjectOutputStream oos = new ObjectOutputStream(bos);
                    oos.writeObject(this);
            
                    /* 读出二进制流产生的新对象 */
                    ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
                    ObjectInputStream ois = new ObjectInputStream(bis);
                    return ois.readObject();
            
                }
            
                public String getName() {
                    return name;
                }
            
                public void setName(String name) {
                    this.name = name;
                }
            
                public SerializableObject getObj() {
                    return obj;
                }
            
                public void setObj(SerializableObject obj) {
                    this.obj = obj;
                }
            }
要实现深复制，需要采用流的形式读入当前对象的二进制输入，再写出二进制数据对应的对象。 