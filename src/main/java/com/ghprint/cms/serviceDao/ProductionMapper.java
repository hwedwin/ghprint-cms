package com.ghprint.cms.serviceDao;

import com.ghprint.cms.model.production.ProductionInfoView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/3/1.
 */
public interface ProductionMapper {

    //获取整个生产标准列表
    List<ProductionInfoView> selectlist(@Param("pageOffset")Integer pageOffset,@Param("pageSize") Integer pageSize,@Param("key")String key,@Param("value")String value);
    //获取总记录数
    Integer getlistcount(@Param("key")String key,@Param("value")String value);
    //根据产品ID查询一种生产标准
    ProductionInfoView getOneitem(@Param("pid") Integer pid);
    //查询所有
    List<ProductionInfoView> selectAllist();
}
