package com.strategy;

/**
 *测试类
 */
public class StrategyDemo {
    public static void main(String[] args) {

        Customer customer= new Customer();
        customer.pay(PayType.WX_PAY, 100);
    }
}
