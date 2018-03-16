# Java_Design_Patterns
代理模式
---------

        在代理模式（Proxy Pattern）中，一个类代表另一个类的功能。这种类型的设计模式属于结构型模式。
        
        在代理模式中，我们创建具有现有对象的对象，以便向外界提供功能接口。
        
        为其他对象提供一种代理以控制对这个对象的访问。
       
       应用实例：买火车票不一定在火车站买，也可以去代售点。再如我们有的时候打官司，我们需要请律师，因为律师在法律方面有专长，可以替我们进行操作，表达我们的想法。
       优点： 1、职责清晰。 2、高扩展性。 3、智能化。
       
       代理模式的应用场景：按职责来划分，通常有以下使用场景： 1、远程代理。 2、虚拟代理。 3、Copy-on-Write 代理。 4、保护（Protect or Access）代理。 5、Cache代理。 6、防火墙（Firewall）代理。 7、同步化（Synchronization）代理。 8、智能引用（Smart Reference）代理。
       
       如果已有的方法在使用的时候需要对原有的方法进行改进，此时有两种办法：
       
       1、修改原有的方法来适应。这样违反了“对扩展开放，对修改关闭”的原则。
       
       2、就是采用一个代理类调用原有的方法，且对产生的结果进行控制。这种方法就是代理模式。
       
       使用代理模式，可以将功能划分的更加清晰，有助于后期维护！
       
       
  ![代理模式](https://github.com/lwx57280/Java_Design_Patterns/blob/master/ProxyPattern/img-folder/proxy_pattern_uml_diagram.jpg)  
 ProxyPatternDemo
 ----------------
        /**
         * 创建一个接口。
         */
        public interface Image {
        
            void display();
        }  
        
        /**
         * 创建实现接口的实体类。
         */
        public class RealImage implements Image {
        
            private String fileName;
        
            public RealImage(String fileName) {
                this.fileName = fileName;
                this.loadFromDisk(fileName);
            }
        
            @Override
            public void display() {
                System.out.println("Displaying " + fileName);
            }
        
            private void loadFromDisk(String fileName){
                System.out.println("Loading " + fileName);
            }
        }

        public class ProxyImage implements Image {
        
            private RealImage realImage;
        
            private String fileName;
        
            public ProxyImage(String fileName) {
                this.fileName = fileName;
            }
        
            @Override
            public void display() {
                if(realImage==null){
                    realImage = new RealImage(fileName);
                }
                realImage.display();
            }
        }
        
        /**
         * 当被请求时，使用 ProxyImage 来获取 RealImage 类的对象。
         */
        public class ProxyPatternDemo {
            public static void main(String[] args){
                Image image = new ProxyImage("test_10mb.jpg");
        
                //图像将从磁盘加载
                image.display();
                System.out.println("");
                //图像将无法从磁盘加载
                image.display();
            }
        }
    
    

       
       
