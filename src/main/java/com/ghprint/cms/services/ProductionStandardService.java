package com.ghprint.cms.services;

import com.ghprint.cms.model.production.TProductionStandard;

/**
 * Created by Administrator on 2017/3/12.
 */
public interface ProductionStandardService {

    public  Integer addProductionStandardService(TProductionStandard productionStandard);

    public  Integer delProductionStandardService(Integer pid);

}
