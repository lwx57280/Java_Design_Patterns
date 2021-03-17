package com.pay;

public class WXPay implements PayType {
    @Override
    public void pay() {
        System.out.println("微信支付");
    }
}
