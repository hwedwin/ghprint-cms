package com.ghprint.cms.model.sys;

import java.util.Date;

public class TSysPrivilege {
    private Integer id;

    private String privilegeid;

    private String privilegename;

    private String privilegedesc;

    private String status;

    private Date createtime;

    private String grade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrivilegeid() {
        return privilegeid;
    }

    public void setPrivilegeid(String privilegeid) {
        this.privilegeid = privilegeid == null ? null : privilegeid.trim();
    }

    public String getPrivilegename() {
        return privilegename;
    }

    public void setPrivilegename(String privilegename) {
        this.privilegename = privilegename == null ? null : privilegename.trim();
    }

    public String getPrivilegedesc() {
        return privilegedesc;
    }

    public void setPrivilegedesc(String privilegedesc) {
        this.privilegedesc = privilegedesc == null ? null : privilegedesc.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    @Override
    public String toString() {
        return "TSysPrivilege{" +
                "id=" + id +
                ", privilegeid='" + privilegeid + '\'' +
                ", privilegename='" + privilegename + '\'' +
                ", privilegedesc='" + privilegedesc + '\'' +
                ", status='" + status + '\'' +
                ", createtime=" + createtime +
                ", grade='" + grade + '\'' +
                '}';
    }
}