package com.ghprint.cms.framework.exception;

public class ServiceInvokeException  extends Exception{

	private static final long serialVersionUID = 8982477199424455541L;
	
	@SuppressWarnings("unused")
	private ServiceInvokeException() {
		// TODO Auto-generated constructor stub
	}
	public ServiceInvokeException(String invokeMsg) {
		super(invokeMsg);
	}
	public ServiceInvokeException(Throwable cause) {
		super(cause);
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
}
