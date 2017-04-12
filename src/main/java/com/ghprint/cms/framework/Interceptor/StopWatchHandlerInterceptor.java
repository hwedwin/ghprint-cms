package com.ghprint.cms.framework.Interceptor;

import com.ghprint.cms.model.sys.TSysUser;
import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.common.collect.Sets;
import com.google.common.io.LineProcessor;
import com.google.common.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;
import java.util.regex.Pattern;

import static com.google.common.base.Preconditions.checkState;

/**
* @ClassName: StopWatchHandlerInterceptor
* @Description: springmvc过滤器获取当前请求所花费的时间
* @author 庞超
* @date 2013-11-15 上午13:57:33
* 
*/
public class StopWatchHandlerInterceptor extends HandlerInterceptorAdapter {  
	private static final Logger logger = LoggerFactory.getLogger(StopWatchHandlerInterceptor.class);
    private final Set<String> whiteList;
    private NamedThreadLocal<Long>  startTimeThreadLocal =new NamedThreadLocal<Long>("StopWatch-StartTime");

    private StopWatchHandlerInterceptor() {
        this.whiteList =  Sets.newHashSet();
        try {
            Resources.readLines(Resources.getResource("/white_list.properties"), Charsets.UTF_8, new LineProcessor<Void>() {
                @Override
                public boolean processLine(String line) throws IOException {
                    if (!Strings.isNullOrEmpty(line)) {
                        whiteList.add(line);
                    }
                    return true;
                }

                @Override
                public Void getResult() {
                    return null;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override  
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,   
    			Object handler) throws Exception {
        long beginTime = System.currentTimeMillis();//1、开始时间  
        startTimeThreadLocal.set(beginTime);//线程绑定变量（该数据只有当前请求的线程可见）
       String uri =  request.getRequestURI();

        for (String whiteItem : whiteList) {  //method and uri matches with white list, ok
            String compileUrl = whiteItem;
            if (whiteItem.startsWith(".*")){
            }else{
                compileUrl="^"+compileUrl;
            }
            if (whiteItem.endsWith(".*")){
            }else{
                compileUrl=compileUrl+"$";
            }
            Pattern urlPattern = Pattern.compile(compileUrl);
            if ( urlPattern.matcher(uri).matches()) {
                return true;
            }
        }
        TSysUser tSysUser = (TSysUser) request.getSession().getAttribute("USER_ID");
        //如果用户未登录
        if (tSysUser==null){
            response.sendRedirect(request.getContextPath()+"/index.html");
            return false;
        }
        return true;//继续流程  
    }  
    @Override  
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,   
    	        Object handler, Exception ex) throws Exception {  
        long endTime = System.currentTimeMillis();//2、结束时间  
        long beginTime = startTimeThreadLocal.get();//得到线程绑定的局部变量（开始时间）  
        long consumeTime = endTime - beginTime;//3、消耗的时间  

        //TODO 记录到日志文件  
        logger.info(String.format("=============该路径请求 %s所用时间为 %d millis================", request.getRequestURI(), consumeTime));
    }  
}  
