package com.ghprint.cms.framework.convert;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

public class JsonToArrayConverter implements Converter<String,String[]>{
	public String[] convert(String source) {
		String[] ids=null;
		if(source !=null && source.length()>0){
			ids=StringUtils.split(source, ";");
		}
		return ids;
	}
}
