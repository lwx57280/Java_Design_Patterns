package com.meal;

/**
 * 创建一个表示食物条目和食物包装的接口。
 */
public interface Item {

    String name();

    Packing packing();

    float price();
}
