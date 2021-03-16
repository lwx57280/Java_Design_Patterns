package com.design.liskovsutiton.methodreturn;

public class MethodReturnTest {

    public static void main(String[] args) {
        Base child = new Child();
        System.out.println(child.method());
    }
}
