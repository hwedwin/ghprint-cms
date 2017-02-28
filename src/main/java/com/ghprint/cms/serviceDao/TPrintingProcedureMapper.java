package com.ghprint.cms.serviceDao;

import com.ghprint.cms.model.production.TPrintingProcedure;
import com.ghprint.cms.model.production.TPrintingProcedureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPrintingProcedureMapper {
    int countByExample(TPrintingProcedureExample example);

    int deleteByExample(TPrintingProcedureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPrintingProcedure record);

    int insertSelective(TPrintingProcedure record);

    List<TPrintingProcedure> selectByExample(TPrintingProcedureExample example);

    TPrintingProcedure selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPrintingProcedure record, @Param("example") TPrintingProcedureExample example);

    int updateByExample(@Param("record") TPrintingProcedure record, @Param("example") TPrintingProcedureExample example);

    int updateByPrimaryKeySelective(TPrintingProcedure record);

    int updateByPrimaryKey(TPrintingProcedure record);
}