package com;

import com.service.BusinessLookUp;
import com.service.BusinessService;

public class BusinessDelegate {

    private BusinessLookUp lookService = new BusinessLookUp();

    private BusinessService businessService;
    private String businessType;

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public void doTask() {
        businessService = lookService.getBusinessService(businessType);
        businessService.doProcessing();
    }
}
