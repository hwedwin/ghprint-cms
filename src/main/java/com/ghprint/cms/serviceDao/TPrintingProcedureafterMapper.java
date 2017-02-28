package com.ghprint.cms.serviceDao;

import com.ghprint.cms.model.production.TPrintingProcedureafter;
import com.ghprint.cms.model.production.TPrintingProcedureafterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPrintingProcedureafterMapper {
    int countByExample(TPrintingProcedureafterExample example);

    int deleteByExample(TPrintingProcedureafterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPrintingProcedureafter record);

    int insertSelective(TPrintingProcedureafter record);

    List<TPrintingProcedureafter> selectByExample(TPrintingProcedureafterExample example);

    TPrintingProcedureafter selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPrintingProcedureafter record, @Param("example") TPrintingProcedureafterExample example);

    int updateByExample(@Param("record") TPrintingProcedureafter record, @Param("example") TPrintingProcedureafterExample example);

    int updateByPrimaryKeySelective(TPrintingProcedureafter record);

    int updateByPrimaryKey(TPrintingProcedureafter record);
}