package main.java.com.starveSingleton;

/**
 * 饿汉式单例,线程安全
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
