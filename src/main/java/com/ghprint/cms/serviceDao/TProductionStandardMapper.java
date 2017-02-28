package com.ghprint.cms.serviceDao;

import com.ghprint.cms.model.production.TProductionStandard;
import com.ghprint.cms.model.production.TProductionStandardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProductionStandardMapper {
    int countByExample(TProductionStandardExample example);

    int deleteByExample(TProductionStandardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TProductionStandard record);

    int insertSelective(TProductionStandard record);

    List<TProductionStandard> selectByExample(TProductionStandardExample example);

    TProductionStandard selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TProductionStandard record, @Param("example") TProductionStandardExample example);

    int updateByExample(@Param("record") TProductionStandard record, @Param("example") TProductionStandardExample example);

    int updateByPrimaryKeySelective(TProductionStandard record);

    int updateByPrimaryKey(TProductionStandard record);
}