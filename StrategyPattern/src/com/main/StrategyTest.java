package com.main;

/**
 * 测试类
 */
public class StrategyTest {

    public static void main(String[] args) {

        PayType payType = PayType.WX_PAY;

        switch (payType) {
            case AIL_PAY:
                System.out.println("使用支付宝付款。。");
                break;
            case WX_PAY:
                System.out.println("使用微信付款。。");
                break;
            case UNION_PAY:
                System.out.println("使用银联付款。。");
                break;
            default:
                throw new RuntimeException("未知支付方式。");
        }
    }
}
