package com.ghprint.cms.model.sys;

import java.io.Serializable;
import java.util.List;

public class GradePrivilegeView implements Serializable {
    private String grade;
    private String gradename;
    private int roleid;
    private boolean flag;
    private List privilegeList;

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename;
    }

    public List getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(List privilegeList) {
        this.privilegeList = privilegeList;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    /**
     * Constructs a <code>String</code> with all attributes
     * in name = value format.
     *
     * @return a <code>String</code> representation 
     * of this object.
     */
    @Override
	public String toString() {
        final String TAB = "    ";

        String retValue = "";

        retValue = "GradePrivilegeView ( " + super.toString() + TAB
                + "grade = " + this.grade + TAB + "gradename = "
                + this.gradename + TAB + "roleid = " + this.roleid + TAB
                + "privilegeList = " + this.privilegeList + TAB + " )";

        return retValue;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
