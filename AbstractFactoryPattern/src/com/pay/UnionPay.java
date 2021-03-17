package com.pay;

public class UnionPay implements PayType {
    @Override
    public void pay() {
        System.out.println("银联支付");
    }
}
