package com.ghprint.cms.serviceDao;

import com.ghprint.cms.model.sys.TSysRole;
import com.ghprint.cms.model.sys.TSysRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TSysRoleMapper {
    int countByExample(TSysRoleExample example);

    int deleteByExample(TSysRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSysRole record);

    int insertSelective(TSysRole record);

    List<TSysRole> selectByExample(TSysRoleExample example);

    TSysRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TSysRole record, @Param("example") TSysRoleExample example);

    int updateByExample(@Param("record") TSysRole record, @Param("example") TSysRoleExample example);

    int updateByPrimaryKeySelective(TSysRole record);

    int updateByPrimaryKey(TSysRole record);


}