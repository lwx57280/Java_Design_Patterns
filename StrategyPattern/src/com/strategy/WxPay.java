package com.strategy;

/**
 * 微信支付类
 */
public class WxPay implements CommonPay {
    @Override
    public void pay(Integer money) {
        System.out.println("使用微信支付：" + money + "元。");
    }
}
