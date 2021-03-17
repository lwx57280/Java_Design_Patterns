package com.pay;

public class AlibabaPay implements PayType {
    @Override
    public void pay() {
        System.out.println("支付宝支付");
    }
}
