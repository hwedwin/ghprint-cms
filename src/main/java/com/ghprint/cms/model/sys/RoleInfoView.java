package com.ghprint.cms.model.sys;


import java.util.List;

public class RoleInfoView{
	private int roleId;
	private String roleName;
	private String description;
	private int roleStatus;
	private String statusName;
	private String creatTime;
	private String lastModTime;
	private List privilegeInfoList;
	private String grade;
	private int caid;
	public int getCaid() {
		return caid;
	}

	public void setCaid(int caid) {
		this.caid = caid;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCreatTime() {
		return creatTime;
	}

	public String getDescription() {
		return description;
	}

	public String getLastModTime() {
		return lastModTime;
	}

	public int getRoleId() {
		return roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public int getRoleStatus() {
		return roleStatus;
	}

	public String getStatusName() {
		return statusName;
	}

	public List getPrivilegeInfoList() {
		return privilegeInfoList;
	}

	public void setRoleStatus(int roleStatus) {
		this.roleStatus = roleStatus;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public void setLastModTime(String lastModTime) {
		this.lastModTime = lastModTime;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public void setPrivilegeInfoList(List privilegeInfoList) {
		this.privilegeInfoList = privilegeInfoList;
	}

	/**
	 * Constructs a <code>String</code> with all attributes in name = value
	 * format.
	 * 
	 * @return a <code>String</code> representation of this object.
	 */
	@Override
	public String toString() {
		final String TAB = "    ";

		String retValue = "";

		retValue = "RoleInfoView ( " + super.toString() + TAB + "roleId = "
				+ this.roleId + TAB + "roleName = " + this.roleName + TAB
				+ "description = " + this.description + TAB + "roleStatus = "
				+ this.roleStatus + TAB + "statusName = " + this.statusName
				+ TAB + "creatTime = " + this.creatTime + TAB
				+ "lastModTime = " + this.lastModTime + TAB
				+ "privilegeInfoList = " + this.privilegeInfoList + TAB + " )";

		return retValue;
	}

}
