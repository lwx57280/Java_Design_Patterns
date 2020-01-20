package com.service;

import com.constant.BusinessTypeEnum;
import com.service.impl.BusinessJMSServiceImpl;
import com.service.impl.BusinessServiceImpl;

public class BusinessLookUp {

    public BusinessService getBusinessService(String serviceType) {
        if (serviceType.equalsIgnoreCase(String.valueOf(BusinessTypeEnum.EJB))) {
            return new BusinessServiceImpl();
        }else {
            return new BusinessJMSServiceImpl();
        }
    }
}
