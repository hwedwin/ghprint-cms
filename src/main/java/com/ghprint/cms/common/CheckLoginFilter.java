package com.ghprint.cms.common;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class CheckLoginFilter implements Filter {
	
	private Logger log = LoggerFactory.getLogger(getClass().getName());
	
	public FilterConfig config = null;
	
	public static Set<String> sessionSet = new HashSet<String>();
	
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		log.info("Initializing filter 'encodingFilter'");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter");
		HttpSession session = ((HttpServletRequest) request).getSession();
		String basePath = "";
		HttpServletRequest _request = (HttpServletRequest)request;
		basePath = _request.getContextPath();

        String loginName=(String)session.getAttribute("USER_ID");
        if (StringUtils.isBlank(loginName)) {
			HttpServletResponse httpResponse = (HttpServletResponse) response;
        	if (isExcludeUrl(_request)) {
        		chain.doFilter(request,response);
        	} else {
        		httpResponse.sendRedirect(basePath + "/app/loginface3.jsp");
        	}
        } else {
        	if (!isExcludeUrl(_request)) {
            		chain.doFilter(request,response);
        	} else {
        		chain.doFilter(request,response);
        	}
        }
	}

	public void destroy() {
		config = null;
	}

	/**
	 * 检查当前访问url是否是范围以外的
	 * @param request
	 * @return 是排除以外url返回true，否则返回false
	 */
	private boolean isExcludeUrl(HttpServletRequest request) {
		boolean result = false;

		String path = request.getRequestURI();
		if (path.equalsIgnoreCase("/app")) {
			result = true;
		}else if (path.indexOf("app/loginface3.jsp") >= 0){
			result = true;
		}else if (path.indexOf("/app/filter.jsp") >= 0){
			result = true;
		}else if(path.indexOf("/healthcheck") >= 0){
			result = true;
		}else
		{
			result=false;
		}
		//result = true;
		return result;
	}

}

