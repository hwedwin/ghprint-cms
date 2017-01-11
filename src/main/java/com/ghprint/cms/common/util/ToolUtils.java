package com.ghprint.cms.common.util;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @ClassName: ToolUtils
* @Description: 常用工具类
* @author 庞超
* @date 2013-11-15 上午13:57:33
* 
*/
public class ToolUtils {
	/** 
	* @Title: 解密
	* @Description: 获取异常具体的信息
	* @param ex 异常对象
	* @return map
	* @throws 
	*/ 	
    public static Map<String,String> getStackTraceMessage(Exception ex){
    	   StackTraceElement [] messages=ex.getStackTrace();
    	   Map<String,String> map=new HashMap<String, String>();
    	   map.put("classname",messages[0].getClassName());
    	   map.put("filename",messages[0].getFileName());
    	   map.put("linenumber",messages[0].getLineNumber()+"");
    	   map.put("methodname",messages[0].getMethodName());
    	   map.put("stackmessage",messages[0].toString());
    	   return map;
     }
	/**
	 * 
	* @Title: getByStringNonRepeat 
	* @Description: 切割字符串,返回无重复的字符串数组
	* @param @param value
	* @param @param separator
	* @param @param regex
	* @param @return
	* @return List
	* @author Tangyinbo
	* @throws
	 */
    public static List<String> getByStringNonRepeat(String value,String separator,String... regex){
    	if(value==null||separator==null){
    	//	throw new RuntimeException("切割的字符串和分隔符都是必须的");
    		return null;
    	}
    	List<String> sepValus = new ArrayList<String>();
    	String[] stringArrays = value.split(separator);
    	String regular = null;
    	Pattern pattern = null;
    	Matcher matcher = null;
    	if(regex.length>0){
    		regular = regex[0];
    		pattern = Pattern.compile(regular);
    	}
    	for(String s:stringArrays){
    		String trimValue = s.trim();
    		if(!sepValus.contains(trimValue)){
    			if(pattern!=null){
    				matcher = pattern.matcher(trimValue);
    				if(matcher.matches()){
    					sepValus.add(trimValue);
    				}
    			}else{
    				sepValus.add(trimValue);
    			}
    		}
    	}
    	return sepValus;
    }
	/**
	 * 
	* @Title: getCurrentDate 
	* @Description: 获取当前时间
	* @param @param value
	* @param @param separator
	* @throws
	 */
    public static String getCurrentDate(){
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date curDate = new Date();// 获取当前时间
		String curDateStr = formatter.format(curDate);
    	return curDateStr;
    }
	/**
	 * 
	* @Title: getCurrentDate1
	* @Description: 获取当前时间
	* @param @param value
	* @param @param separator
	* @throws
	 */
    public static String getCurrentDate1(){
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		Date curDate = new Date();// 获取当前时间
		String curDateStr = formatter.format(curDate);
    	return curDateStr;
    }
    
	public static String intactMessage(String errCode, String errMsg,Exception ex){
		StackTraceElement[] st = Thread.currentThread().getStackTrace();
		StackTraceElement[] st1 = ex.getStackTrace();		   
		StackTraceElement stackTraceElement=st[2];
		int lineNum=0;
		int length=st1.length;
		for(int i=0;i<length;i++){
			if(stackTraceElement.getMethodName().equals(st1[i].getMethodName())){
				lineNum=st1[i].getLineNumber();
			}
		}
		String begin="\n********************************************【具体代码报错位置】*************************************\n\n";
		String end="\n\n***********************************************************************************************";
		String exclass = stackTraceElement.getClassName();
		String method = stackTraceElement.getMethodName();
		return begin+"【错误码："+errCode+"   错误内容："+errMsg+"】\n"+ToolUtils.getCurrentDate() + ":" + "[类:" + exclass + "]\n调用[方法："
		+ method + "]时在第[" + lineNum
		+ "]行代码处发生异常!\n异常类型:[" + ex.getClass().getName()+"] 异常信息:["+ex.getMessage()+"]"+end;
	}	
//    public static void main(String[] args) {
//		String s= "fsfsf,sfsfsfsf,f234242,4253535,3535366,13444444444,15833333333,14455555,13431686027,13431686027";
//		for(String i :getByStringNonRepeat(s,",",CommonConstant.MOBILEREG)){
//			System.out.println(i);
//		}
//	}
}
