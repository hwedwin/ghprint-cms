package com.ghprint.cms.framework.exception;
/**
 * 
* @ClassName: InitDataException
* @Description: 系统数据初始化异常
* @author Tangyinbo
* @date 2014-3-27 下午3:45:09
*
 */
public class InitDataException extends RuntimeException{
	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = 6739107476731378946L;
	
	public static final String ERR_MSG = "系统初始化信息失败"; // 出错信息

	public InitDataException() {
		super(ERR_MSG);
	}

	public InitDataException(String message, Throwable cause) {
		super(message, cause);
	}

	public InitDataException(String message) {
		super(message);
	}

	public InitDataException(Throwable cause) {
		super(cause);
	}
	
}
