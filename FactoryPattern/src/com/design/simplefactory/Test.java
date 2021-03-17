package com.design.simplefactory;

/**
 * 简单工厂
 * @Author:         cong zhi
 * @CreateDate:     2021/3/17 15:29
 * @UpdateUser:     cong zhi
 * @UpdateDate:     2021/3/17 15:29
 * @UpdateRemark:   修改内容
 * @Version:        1.0
 */
public class Test {

    public static void main(String[] args) {
        ICourse iCourse = new CourseFactory().create(JavaCourse.class);
        iCourse.record();

    }
}
