package com.ghprint.cms.serviceDao;

import com.ghprint.cms.model.order.OrderView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
public interface OrderDetailMapper {

    int insertSelective(OrderView record);

    List<OrderView> selectlist(@Param("pageOffset")Integer pageOffset, @Param("pageSize") Integer pageSize, @Param("key")String key, @Param("value")String value);

    Integer getlistcount(@Param("key")String key,@Param("value")String value);
}
