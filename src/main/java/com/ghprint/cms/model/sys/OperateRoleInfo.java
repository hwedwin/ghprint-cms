package com.ghprint.cms.model.sys;

import javax.management.relation.RoleInfo;

/**
 * OperateRoleInfo entity. @author MyEclipse Persistence Tools
 */

public class OperateRoleInfo implements java.io.Serializable {

    // Fields    

    private int localid;
    private TSysRole roleInfo;
    private TSysUser operatorInfo;
    private int roleid;
    private int operatorid;
    // Constructors

    public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public int getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(int operatorid) {
		this.operatorid = operatorid;
	}

	/** default constructor */
    public OperateRoleInfo() {
    }

    /** full constructor */
    public OperateRoleInfo(TSysRole roleInfo, TSysUser operatorInfo) {
        this.roleInfo = roleInfo;
        this.operatorInfo = operatorInfo;
    }

    // Property accessors

    public int getLocalid() {
        return this.localid;
    }

    public void setLocalid(int localid) {
        this.localid = localid;
    }

    public TSysRole getRoleInfo() {
        return this.roleInfo;
    }

    public void setRoleInfo(TSysRole roleInfo) {
        this.roleInfo = roleInfo;
    }

    public TSysUser getOperatorInfo() {
        return this.operatorInfo;
    }

    public void setOperatorInfo(TSysUser operatorInfo) {
        this.operatorInfo = operatorInfo;
    }

    @Override
    public String toString() {
        return "OperateRoleInfo{" +
                "localid=" + localid +
                ", roleInfo=" + roleInfo +
                ", operatorInfo=" + operatorInfo +
                ", roleid=" + roleid +
                ", operatorid=" + operatorid +
                '}';
    }
}