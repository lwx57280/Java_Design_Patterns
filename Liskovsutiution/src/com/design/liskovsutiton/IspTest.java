package com.design.liskovsutiton;

import com.design.liskovsutiton.quadrangle.QuadRangle;
import com.design.liskovsutiton.simple.Rectangle;

public class IspTest {

    public static void resize(QuadRangle quadRangle) {
        while (quadRangle.getWidth() >= quadRangle.getHeight()) {
//            quadRangle.setHeight(quadRangle.getHeight() + 1);
            System.out.println("width:" + quadRangle.getWidth() + ",Height:" + quadRangle.getHeight());
        }
        System.out.println("Resize End,Width:" + quadRangle.getWidth() + ",Height:" + quadRangle.getHeight());
    }


    public static void main(String[] args) {
        Rectangle quadRangle = new Rectangle();
        quadRangle.setWidth(20);
        quadRangle.setHeight(10);
        //resize(quadRangle);
    }

  /*  public static void main(String[] args) {
        com.design.liskovsutiton.simple.Square square= new Square();
        square.setLength(10);
        resize(square);
    }*/
}
