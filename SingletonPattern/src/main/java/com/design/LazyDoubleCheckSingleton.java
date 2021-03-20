package main.java.com.design;

import main.java.com.design.Person;

public class LazyDoubleCheckSingleton {

    private volatile static LazyDoubleCheckSingleton instance = null;

    private LazyDoubleCheckSingleton() {
    }

    public static LazyDoubleCheckSingleton getInstance() {
        // 检查是否要阻塞
        if (null == instance) {
            synchronized (LazyDoubleCheckSingleton.class) {
                // 检查是否需要重新创建实例
                if (null == instance) {
                    instance = new LazyDoubleCheckSingleton();
                    // 指令重排序的问题
                }
            }
        }
        return instance;
    }
}
