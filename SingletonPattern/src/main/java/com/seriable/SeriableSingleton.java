package com.seriable;

import java.io.Serializable;
/**
 * 序列化
 * @Author:         cong zhi
 * @CreateDate:     2021/3/20 13:48
 * @UpdateUser:     cong zhi
 * @UpdateDate:     2021/3/20 13:48
 * @UpdateRemark:   修改内容
 * @Version:        1.0
 */
public class SeriableSingleton implements Serializable {

    /** 序列化
     * 将内存中的对象状态转换为字节码的形式，
     * 将字节码通过IO输出流，写到磁盘上
     */

    /**
     * 反序列化
     * 将持久化的字节码内容，通过IO输入流读到内存中
     * 转化成一个java对象
     */
    public final static SeriableSingleton INSTANCE = new SeriableSingleton();

    private SeriableSingleton(){}

    public static SeriableSingleton getInstance(){
        return INSTANCE;
    }

    /**
     * 通过 readResolve 方法防止单例对象被序列化、反序列化破坏
     * @return
     */
    public Object readResolve(){
        return INSTANCE;
    }

}
