package com.design.liskovsutiton.methodparam;

import java.util.HashMap;

public class MethodParamTest {

    public static void main(String[] args) {
        Base child = new Child();
        HashMap hashMap = new HashMap();
        child.method(hashMap);
    }
}
