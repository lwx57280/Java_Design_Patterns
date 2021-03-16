package com.design.liskovsutiton.methodparam;

import java.util.HashMap;
import java.util.Map;

public class Child extends Base {
//    @Override
//    public void method(HashMap map) {
//        System.out.println("子类HashMap入参方法");
//    }

    public void method(HashMap hashMap) {
        System.out.println("子类Map入参方法执行");
    }
}
