package com.ghprint.cms.services;

import com.ghprint.cms.model.production.ProductionInfoView;
import com.ghprint.cms.pagination.DataGridResult;

import java.util.List;

/**
 * 生产标准模块业务
 * Created by Administrator on 2017/3/1.
 */
public interface ProductionInfoService {

    //增加生产标准
    public ProductionInfoView addProductionitems(ProductionInfoView productionInfoView);

    //查询现有的所有生产质量标准
    public DataGridResult  getProductionList(String key , String value,Integer page , Integer rows);

    //删除一条生产标准
    public  Integer  delProductionitems(Integer pid);

    //根据Id获取一种生产标准
    public ProductionInfoView getProductionitem(Integer pid);

    //根据ID修改现有的生产标准
    public  Integer  updateProductionitems(ProductionInfoView productionInfoView);

    //查询所有列表
    public List<ProductionInfoView> selectAllist();

}
