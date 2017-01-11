package com.ghprint.cms.controller;


import com.ghprint.cms.model.sys.ListNode;
import com.ghprint.cms.model.sys.TSysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Administrator
 *
 */

public abstract class BaseAction  {
    private static Logger logger = LoggerFactory.getLogger(BaseAction.class);

    /**
     * 权限控制
     *
     * @param request
     *            HttpServletRequest
     * @param response
     *            HttpServletResponse
     * @return ActionForward
     * @roseuid 415B5C0C00D2
     * @throws IOException
     * @throws ServletException
     */
    public Boolean execute(
            HttpServletRequest request, HttpServletResponse response)
            throws Exception

    {
        logger.info("now enter BaseAction:execute method!");
        HttpSession session = request.getSession(false);
        logger.info("session:" + session);
        // 网页超时
        Boolean flags = Boolean.FALSE;
        if (session == null) {
            logger.error("session has been timeout!");
            request.setAttribute("message", "网页超时,请重新登录！");
            return flags;
        } else {
            if ((TSysUser) session.getAttribute("USER_ID") == null) {
                logger.info(" TSysUser is null");
                request.setAttribute("message", "网页超时,请重新登录！");
                return flags;
            }
        }

        // 权限
        Boolean flag = Boolean.FALSE;
        String authorityKey = this.getAuthorityId();
        logger.info("权限标示为:" + authorityKey);
        flag = this.getPrivilege(session, authorityKey);
        if (!flag.booleanValue()) {
            logger.info("没有权限");
            request.setAttribute("message", "对不起，您没有权限！");
            return flags;
        }
        logger.info("BaseAction execute method operated successfully!");
        return true;
    }

    /**
     * execute
     *
     *  @param request
     *            HttpServletRequest
     * @param response
     *            HttpServletResponse
     * @param session
     *            HttpSession
     * @return ActionForward
     * @roseuid 415B5C1B0015
     */


    /**
     * 获得用户权限
     *
     * @return java.lang.String
     * @roseuid 415B5C2A00B7
     */
    public abstract String getAuthorityId();

    /**
     * @Title: getPrivilege
     * @Description: get Privilege
     * @param session
     *            HttpSession
     * @param authorityKey
     *            int
     * @return Boolean
     */
    protected Boolean getPrivilege(HttpSession session, String authorityKey) {
        Boolean flag = Boolean.FALSE;
        List authorityList = (List) session.getAttribute("authorityList");
        if (authorityList != null) {
            Iterator iter = authorityList.iterator();
            while (iter.hasNext()) {
                ListNode node = (ListNode) iter.next();
                //				logger.info("具有权限id：" + node.getKey());
                if (authorityKey.indexOf(",") != -1) {
                    String[] key = authorityKey.split(",");
                    for (int i = 0; i < key.length; i++) {
                        if (key[i].equals(node.getKey())) {
                            flag = Boolean.TRUE;
                        }
                    }
                } else {
                    if (authorityKey.equals(node.getKey())) {
                        flag = Boolean.TRUE;
                    }
                }
            }
        }
        return flag;
    }




}
