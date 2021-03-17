package com.pay;

public class PayFactory {

    public PayType payType(PayTypeEnum payType){
        switch (payType) {
            case ALIBAB_APAY:
                return new AlibabaPay();
            case WX_PAY:
                return new WXPay();
            case UNION_PAY:
                return new UnionPay();
            case APPLE_PAY:
                return new ApplePay();
            case WEBMONEY_PAY:
                return new WebMoneyPay();
            default:
                throw new RuntimeException("未知支付方式。");
        }
    }
}
