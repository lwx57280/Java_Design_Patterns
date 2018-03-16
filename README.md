# Java_Design_Patterns
23种Java设计模式分为三大类

创建型模式共五种:工厂方法模式、抽象工厂模式、单例模式、建造者模式、原型模式。

结构型模式共七种:适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式。

行为型模式共十一种:策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、
中介者模式、解释器模式。

设计模式的六大原则
-----------------
        1、开闭原则（Open Close Principle）
        
        开闭原则的意思是：对扩展开放，对修改关闭。在程序需要进行拓展的时候，不能去修改原有的代码，实现一个热插拔的效果。简言之，是为了使程序的扩展性好，易于维护和升级。想要达到这样的效果，我们需要使用接口和抽象类，后面的具体设计中我们会提到这点。
        
        2、里氏代换原则（Liskov Substitution Principle）
        
        里氏代换原则是面向对象设计的基本原则之一。 里氏代换原则中说，任何基类可以出现的地方，子类一定可以出现。LSP 是继承复用的基石，只有当派生类可以替换掉基类，且软件单位的功能不受到影响时，基类才能真正被复用，而派生类也能够在基类的基础上增加新的行为。里氏代换原则是对开闭原则的补充。实现开闭原则的关键步骤就是抽象化，而基类与子类的继承关系就是抽象化的具体实现，所以里氏代换原则是对实现抽象化的具体步骤的规范。
        
        3、依赖倒转原则（Dependence Inversion Principle）
        
        这个原则是开闭原则的基础，具体内容：针对接口编程，依赖于抽象而不依赖于具体。
        
        4、接口隔离原则（Interface Segregation Principle）
        
        这个原则的意思是：使用多个隔离的接口，比使用单个接口要好。它还有另外一个意思是：降低类之间的耦合度。由此可见，其实设计模式就是从大型软件架构出发、便于升级和维护的软件设计思想，它强调降低依赖，降低耦合。
        
        5、迪米特法则，又称最少知道原则（Demeter Principle）
        
        最少知道原则是指：一个实体应当尽量少地与其他实体之间发生相互作用，使得系统功能模块相对独立。
        
        6、合成复用原则（Composite Reuse Principle）
        
        合成复用原则是指：尽量使用合成/聚合的方式，而不是使用继承。
        
        
工厂模式
--------
    我们将创建一个 Shape 接口和实现 Shape 接口的实体类。下一步是定义工厂类 ShapeFactory。

    FactoryPatternDemo，我们的演示类使用 ShapeFactory 来获取 Shape 对象。它将向 ShapeFactory 传递信息（CIRCLE / RECTANGLE / SQUARE），以便获取它所需对象的类型。
    

单例设计模式
------------
    什么是单利模式？
    	单利模式是一种对象创建型模式，使用单利模式可以确保一个类只生成唯一实例。也就是说在整个程序空间中，该类只存在一个实例对象。
    	1、私有的构造。
    	2、私有的静态属性类型自己。
    	3、公有的静态方法返回值类型是类自身的实例。
    单利模式的好处节省内存资源，它限制了实例的个数，有利于java垃圾回收。
    
    注意：
    
    1、单例类只能有一个实例。
    2、单例类必须自己创建自己的唯一实例。
    3、单例类必须给所有其他对象提供这一实例。
    
    
    饿汉式
    懒汉式
    双重检查
   （懒汉式，多线程时不安全）
   
  ![单例模式](https://github.com/lwx57280/Java_Design_Patterns/blob/master/SingletonPattern/img-folder/singleton_pattern_uml_diagram.jpg)
      
   

饿汉式(线程安全)
------
        /**
         * 创建一个 Singleton 类。
         */
        public class SingleObject {
            //创建 SingleObject 的一个对象
            private static final SingleObject instance = new SingleObject();
        
            //让构造函数为 private，这样该类就不会被实例化
            private SingleObject() {
            }
        
            public static SingleObject getInstance(){
                return instance;
            }
        
            public void showMessage(){
                System.out.println("Hello World!");
            }
        }
        
        
        /**
         * 从 singleton 类获取唯一的对象。
         */
        public class SingletonPatternDemo {
            public static void main(String[] args){
                //不合法的构造函数
                //编译时错误：构造函数 SingleObject() 是不可见的
                //SingleObject object = new SingleObject();
        
                //获取唯一可用的对象
                SingleObject singleObject = SingleObject.getInstance();
                singleObject.showMessage();
            }
        }
        
 单例模式（懒汉式，线程不安全，双重检查）正真取时才实例化
 ------------------
     描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
     getInstance() 的性能对应用程序很关键。
     
     
         public class Person {
            private int age;
            private String name;
            //1、私有的静态属性类型自己
            private static Person person=null;
            //2、私有的构造
            private Person() {
            }
            
            //3、公有的静态方法 ,返回值是类自身
            public static Person getPerson(){
                // 此处判断针对所有，多加一次判断提高效率
                if(person == null){
                    // 加同步块提高多线程安全
                    synchronized(Person.class){
                        //此处判断第一次使用
                        if(person == null)
                            person =new Person();
                    }
                }
                return person;
            }
         
            public int getAge() {
                return age;
            }
         
            public void setAge(int age) {
                this.age = age;
            }
         
            public String getName() {
                return name;
            }
         
            public void setName(String name) {
                this.name = name;
            }

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
    
