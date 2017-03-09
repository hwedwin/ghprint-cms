package com.ghprint.cms.controller.biz.User;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.common.algorithm.MD5Util;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.model.sys.GradePrivilegeView;
import com.ghprint.cms.model.sys.TSysRole;
import com.ghprint.cms.model.sys.TSysUser;
import com.ghprint.cms.services.UserService;
import com.ghprint.cms.utils.Constant;
import com.wordnik.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2017/1/17.
 */
@Controller
public class AddUsersController extends BaseAction{
    private  static Logger logger = LoggerFactory.getLogger(AddUsersController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userinfo/addpreuserinfo.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response<List> addpreuserinfo (HttpServletRequest request, HttpServletResponse response){
        Response <List> responses = new Response<>();
        logger.info("enter into execute of AddPreUsersAction ");
        // 获取权限列表
        try {
            Boolean flag = super.execute(request, response);
            if (flag) {
                List list = userService.getRolelist();
                responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                responses.setResult(list);
                return  responses;
            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            logger.error("添加用户初始化失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("添加用户初始化失败");
            return  responses;
        }
    }


    @RequestMapping(value = "/userinfo/adduserinfo.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response<String> addruserinfo(HttpServletRequest request, HttpServletResponse response,  TSysUser user, String uid){
        Response <String> responses = new Response<>();
        Assert.hasText(user.getUsername(), "user 中 username  is null or 空字符串。");
        Assert.hasText(user.getPassword(), "user 中 userpassword  is null or 空字符串。");
        Assert.hasText(user.getUserid(), "user 中 userId  is null or 空字符串。");
        Assert.hasText(uid, "id is null or 空字符串。");
        logger.info("AddRoleinfo request Param :{}",user);
        logger.info("AddRoleinfo request Param :{}",uid);
        try{
            Boolean flag = super.execute(request, response);
            if (flag) {
                if(StringUtils.isNotBlank(uid)){
                    user.setCreatetime(new Date());
                    user.setPassword(MD5Util.getMD5String(user.getPassword()).toUpperCase());
                    userService.addUser(user,uid);
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                }else {
                    responses.setErrorCode(Constant.errorCodeEnum.PARAM_ERROR.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.PARAM_ERROR.getName());
                }
                return  responses;
            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        }catch (IllegalArgumentException ex) {
            logger.info("参数错误  error: " + ex);
            responses.setErrorCode(Constant.errorCodeEnum.PARAM_ERROR.getCode());
            responses.setErrorMsg(Constant.errorCodeEnum.PARAM_ERROR.getName());
            return responses;
        } catch (Exception e) {
            logger.error("系统异常  error: " + e);
            responses.setErrorCode(Constant.errorCodeEnum.SYSTEM_ERROR.getCode());
            responses.setErrorMsg(Constant.errorCodeEnum.SYSTEM_ERROR.getName());
            return responses;
        }
    }

    @Override
    public String getAuthorityId() {
        return AuthorityKey.USER_ADD;
    }
}
