package com.ghprint.cms.services.impl;

import com.ghprint.cms.model.production.ProductionInfoView;
import com.ghprint.cms.model.production.TProductInfo;
import com.ghprint.cms.pagination.DataGridResult;
import com.ghprint.cms.serviceDao.TProductInfoMapper;
import com.ghprint.cms.services.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/12.
 */
@Service
public class ProductionServiceImpl implements ProductionService {

    @Autowired
    private TProductInfoMapper  productInfoMapper;

    @Override
    public Integer addProduction(TProductInfo productInfo) {
        Integer record = productInfoMapper.insertSelective(productInfo);
        return  record;
    }
}
