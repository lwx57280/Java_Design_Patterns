package com;

/**
 * 容器数据类型
 */
public class PCData{

    private final int intData;


    public PCData(int i) {
        intData=i;
    }

    public PCData(String d){
        intData = Integer.valueOf(d);
    }

    public int getIntData() {
        return intData;
    }

    @Override
    public String toString() {
        return "PCData{" +
                "intData=" + intData +
                '}';
    }
}

