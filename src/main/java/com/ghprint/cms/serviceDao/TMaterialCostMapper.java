package com.ghprint.cms.serviceDao;

import com.ghprint.cms.model.stock.TMaterialCost;
import com.ghprint.cms.model.stock.TMaterialCostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMaterialCostMapper {
    int countByExample(TMaterialCostExample example);

    int deleteByExample(TMaterialCostExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TMaterialCost record);

    int insertSelective(TMaterialCost record);

    List<TMaterialCost> selectByExample(TMaterialCostExample example);

    TMaterialCost selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TMaterialCost record, @Param("example") TMaterialCostExample example);

    int updateByExample(@Param("record") TMaterialCost record, @Param("example") TMaterialCostExample example);

    int updateByPrimaryKeySelective(TMaterialCost record);

    int updateByPrimaryKey(TMaterialCost record);


}