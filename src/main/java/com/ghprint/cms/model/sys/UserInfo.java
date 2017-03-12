package com.ghprint.cms.model.sys;

/**
 * Created by Administrator on 2017/3/12.
 */
public class UserInfo {
    private  Integer id;
    private  TSysUser tSysUser;
    private String rolename;

    public TSysUser gettSysUser() {
        return tSysUser;
    }

    public void settSysUser(TSysUser tSysUser) {
        this.tSysUser = tSysUser;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "tSysUser=" + tSysUser +
                ", rolename='" + rolename + '\'' +
                '}';
    }
}
