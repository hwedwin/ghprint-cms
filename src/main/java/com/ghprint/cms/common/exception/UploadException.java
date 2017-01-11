package com.ghprint.cms.common.exception;

/**
 * 
 * @ClassName: UploadException
 * @Description: 文件上传异常类
 * @author wjy
 * @date 2014-2-18 上午8:53:46
 * 
 */
@SuppressWarnings(value = { "unused" })
public class UploadException extends Exception {

	private static final long serialVersionUID = 3671368975601792088L;

	private UploadException() {
	}

	public UploadException(String message) {
		super(message);
	}

	public UploadException(Throwable cause) {
		super("上传文件出错", cause);
	}

	private UploadException(String message, Throwable cause) {
		super(message, cause);
	}
}
