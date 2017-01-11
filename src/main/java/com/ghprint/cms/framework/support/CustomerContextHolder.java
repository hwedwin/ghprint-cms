package com.ghprint.cms.framework.support;

/**
 * 
 * @author wjy 20140319
 * 
 */
public abstract class CustomerContextHolder {

	public final static String DATA_SOURCE = "dataSource";
	public final static String DATA_SOURCE_MEPF = "dataSource4Mepf";

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	public static void setCustomerType(String customerType) {
		contextHolder.set(customerType);
	}

	public static String getCustomerType() {
		return contextHolder.get();
	}

	public static void clearCustomerType() {
		contextHolder.remove();
	}
}
