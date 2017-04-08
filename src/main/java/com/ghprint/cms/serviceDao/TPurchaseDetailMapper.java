package com.ghprint.cms.serviceDao;

import com.ghprint.cms.model.order.OrderInfo;
import com.ghprint.cms.model.order.TPurchaseDetail;
import com.ghprint.cms.model.order.TPurchaseDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPurchaseDetailMapper {
    int countByExample(TPurchaseDetailExample example);

    int deleteByExample(TPurchaseDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPurchaseDetail record);

    int insertSelective(TPurchaseDetail record);

    List<TPurchaseDetail> selectByExample(TPurchaseDetailExample example);

    TPurchaseDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPurchaseDetail record, @Param("example") TPurchaseDetailExample example);

    int updateByExample(@Param("record") TPurchaseDetail record, @Param("example") TPurchaseDetailExample example);

    int updateByPrimaryKeySelective(TPurchaseDetail record);

    int updateByPrimaryKey(TPurchaseDetail record);

    List <OrderInfo> selectlist(@Param("pageOffset")Integer pageOffset, @Param("pageSize") Integer pageSize, @Param("key")String key, @Param("value")String value);

    Integer getlistcount(@Param("key")String key,@Param("value")String value);

    OrderInfo getOneitem(@Param("id")Integer id);

}