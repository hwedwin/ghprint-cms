package com.ghprint.cms.serviceDao;

import com.ghprint.cms.model.order.OrderParams;
import com.ghprint.cms.model.order.TOrderParams;
import com.ghprint.cms.model.order.TOrderParamsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOrderParamsMapper {
    int countByExample(TOrderParamsExample example);

    int deleteByExample(TOrderParamsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TOrderParams record);

    int insertSelective(TOrderParams record);

    List<TOrderParams> selectByExample(TOrderParamsExample example);

    TOrderParams selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TOrderParams record, @Param("example") TOrderParamsExample example);

    int updateByExample(@Param("record") TOrderParams record, @Param("example") TOrderParamsExample example);

    int updateByPrimaryKeySelective(TOrderParams record);

    int updateByPrimaryKey(TOrderParams record);

    List<TOrderParams> selectlist(@Param("pageOffset")Integer pageOffset,@Param("pageSize") Integer pageSize,@Param("key")String key,@Param("value")String value);

    //获取总记录数
    Integer getlistcount(@Param("key")String key,@Param("value")String value);

    OrderParams getOneitem(@Param("id")Integer id);
}