package com.ghprint.cms.serviceDao;

import com.ghprint.cms.model.production.TPrintingData;
import com.ghprint.cms.model.production.TPrintingDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPrintingDataMapper {
    int countByExample(TPrintingDataExample example);

    int deleteByExample(TPrintingDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPrintingData record);

    int insertSelective(TPrintingData record);

    List<TPrintingData> selectByExample(TPrintingDataExample example);

    TPrintingData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPrintingData record, @Param("example") TPrintingDataExample example);

    int updateByExample(@Param("record") TPrintingData record, @Param("example") TPrintingDataExample example);

    int updateByPrimaryKeySelective(TPrintingData record);

    int updateByPrimaryKey(TPrintingData record);
}