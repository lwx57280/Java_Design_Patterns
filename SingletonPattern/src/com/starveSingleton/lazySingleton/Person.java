package com.starveSingleton.lazySingleton;
/**
 * 单例模式（懒汉式，线程不安全，双重检查）正真取时才实例化
 * @author Administrator
 *
 */
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
	 
	
}
