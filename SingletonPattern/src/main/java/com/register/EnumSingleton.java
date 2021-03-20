package com.register;

/**
 * 枚举单利
 *  枚举底层 将 常量放进 Map中存储
 *  优点:线程安全、防止反射破坏单利
 *  缺点: 不支持大批量的创建对象，在某些情况下会造成内存浪费
 */
public enum EnumSingleton {

    INSTANCE;


    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
