package com.ghprint.cms.model.sys;

import java.util.Date;

public class TSysRole {
    private Integer id;

    private String roleid;

    private String rolename;

    private String rolestatus;

    private String roledesc;

    private Date createtime;

    private Date edittime;

    private String grade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getRolestatus() {
        return rolestatus;
    }

    public void setRolestatus(String rolestatus) {
        this.rolestatus = rolestatus == null ? null : rolestatus.trim();
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc == null ? null : roledesc.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getEdittime() {
        return edittime;
    }

    public void setEdittime(Date edittime) {
        this.edittime = edittime;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }


    @Override
    public String toString() {
        return "TSysRole{" +
                "id=" + id +
                ", roleid='" + roleid + '\'' +
                ", rolename='" + rolename + '\'' +
                ", rolestatus='" + rolestatus + '\'' +
                ", roledesc='" + roledesc + '\'' +
                ", createtime=" + createtime +
                ", edittime=" + edittime +
                ", grade='" + grade + '\'' +
                '}';
    }
}