package com.ghprint.cms.framework.exception;

public class CommonException extends Exception {

	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	
	private static final long serialVersionUID = -6728091884461334011L;

	private String errCode = "";
	
	private String errReason = "";
	
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	
	public void setErrReason(String errReason) {
		this.errReason = errReason;
	}
	
	public String getErrCode() {
		return errCode;
	}
	
	public String getErrReason() {
		return errReason;
	}
	
	public CommonException(String errCode, String errReason) {
		// TODO Auto-generated constructor stub
		super("[" + errCode + "]" + errReason);
		this.errCode = errCode;
		this.errReason =errReason;
	}
	
	public CommonException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
