package com.design.simplefactory;

public class CourseFactory {

    public ICourse create(Class<? extends ICourse> clazz) {
        /*if ("java".equals(courseName)) {
            return new JavaCourse();
        } else if ("python".equals(courseName)) {
            return new PythonCourse();
        } else {
            return null;
        }*/
        /*============ V2 使用java反射技术============*/
      /*  try {
            if (null != className || !"".equals(className)) {
                return (ICourse) Class.forName(className).newInstance();
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;*/

        try {
            if (null != clazz) {
                return (ICourse) clazz.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
