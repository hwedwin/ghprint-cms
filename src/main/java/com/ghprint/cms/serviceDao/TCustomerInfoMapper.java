package com.ghprint.cms.serviceDao;

import com.ghprint.cms.model.production.TCustomerInfo;
import com.ghprint.cms.model.production.TCustomerInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCustomerInfoMapper {
    int countByExample(TCustomerInfoExample example);

    int deleteByExample(TCustomerInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCustomerInfo record);

    int insertSelective(TCustomerInfo record);

    List<TCustomerInfo> selectByExample(TCustomerInfoExample example);

    TCustomerInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCustomerInfo record, @Param("example") TCustomerInfoExample example);

    int updateByExample(@Param("record") TCustomerInfo record, @Param("example") TCustomerInfoExample example);

    int updateByPrimaryKeySelective(TCustomerInfo record);

    int updateByPrimaryKey(TCustomerInfo record);
}