package com.ghprint.cms.framework.exception;

import com.ghprint.cms.common.util.ToolUtils;


public class BusinessException extends RuntimeException{
	
	private static final long serialVersionUID = -8194526084141229754L;
    
    private String errCode;
	
	private String errMsg;
	
	private String message;
	
	private Exception ex;
	
	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public Exception getEx() {
		return ex;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setEx(Exception ex) {
		this.ex = ex;
	}

	public BusinessException(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}
	
	public BusinessException(String errCode, String errMsg, Exception ex) {
		this.errCode = errCode;
		this.errMsg = errMsg;
		intactMessage(errCode,errMsg,ex);
	}	
	public void intactMessage(String errCode, String errMsg,Exception ex){
		if(ex instanceof BusinessException){
			this.setMessage(ex.getMessage());
			return;
		}
		String begin="\n********************************************【具体代码报错位置】*************************************\n\n";
		String end="\n\n***********************************************************************************************";
		StackTraceElement[] st = Thread.currentThread().getStackTrace();
		StackTraceElement[] st1 = ex.getStackTrace();		   
		StackTraceElement stackTraceElement=st[3];
		int lineNum=0;
		int length=st1.length;
		for(int i=0;i<length;i++){
			if(stackTraceElement.getMethodName().equals(st1[i].getMethodName()) && stackTraceElement.getClassName().equals(st1[i].getClassName())){
				lineNum=st1[i].getLineNumber();
				break;
			}
		}
		String exclass = stackTraceElement.getClassName();
		String method = stackTraceElement.getMethodName();
		this.setMessage(begin+"【错误码："+errCode+"   错误内容："+errMsg+"】\n"+ ToolUtils.getCurrentDate() + ":" + "[类:" + exclass + "]\n调用[方法："
		+ method + "]时在第[" + lineNum
		+ "]行代码处发生异常!\n异常类型:[" + ex.getClass().getName()+"]\n异常信息:["+ex.getMessage()+"]"+end);
	}	
}
