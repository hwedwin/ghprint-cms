package com.ghprint.cms.serviceDao;

import com.ghprint.cms.model.stock.TCartonStock;
import com.ghprint.cms.model.stock.TCartonStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCartonStockMapper {
    int countByExample(TCartonStockExample example);

    int deleteByExample(TCartonStockExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCartonStock record);

    int insertSelective(TCartonStock record);

    List<TCartonStock> selectByExample(TCartonStockExample example);

    TCartonStock selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCartonStock record, @Param("example") TCartonStockExample example);

    int updateByExample(@Param("record") TCartonStock record, @Param("example") TCartonStockExample example);

    int updateByPrimaryKeySelective(TCartonStock record);

    int updateByPrimaryKey(TCartonStock record);
}