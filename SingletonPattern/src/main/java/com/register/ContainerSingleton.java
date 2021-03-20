package com.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 模拟Spring容器单利模式
 *
 * @Author: cong zhi
 * @CreateDate: 2021/3/20 11:22
 * @UpdateUser: cong zhi
 * @UpdateDate: 2021/3/20 11:22
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ContainerSingleton {

    private ContainerSingleton() {

    }

    private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    public static Object getInstance(String className) {
        Object instance = null;
        // 先判断className 有没有，如果没有则说明第一次使用
        if (!ioc.containsKey(className)) {
            try {
                // 通过反射创建
                instance = Class.forName(className).newInstance();
                ioc.put(className, instance);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return instance;
        } else {
            return ioc.get(className);
        }
    }
}
