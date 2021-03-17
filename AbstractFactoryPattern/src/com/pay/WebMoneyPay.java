package com.pay;

public class WebMoneyPay implements PayType {
    @Override
    public void pay() {
        System.out.println("日本支付");
    }
}
