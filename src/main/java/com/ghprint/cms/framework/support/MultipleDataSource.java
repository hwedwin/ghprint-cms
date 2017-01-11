package com.ghprint.cms.framework.support;

/**
 * 
 * @author wjy 20140319
 * 
 */
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultipleDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return CustomerContextHolder.getCustomerType();
	}
}
