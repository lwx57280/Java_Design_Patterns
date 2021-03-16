package com.design.dependence;

public class Lisa extends DipTest {

//    public void studyJavaCourse(){
//        System.out.println("Lisa正在学习Java课程");
//    }
//
//    public void studyPythonCourse() {
//        System.out.println("Lisa正在学习Python");
//    }
//
//    public void studyAICourse() {
//        System.out.println("Lisa正在学习AI");
//    }

    private ICourse course;

//    public Lisa(ICourse course) {
//        this.course = course;
//    }


    public void setCourse(ICourse course) {
        this.course = course;
    }

    public void study() {
        course.study();
    }
}
