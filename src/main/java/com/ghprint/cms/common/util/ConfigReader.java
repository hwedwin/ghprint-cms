package com.ghprint.cms.common.util;

import java.util.*;

/**
 * 
 * @ClassName: ConfigReader
 * @Description: 读取资源属性文件
 * @author wjy
 * @date 2013-11-26 上午10:58:51
 * 
 */
public class ConfigReader {

	/**
	 * 
	 * @Title: readConfig
	 * @Description: 获取相应的properties文件的内容
	 * @param propFile
	 * @param propName
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String readConfig(String propFile, String propName) {
		return ResourceBundle.getBundle(propFile, Locale.getDefault())
				.getString(propName);
	}
	
	/**
	 * 
	 * @Title: getPropFileValues
	 * @Description: 获取相应的properties文件的内容
	 * @param propFile
	 * @return List<String> 返回类型
	 * @throws
	 */
	public static List<String> getPropFileValues(String propFile){
		ResourceBundle resourceBundle = ResourceBundle.getBundle(propFile, Locale.getDefault());
		Set<String> ResourceKey = resourceBundle.keySet();
		Iterator<String> it = ResourceKey.iterator();
		List<String> values = new ArrayList<String>();
		while(it.hasNext()){
			values.add(resourceBundle.getString(it.next()));
		}
		return values;
	}
}
