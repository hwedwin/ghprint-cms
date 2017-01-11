package com.ghprint.cms.common.exception;

public class ParameterException extends RuntimeException{
	
	/**
	 * @Fields serialVersionUID：TODO
	 */
	private static final long serialVersionUID = 1L;

	public ParameterException(String errorMsg){
		super(errorMsg);		
	}	
}
