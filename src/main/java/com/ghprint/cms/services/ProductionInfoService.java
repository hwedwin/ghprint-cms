package com.ghprint.cms.services;

import com.ghprint.cms.pagination.DataGridResult;

/**
 * Created by Administrator on 2017/3/1.
 */
public interface ProductionInfoService {

    //根据产品ID查询某种产品相应的生产质量标准


    //查询现有的所有生产质量标准
    public DataGridResult  getProductionList(String key , String value,Integer page , Integer rows);
}
