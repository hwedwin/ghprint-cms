package com.ghprint.cms.services;

import com.ghprint.cms.model.production.TCustomerInfo;

import java.util.List;

/**
 * 客户公司业务
 * Created by Administrator on 2017/3/12.
 */
public interface CustomerInfoService {

    public  Integer addCustomerInfo(TCustomerInfo customerInfo);
    public  Integer updateCustomerInfo(TCustomerInfo customerInfo);
    public  TCustomerInfo getCustomerInfobyId(Integer cid);
    public  Integer delCustomerInfobyId(Integer cid);
    public List<TCustomerInfo> selectCustomers();
}
