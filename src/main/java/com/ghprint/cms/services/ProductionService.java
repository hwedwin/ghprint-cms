package com.ghprint.cms.services;

import com.ghprint.cms.model.production.TProductInfo;

/**
 * 产品信息表业务
 * Created by Administrator on 2017/3/12.
 */
public interface  ProductionService {

    public  Integer addProduction(TProductInfo productInfo);
    public  Integer delProduction(Integer pid);
    public  Integer updateProduction(TProductInfo productInfo);
    public  TProductInfo getProductionbyId(Integer pid);
}
