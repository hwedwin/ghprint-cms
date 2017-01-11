package com.ghprint.cms.model.sys;

/**
 * RolePrivilegeInfo entity. @author MyEclipse Persistence Tools
 */

public class RolePrivilegeInfo implements java.io.Serializable {

    // Fields    

    private int localid;
    private TSysRole roleInfo;
    private TSysPrivilege privilegeInfo;
    private int roleid;
	private int privilegeid;
    // Constructors

    /** default constructor */
    public RolePrivilegeInfo() {
    }

    /** full constructor */
    public RolePrivilegeInfo(int localid, TSysRole roleInfo,
                             TSysPrivilege privilegeInfo) {
        this.localid = localid;
        this.roleInfo = roleInfo;
        this.privilegeInfo = privilegeInfo;
    }
    public RolePrivilegeInfo(int localid, TSysRole roleInfo,
                             TSysPrivilege privilegeInfo, int roleid, int privilegeid) {
        this.localid = localid;
        this.roleInfo = roleInfo;
        this.privilegeInfo = privilegeInfo;
        this.roleid = roleid;
        this.privilegeid = privilegeid;
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

    public TSysPrivilege getPrivilegeInfo() {
        return this.privilegeInfo;
    }

    public void setPrivilegeInfo(TSysPrivilege privilegeInfo) {
        this.privilegeInfo = privilegeInfo;
    }
    
    public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public int getPrivilegeid() {
		return privilegeid;
	}

	public void setPrivilegeid(int privilegeid) {
		this.privilegeid = privilegeid;
	}

    @Override
    public String toString() {
        return "RolePrivilegeInfo{" +
                "localid=" + localid +
                ", roleInfo=" + roleInfo +
                ", privilegeInfo=" + privilegeInfo +
                ", roleid=" + roleid +
                ", privilegeid=" + privilegeid +
                '}';
    }
}