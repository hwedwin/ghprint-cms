package com.ghprint.cms.serviceDao;

import com.ghprint.cms.model.sys.TSysUser;
import com.ghprint.cms.model.sys.TSysUserExample;
import com.ghprint.cms.model.sys.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TSysUserMapper {
    int countByExample(TSysUserExample example);

    int deleteByExample(TSysUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSysUser record);

    int insertSelective(TSysUser record);

    List<TSysUser> selectByExample(TSysUserExample example);

    TSysUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TSysUser record, @Param("example") TSysUserExample example);

    int updateByExample(@Param("record") TSysUser record, @Param("example") TSysUserExample example);

    int updateByPrimaryKeySelective(TSysUser record);

    int updateByPrimaryKey(TSysUser record);

    List<UserInfo> getUserInfolist();
}