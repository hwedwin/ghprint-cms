package com.ghprint.cms.serviceDao;

import com.ghprint.cms.model.stock.TMaterialStock;
import com.ghprint.cms.model.stock.TMaterialStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMaterialStockMapper {
    int countByExample(TMaterialStockExample example);

    int deleteByExample(TMaterialStockExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TMaterialStock record);

    int insertSelective(TMaterialStock record);

    List<TMaterialStock> selectByExample(TMaterialStockExample example);

    TMaterialStock selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TMaterialStock record, @Param("example") TMaterialStockExample example);

    int updateByExample(@Param("record") TMaterialStock record, @Param("example") TMaterialStockExample example);

    int updateByPrimaryKeySelective(TMaterialStock record);

    int updateByPrimaryKey(TMaterialStock record);

    List <TMaterialStock> selectlist(@Param("pageOffset")Integer pageOffset,@Param("pageSize") Integer pageSize,@Param("key")String key,@Param("value")String value);

    Integer getlistcount(@Param("key")String key,@Param("value")String value);
}