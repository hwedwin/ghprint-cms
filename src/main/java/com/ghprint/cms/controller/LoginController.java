package com.ghprint.cms.controller;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.algorithm.MD5Util;
import com.ghprint.cms.model.sys.OperatorInfoView;
import com.ghprint.cms.model.sys.TSysUser;
import com.ghprint.cms.services.UserService;
import com.ghprint.cms.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);


    @Autowired
    UserService userService;
    /**
     * 登录验证
     *

     * @return 跳转页面
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public Response<TSysUser> login(HttpServletRequest request) throws ServletException, IOException {
        Response<TSysUser> response = new Response<>();
        try {

            String password=request.getParameter("userPassword");
            String account=request.getParameter("userAccount");
            log.info("传入参数{}",account+":"+password);

            TSysUser sysUser = userService.selectByAccount(account);
            if (sysUser == null) {
                 log.info("没有此用户account={}",account);
                response.setErrorCode(Constant.errorCodeEnum.LOGIN_ACCOUNT_NULL.getCode());
                response.setErrorMsg(Constant.errorCodeEnum.LOGIN_ACCOUNT_NULL.getName());
                return response;
            }

            //  修改: 保存到数据库的密码以MD5 大写保存。可用MD5Util生成。
            OperatorInfoView opview = null;

            opview = userService.login(account);



            log.info("密码验证:{}, {}", sysUser.getPassword(), MD5Util.getMD5String(password));
            Boolean acountType =sysUser.getPassword().toUpperCase().equals( MD5Util.getMD5String(password).toUpperCase());
            log.info("验证是否通过acountType={}",acountType);
            sysUser.setPassword(null);
            if (acountType && opview != null) {
                request.getSession().setAttribute("USER_ID", sysUser);
                List<OperatorInfoView> authorityList = opview.getPrivilegeList();
                request.getSession().setAttribute("authorityList", authorityList);
                log.info("权限列表authorityList={}",authorityList);
                response.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                response.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                response.setResult(sysUser);
                return response;
            } else {
                //发送失败
                response.setErrorCode(Constant.errorCodeEnum.LOGIN_PASSWORD_ERROE.getCode());
                response.setErrorMsg(Constant.errorCodeEnum.LOGIN_PASSWORD_ERROE.getName());
                return response;
            }
        } catch (Exception e) {
            log.error("login_Exception:{}",e.toString());
            e.printStackTrace();
            response.setErrorCode(Constant.errorCodeEnum.SYSTEM_ERROR.getCode());
            response.setErrorMsg(Constant.errorCodeEnum.SYSTEM_ERROR.getName());
            return response;
        }
    }


    /**
     * 注销
     *

     * @return 跳转页面
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/logout.do", method = RequestMethod.GET)
    @ResponseBody
    public Response<String> logout(HttpServletRequest request) throws ServletException, IOException {
        Response<String> response = new Response<>();
        try {
        String account=request.getParameter("userAccount");
             log.info("传入参数{}",account);
            request.getSession().invalidate();
            log.info("注销成功");
            response.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
            response.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
            response.setResult("logout success!");
            return  response;
        } catch (Exception e) {
            log.error("logout_Exception:{}",e.toString());
            e.printStackTrace();
            response.setErrorCode(Constant.errorCodeEnum.SYSTEM_ERROR.getCode());
            response.setErrorMsg(Constant.errorCodeEnum.SYSTEM_ERROR.getName());
            response.setResult(e.toString());
            return response;
        }
    }
}