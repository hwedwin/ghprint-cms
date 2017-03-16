package com.ghprint.cms.services;

import com.ghprint.cms.model.production.TProductionStandard;

/**
 * 生产标准单表操作业务
 * Created by Administrator on 2017/3/12.
 */
public interface ProductionStandardService {

    public  Integer addProductionStandardService(TProductionStandard productionStandard);

    public  Integer delProductionStandardService(Integer pid);

    public  Integer updateProductionStandardService(TProductionStandard productionStandard);

    public  TProductionStandard getProductionStandardService(Integer pid);

}
