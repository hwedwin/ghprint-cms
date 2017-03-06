package com.ghprint.cms.services;

import com.ghprint.cms.model.production.ProductionInfoView;
import com.ghprint.cms.pagination.DataGridResult;
import com.ghprint.cms.serviceDao.ProductionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/3/1.
 */
public class ProductionInfoServiceImpl implements  ProductionInfoService {

    private static Logger logger = LoggerFactory.getLogger(ProductionInfoServiceImpl.class);

    @Autowired
    private ProductionMapper productionMapper;


    /*
    * 查询生产质量标准列表
    * */
    @Override
    public DataGridResult getProductionList(String key,String value, Integer page, Integer rows) {
        ProductionInfoView productionInfoView = new ProductionInfoView();


        return null;
    }
}
