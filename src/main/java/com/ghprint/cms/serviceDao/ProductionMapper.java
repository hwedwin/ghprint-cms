package com.ghprint.cms.serviceDao;

import com.ghprint.cms.model.production.ProductionInfoView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/3/1.
 */
public interface ProductionMapper {

    //根据产品ID查询一种生产标准
    List<ProductionInfoView> selectlist(@Param("pageOffset")Integer pageOffset,@Param("pageSize") Integer pageSize);

}
