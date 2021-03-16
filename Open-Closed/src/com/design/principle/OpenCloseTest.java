package com.design.principle;

public class OpenCloseTest {


    public static void main(String[] args) {
        ICourse iCourse = new JavaDiscountCourse(1, "Java架构师", 11800D);
        JavaDiscountCourse javaDiscountCourse = (JavaDiscountCourse) iCourse;
        System.out.println("课程Id:" + javaDiscountCourse.getId() +
                "\n课程标题:" + "《" + javaDiscountCourse.getName() + "》" +
                "\n售价:" + javaDiscountCourse.getDiscountPrice() +
                "\n原价：" + iCourse.getPrice());
    }
}
