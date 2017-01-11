package com.ghprint.cms.model.sys;

public class TSysRolePrivilege {
    private Integer localid;

    private String roleid;

    private String privilegeid;

    public Integer getLocalid() {
        return localid;
    }

    public void setLocalid(Integer localid) {
        this.localid = localid;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    public String getPrivilegeid() {
        return privilegeid;
    }

    public void setPrivilegeid(String privilegeid) {
        this.privilegeid = privilegeid == null ? null : privilegeid.trim();
    }
}