
package com.ghprint.cms.common.entity;

import java.util.Date;

/**
 * 
* @ClassName: FileUpload
* @Description: 文件上传实体
* @author Tangyinbo
* @date 2014-1-2 下午4:16:02
*
 */
public class FileUpload {
	  private Integer fileId;//文件id
	  private String fileName;//原文件名
	  private String fileType;//文件分类
	  private String memo;//备注
	  private String path;//路径
	  private String fileFormat;//文件格式
	  private Integer fileSize;//文件大小
	  private Date upDate;//上传时间
	  private String staffId;//上传者帐号
	  private String stat;//上传状态
	  private String groupId;//所属组
	public FileUpload(Integer fileId, String fileName, String fileType, String memo, String path, String fileFormat, Integer fileSize, Date upDate, String staffId, String stat, String groupId) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.fileType = fileType;
		this.memo = memo;
		this.path = path;
		this.fileFormat = fileFormat;
		this.fileSize = fileSize;
		this.upDate = upDate;
		this.staffId = staffId;
		this.stat = stat;
		this.groupId = groupId;
	}
	public FileUpload() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFileFormat() {
		return fileFormat;
	}
	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}
	public Integer getFileSize() {
		return fileSize;
	}
	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}
	public Date getUpDate() {
		return upDate;
	}
	public void setUpDate(Date upDate) {
		this.upDate = upDate;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
}
