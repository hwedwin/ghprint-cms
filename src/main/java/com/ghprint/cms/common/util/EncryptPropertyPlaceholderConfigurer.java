package com.ghprint.cms.common.util;

import com.ghprint.cms.common.algorithm.DESUtils;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @ClassName: EncryptPropertyPlaceholderConfigurer
 * @Description: 对属性文件的配置数据库连接用户名和密码加密
 * @author 庞超
 * @date 2013-11-15 上午13:57:33
 * 
 */
public class EncryptPropertyPlaceholderConfigurer extends
		PropertyPlaceholderConfigurer {
	/**
	 * modify by wjy 20140319
	 * @Fields encryptPropNames : 需要加密的字段
	 */
	private String[] encryptPropNames = { "username", "password",
			"username4Mepf", "password4Mepf" };

	/**
	 * @Title: 解密
	 * @Description: 对属性文件的加密字段解密后在连接数据库
	 * @param propertyName
	 *            属性名字
	 * @param propertyValue
	 *            属性值
	 * @return null
	 * @throws
	 */
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		if (isEncryptProp(propertyName)) {
			String decryptValue = DESUtils.getDecryptString(propertyValue);
			return decryptValue;
		} else {
			return propertyValue;
		}
	}

	/**
	 * @Title: 校验
	 * @Description: 判断是否是加密的属性
	 * @param propertyName
	 *            属性名字
	 * @return boolean
	 * @throws
	 */
	private boolean isEncryptProp(String propertyName) {
		for (String encryptPropName : encryptPropNames) {
			if (encryptPropName.equals(propertyName)) {
				return true;
			}
		}
		return false;
	}
}
