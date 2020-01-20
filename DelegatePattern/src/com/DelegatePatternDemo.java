package com;

import com.constant.BusinessTypeEnum;

public class DelegatePatternDemo {

    public static void main(String[] args) {
        BusinessDelegate businessDelegate = new BusinessDelegate();
        businessDelegate.setBusinessType(String.valueOf(BusinessTypeEnum.EJB));

        Client client = new Client(businessDelegate);
        client.doTask();

        businessDelegate.setBusinessType(String.valueOf(BusinessTypeEnum.JMS));
        client.doTask();
    }
}
