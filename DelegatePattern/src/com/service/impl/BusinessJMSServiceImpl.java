package com.service.impl;

import com.service.BusinessService;

public class BusinessJMSServiceImpl implements BusinessService {
    @Override
    public void doProcessing() {
        System.out.println("Processing task by invoking JMS Service");
    }
}
