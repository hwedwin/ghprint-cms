package com.ghprint.cms.serviceDao;

import com.ghprint.cms.model.sys.TSysRole;
import com.ghprint.cms.model.sys.TSysUserRole;
import com.ghprint.cms.model.sys.TSysUserRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TSysUserRoleMapper {
    int countByExample(TSysUserRoleExample example);

    int deleteByExample(TSysUserRoleExample example);

    int deleteByPrimaryKey(Integer localid);

    int insert(TSysUserRole record);

    int insertSelective(TSysUserRole record);

    List<TSysUserRole> selectByExample(TSysUserRoleExample example);

    TSysUserRole selectByPrimaryKey(Integer localid);

    int updateByExampleSelective(@Param("record") TSysUserRole record, @Param("example") TSysUserRoleExample example);

    int updateByExample(@Param("record") TSysUserRole record, @Param("example") TSysUserRoleExample example);

    int updateByPrimaryKeySelective(TSysUserRole record);

    int updateByPrimaryKey(TSysUserRole record);


}