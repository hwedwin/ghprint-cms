package com.ghprint.cms.services.impl;

import com.ghprint.cms.model.production.TCustomerInfo;
import com.ghprint.cms.serviceDao.TCustomerInfoMapper;
import com.ghprint.cms.services.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/12.
 */
@Service
public class CustomerInfoServiceImpl implements CustomerInfoService {
    @Autowired
    private TCustomerInfoMapper customerInfoMapper;

    @Override
    public Integer addCustomerInfo(TCustomerInfo customerInfo) {
       Integer record  = customerInfoMapper.insertSelective(customerInfo);
        return record;
    }
}
