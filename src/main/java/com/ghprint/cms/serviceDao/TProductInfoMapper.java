package com.ghprint.cms.serviceDao;

import com.ghprint.cms.model.production.TProductInfo;
import com.ghprint.cms.model.production.TProductInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProductInfoMapper {
    int countByExample(TProductInfoExample example);

    int deleteByExample(TProductInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TProductInfo record);

    int insertSelective(TProductInfo record);

    List<TProductInfo> selectByExample(TProductInfoExample example);

    TProductInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TProductInfo record, @Param("example") TProductInfoExample example);

    int updateByExample(@Param("record") TProductInfo record, @Param("example") TProductInfoExample example);

    int updateByPrimaryKeySelective(TProductInfo record);

    int updateByPrimaryKey(TProductInfo record);
}