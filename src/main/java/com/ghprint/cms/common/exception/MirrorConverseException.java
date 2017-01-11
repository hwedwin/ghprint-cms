package com.ghprint.cms.common.exception;

public class MirrorConverseException extends Exception{
	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	
	private static final long serialVersionUID = 3891809096625043497L;
	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	public static final String sign = "[ 字符和数据转换 example: 1111->data/data->111  ]";
	
	public static final String err_msg = sign+"数据映射失败"; // 出错信息

	public MirrorConverseException() {
		super(err_msg);
	}

	public MirrorConverseException(String message, Throwable cause) {
		super(sign+message, cause);
	}

	public MirrorConverseException(String message) {
		super(sign+message);
	}

	public MirrorConverseException(Throwable cause) {
		super(cause);
	}
}
