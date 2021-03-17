package com.pay;

public class PayTest {

    public static void main(String[] args) {
        PayType payType = new PayFactory().payType(PayTypeEnum.WX_PAY);
        payType.pay();
    }
}
