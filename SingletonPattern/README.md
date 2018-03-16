# Java_Design_Patterns
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
