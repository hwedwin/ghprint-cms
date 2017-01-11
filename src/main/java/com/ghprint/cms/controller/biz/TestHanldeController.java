package com.ghprint.cms.controller.biz;

import com.ghprint.cms.common.AuthorityKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import  com.ghprint.cms.controller.BaseAction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by lenovo on 2017/1/7.
 */
@Controller
@RequestMapping("/biz/TestHandelController")
public class TestHanldeController extends  BaseAction{
    private static Logger logger = LoggerFactory.getLogger(TestHanldeController.class);
    @RequestMapping(value = "/test.do", method = RequestMethod.GET)
    @ResponseBody
    public String execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
        super.execute(request,response);
        logger.info("进入方法");
        return  new String("拥有权限");
    }

    @Override
    public String getAuthorityId() {
        return AuthorityKey.AUDIT_LOG;
    }
}
