package com.design.dependence;

/**
 * 依赖倒置原则
 * @Author:         cong zhi
 * @CreateDate:     2021/3/14 22:45
 * @UpdateUser:     cong zhi
 * @UpdateDate:     2021/3/14 22:45
 * @UpdateRemark:   修改内容
 * @Version:        1.0
 */
public class DipTest {

    public static void main(String[] args) {

        /*=============== V1 ===============*/
//        Lisa lisa = new Lisa();
//        lisa.studyAICourse();
//        lisa.studyJavaCourse();
//        lisa.studyPythonCourse();

        /*=============== V2 ===============*/
        /*Lisa lisa = new Lisa();
        lisa.study(new JavaCourse());
        lisa.study(new PythonCourse());*/

        /*=============== V3 ===============*/

       /* Lisa lisa = new Lisa(new JavaCourse());
        lisa.study();
        Lisa lisaPython = new Lisa(new PythonCourse());
        lisaPython.study();*/

        /*=============== V4 ===============*/
        Lisa lisa = new Lisa();
        lisa.setCourse(new JavaCourse());
        lisa.study();
        lisa.setCourse(new PythonCourse());
        lisa.study();
    }
}
