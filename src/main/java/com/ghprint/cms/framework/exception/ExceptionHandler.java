package com.ghprint.cms.framework.exception;

import com.ghprint.cms.common.util.ToolUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.Map;

/**
* @ClassName: ExceptionHandler
* @Description: springmvc异常处理公用类
* @author 庞超
* @date 2013-11-15 上午13:57:33
* 
*/
public class ExceptionHandler implements HandlerExceptionResolver {   
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
	/** 
	* @Title: 异常处理
	* @Description: 对获取到的异常进行处理输出到页面
	* @param ex 异常对象
	* @return map
	* @throws 
	*/ 	
    @Override
    public ModelAndView resolveException(HttpServletRequest request,   
            HttpServletResponse response, Object handler, Exception ex) { 
    	logger.info("--------------------------ExceptionHandler异常处理开始---------------------------");
        //获取异常信息
    	Map<String,String> map= ToolUtils.getStackTraceMessage(ex);
    	//拼装异常页面信息
    	StringBuffer sbufferBuffer=new StringBuffer();
    	sbufferBuffer.append("<html>");
    	sbufferBuffer.append("<head><title>访问出错505</title></head>");
    	sbufferBuffer.append("<body>");
    	sbufferBuffer.append("<h2>Control has an execption</h2>");
    	sbufferBuffer.append("<h6>File Name:{0}</h6>");
    	sbufferBuffer.append("<h6>Class Name:{1}</h6>");
    	sbufferBuffer.append("<h6>Method Name:{2}</h6>");
    	sbufferBuffer.append("<h6>Line Number:{3}</h6>");
    	sbufferBuffer.append("<h2>Stacktrace Message</h2>");
    	sbufferBuffer.append("<h6>{4}</h6>");
    	sbufferBuffer.append("</body>");
    	sbufferBuffer.append("</html>");

        String errorMes=MessageFormat.format(sbufferBuffer.toString(), map.get("filename"), map.get("classname"), map.get("methodname"), map.get("linenumber"),ex.getMessage());
       
        // 根据不同错误返回不同的界面
        if(ex instanceof RuntimeException) {  			
	        try {
	        	response.setContentType("text/html;charset=utf-8");
	        	PrintWriter pw=response.getWriter();
				pw.write(errorMes);
				pw.flush();
				pw.close();
				
			} catch (IOException e) {	
				e.printStackTrace();
				logger.error("输出流异常",e);
			}
        } else {
        	try {
				response.getWriter().write(ex.getMessage());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return null;
    }   
  
}  