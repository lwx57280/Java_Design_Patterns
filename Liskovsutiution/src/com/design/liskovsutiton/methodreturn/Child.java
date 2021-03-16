package com.design.liskovsutiton.methodreturn;

import java.util.HashMap;

public class Child extends Base {
    @Override
    public HashMap method() {
        HashMap hashMap= new HashMap();
        System.out.println("执行子类的method");
        hashMap.put("msg", "子类method");
        return hashMap;
    }
}
