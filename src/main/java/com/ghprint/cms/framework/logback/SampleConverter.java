package com.ghprint.cms.framework.logback;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
* @ClassName: SampleConverter
* @Description: 对输出的日志进行监控
* @author 庞超
* @date 2013-11-15 上午13:57:33
* 
*/
public class SampleConverter extends ClassicConverter{
		@Override 
		public String convert(ILoggingEvent event) {
			if(event.getLevel().toString().toLowerCase().contains("error")){
				System.err.println("----------------------------------【ERROR错误】----------------------------------");
			}
		    return event.getLevel().toString();
		}
}
