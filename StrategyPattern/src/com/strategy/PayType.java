package com.strategy;

/**
 * 支付类型枚举
 */
public enum PayType {
    /**
     * 支付宝付款
     */
    ALI_PAY(new AliPay()),
    /**
     * 微信付款
     */
    WX_PAY(new WxPay()),
    /**
     * 银联付款
     */
    UNION_PAY(new UnionPay());

    /**
     * 每一个枚举实例都会拥有自己的commonPay
     */
    private CommonPay commonPay;

    PayType(CommonPay commonPay) {
        this.commonPay = commonPay;
    }

    public CommonPay getCommonPay() {
        return commonPay;
    }
}
