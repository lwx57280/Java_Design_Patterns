package com.strategy;

/**
 * 支付宝支付类
 */
public class AliPay implements CommonPay {

    @Override
    public void pay(Integer money) {
        System.out.println("使用支付宝支付：" + money + "元。");
    }
}
