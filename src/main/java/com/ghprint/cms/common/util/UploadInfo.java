package com.ghprint.cms.common.util;

public class UploadInfo {
	private int code = 0; // 上传结果,使用本对象前请先验证该操作码
	private String message = ""; // 结果信息

	private String relativePath = ""; // 相对路径
	private String absolutePath = ""; // 绝对路径
	private String fileName = ""; // 文件名全名
	private String filePrefix = ""; // 文件名前缀
	private String ext = ""; // 文件名后缀(扩展名)

	private String fullURL = ""; // 物理全路径,含文件全名
	private Long fileSize = 0L; // 文件大小

	private String displayName = ""; // 当随机生成文件名时,保存上传文件的原名

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRelativePath() {
		return relativePath;
	}

	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}

	public String getAbsolutePath() {
		return absolutePath;
	}

	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePrefix() {
		return filePrefix;
	}

	public void setFilePrefix(String filePrefix) {
		this.filePrefix = filePrefix;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getFullURL() {
		return fullURL;
	}

	public void setFullURL(String fullURL) {
		this.fullURL = fullURL;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}
