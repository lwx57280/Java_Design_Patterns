package com.register;

/**
 * 注册式单利
 * 将每一个实例都缓存到统一的容器中，使用唯一标识获取实例
 *
 * @Author:         cong zhi
 * @CreateDate:     2021/3/20 13:29
 * @UpdateUser:     cong zhi
 * @UpdateDate:     2021/3/20 13:29
 * @UpdateRemark:   修改内容
 * @Version:        1.0
 */
public class ContainerSingletonTest {

    public static void main(String[] args) {
        Object instance1 = ContainerSingleton.getInstance("com.register.Pojo");
        Object instance2 = ContainerSingleton.getInstance("com.register.Pojo");

        try {
            System.out.println(instance2);
            System.out.println(instance1);
            System.out.println(instance1==instance2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
