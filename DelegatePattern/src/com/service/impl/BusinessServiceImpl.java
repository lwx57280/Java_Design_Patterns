package com.service.impl;

import com.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {

    @Override
    public void doProcessing() {
        System.out.println("Processing task by invoking EJB Service");
    }
}
