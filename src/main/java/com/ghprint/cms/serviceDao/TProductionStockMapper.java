package com.ghprint.cms.serviceDao;

import com.ghprint.cms.model.stock.TProductionStock;
import com.ghprint.cms.model.stock.TProductionStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProductionStockMapper {
    int countByExample(TProductionStockExample example);

    int deleteByExample(TProductionStockExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TProductionStock record);

    int insertSelective(TProductionStock record);

    List<TProductionStock> selectByExample(TProductionStockExample example);

    TProductionStock selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TProductionStock record, @Param("example") TProductionStockExample example);

    int updateByExample(@Param("record") TProductionStock record, @Param("example") TProductionStockExample example);

    int updateByPrimaryKeySelective(TProductionStock record);

    int updateByPrimaryKey(TProductionStock record);
}