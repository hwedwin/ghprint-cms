package com.ghprint.cms.serviceDao;

import com.ghprint.cms.model.sys.TSysPrivilege;
import com.ghprint.cms.model.sys.TSysPrivilegeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TSysPrivilegeMapper {
    int countByExample(TSysPrivilegeExample example);

    int deleteByExample(TSysPrivilegeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSysPrivilege record);

    int insertSelective(TSysPrivilege record);

    List<TSysPrivilege> selectByExample(TSysPrivilegeExample example);

    TSysPrivilege selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TSysPrivilege record, @Param("example") TSysPrivilegeExample example);

    int updateByExample(@Param("record") TSysPrivilege record, @Param("example") TSysPrivilegeExample example);

    int updateByPrimaryKeySelective(TSysPrivilege record);

    int updateByPrimaryKey(TSysPrivilege record);

    List getPrivilege(Integer roleid);
}