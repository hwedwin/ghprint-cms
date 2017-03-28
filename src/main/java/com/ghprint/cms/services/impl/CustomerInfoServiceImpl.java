package com.ghprint.cms.services.impl;

import com.ghprint.cms.model.production.TCustomerInfo;
import com.ghprint.cms.serviceDao.TCustomerInfoMapper;
import com.ghprint.cms.services.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Integer updateCustomerInfo(TCustomerInfo customerInfo) {
       Integer record = customerInfoMapper.updateByPrimaryKeySelective(customerInfo);
        return  record;
    }

    @Override
    public TCustomerInfo getCustomerInfobyId(Integer cid) {
      TCustomerInfo customerInfo =  customerInfoMapper.selectByPrimaryKey(cid);
        return customerInfo!=null?customerInfo:null;
    }

    @Override
    public Integer delCustomerInfobyId(Integer cid) {
        Integer record = customerInfoMapper.deleteByPrimaryKey(cid);
        return  record;
    }

    @Override
    public List<TCustomerInfo> selectCustomers() {
        List<TCustomerInfo> list = customerInfoMapper.selectCustomers();
        return list;
    }
}
