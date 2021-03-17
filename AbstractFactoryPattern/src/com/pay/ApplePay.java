package com.pay;

public class ApplePay implements PayType{
    @Override
    public void pay() {
        System.out.println("apple支付");
    }
}
