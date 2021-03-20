package main.java.com.design;

/**
 * 懒汉式单利
 * 优点：节省内存资源、减少GC
 * 缺点：缺点线程不安全
 *
 * @Author: cong zhi
 * @CreateDate: 2021/3/18 8:16
 * @UpdateUser: cong zhi
 * @UpdateDate: 2021/3/18 8:16
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Person {

    private static Person person = null;

    private Person() {
    }

    public synchronized static Person getInstance() {
        if (null == person) {
            person = new Person();
        }
        return person;
    }
}
