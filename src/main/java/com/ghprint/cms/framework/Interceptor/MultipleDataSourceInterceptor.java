package com.ghprint.cms.framework.Interceptor;

/**
 * 
 * @author wjy 20140319
 * 
 */

import com.ghprint.cms.framework.support.CustomerContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Proxy;

@Component
@Aspect
public class MultipleDataSourceInterceptor {

	/**
	 * 动态设置数据源
	 * 
	 * @author wjy 20140319
	 * @param joinPoint
	 * @throws Exception
	 */
	// @Before("execution(public * cn.com.bestpay..service.impl.*.*(..))")
	public void dynamicSetDataSoruce(JoinPoint joinPoint) throws Exception {

		Class<?> clazz = joinPoint.getTarget().getClass();
		String className = clazz.getName();
		if (ClassUtils.isAssignable(clazz, Proxy.class)) {
			className = joinPoint.getSignature().getDeclaringTypeName();
		}
		String methodName = joinPoint.getSignature().getName();
		if (className.contains("4Mepf") || methodName.contains("4Mepf")) {
			CustomerContextHolder
					.setCustomerType(CustomerContextHolder.DATA_SOURCE_MEPF);
		} else {
			CustomerContextHolder
					.setCustomerType(CustomerContextHolder.DATA_SOURCE);
		}
	}
}
