package com.ghprint.cms.services;

import cn.com.bestpay.Response;
import com.ghprint.cms.model.sys.TSysRole;
import com.ghprint.cms.pagination.DataGridResult;

import java.util.List;

/**
 * Created by lenovo on 2017/1/10.
 */
public interface RoleService {

    //查询角色列表
    public DataGridResult getRoleList(TSysRole tSysRole, Integer page , Integer rows);

    //添加角色
    public Response <String> addRoleInfo(TSysRole role,String ids[]);

    //删除角色
    public  Response<String> deleteRoleInfo(Integer roleid);


}
