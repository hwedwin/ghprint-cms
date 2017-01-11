package com.ghprint.cms.framework.exception;

/**
* @ClassName: RecordNotFoundException
* @Description: 查询无内容用此异常处理
* @author 庞超
* @date 2013-11-15 上午13:57:33
* 
*/
public class RecordNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -499950753647785127L;
	/**
	* @Fields ERR_MSG : 异常的信息
	*/
	public static final String ERR_MSG = "查询不到指定记录"; // 出错信息
	
	public RecordNotFoundException() {
		super(ERR_MSG);
	}
	
	public RecordNotFoundException(String msg) {
		super(msg);
	}
	
	public RecordNotFoundException(Throwable cause) {
		super(cause);
	}
	
	public RecordNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}

}

