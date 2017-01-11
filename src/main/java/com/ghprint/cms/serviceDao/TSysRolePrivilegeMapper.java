package com.ghprint.cms.serviceDao;

import com.ghprint.cms.model.sys.TSysRolePrivilege;
import com.ghprint.cms.model.sys.TSysRolePrivilegeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TSysRolePrivilegeMapper {
    int countByExample(TSysRolePrivilegeExample example);

    int deleteByExample(TSysRolePrivilegeExample example);

    int deleteByPrimaryKey(Integer localid);

    int insert(TSysRolePrivilege record);

    int insertSelective(TSysRolePrivilege record);

    List<TSysRolePrivilege> selectByExample(TSysRolePrivilegeExample example);

    TSysRolePrivilege selectByPrimaryKey(Integer localid);

    int updateByExampleSelective(@Param("record") TSysRolePrivilege record, @Param("example") TSysRolePrivilegeExample example);

    int updateByExample(@Param("record") TSysRolePrivilege record, @Param("example") TSysRolePrivilegeExample example);

    int updateByPrimaryKeySelective(TSysRolePrivilege record);

    int updateByPrimaryKey(TSysRolePrivilege record);

    List queryRoleList(String roleid);
}