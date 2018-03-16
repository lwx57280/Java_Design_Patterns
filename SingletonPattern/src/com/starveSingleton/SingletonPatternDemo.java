package com.starveSingleton;

import com.starveSingleton.lazySingleton.Person;

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

        Person person1 = Person.getPerson();

        Person person2 = Person.getPerson();

        person1.setAge(20);
        person1.setName("李四");

        person2.setAge(25);
        person2.setName("lisa");
        System.out.println("person1=:"+person1.getName()+":"+person1.getAge());
        System.out.println("person2=:"+person2.getName()+":"+person2.getAge());
    }
}
