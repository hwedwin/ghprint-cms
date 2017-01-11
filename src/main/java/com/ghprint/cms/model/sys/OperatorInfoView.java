package com.ghprint.cms.model.sys;

import java.util.List;

/**
 * Created by lenovo on 2017/1/8.
 */
public class OperatorInfoView {

    private  TSysUser user ;
    private List privilegeList;// 权限列表
    private List roleList;


    public TSysUser getUser() {
        return user;
    }

    public void setUser(TSysUser user) {
        this.user = user;
    }

    public List getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(List privilegeList) {
        this.privilegeList = privilegeList;
    }

    public List getRoleList() {
        return roleList;
    }

    public void setRoleList(List roleList) {
        this.roleList = roleList;
    }


    @Override
    public String toString() {
        return "OperatorInfoView{" +
                "user=" + user +
                ", privilegeList=" + privilegeList +
                ", roleList=" + roleList +
                '}';
    }
}
