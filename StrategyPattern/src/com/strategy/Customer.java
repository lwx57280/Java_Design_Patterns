package com.strategy;

/**
 * 消费者类
 */
public class Customer {

    public void pay(PayType payType, Integer money) {
        payType.getCommonPay().pay(money);
    }
}
