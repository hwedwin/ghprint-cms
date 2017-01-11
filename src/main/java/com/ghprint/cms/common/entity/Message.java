package com.ghprint.cms.common.entity;


public class Message {
	private boolean flag;
	private String message;
	private PageData pageData;

	public Message() {
	}

	public Message(boolean flag, String message, PageData pageData) {
		this.flag = flag;
		this.message = message;
		this.pageData = pageData;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PageData getPageList() {
		return pageData;
	}

	public void setPageList(PageData pageData) {
		this.pageData = pageData;
	}

}
