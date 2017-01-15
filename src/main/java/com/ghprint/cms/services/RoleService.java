package com.ghprint.cms.services;

import cn.com.bestpay.Response;
import com.ghprint.cms.model.sys.RoleInfoView;
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

     //获取权限
    public List queryPrivilege();

     //查询角色明细
    public RoleInfoView queryRole(Integer roleid);

     //获取相应roleid权限
    public List queryPrivilege(Integer roleid);


    //  修改角色状态
    public int updateRoleStatus(Integer roleid, String status);

    //查看角色是否已被使用
    public boolean queryRoleUserd(Integer roleid);

     //修改角色
    public Response<String> editRole(TSysRole tSysRole,String ids[]);


}
