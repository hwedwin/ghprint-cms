package com.ghprint.cms.controller.biz.User;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.common.algorithm.MD5Util;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.model.sys.OperateRoleInfo;
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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lenovo on 2017/1/17.
 */
@Controller
public class UpdateUsersController  extends BaseAction{

    private static Logger logger = LoggerFactory.getLogger(UpdateUsersController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userinfo/updateuserinfo.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response<String> updateuserinfo (HttpServletRequest request, HttpServletResponse response,  TSysUser user) {

        Response<String> responses = new Response<>();

        Assert.hasText(user.getUsername(), "user 中 username  is null or 空字符串。");
        Assert.hasText(user.getPassword(), "user 中 userpassword  is null or 空字符串。");
        Assert.hasText(String.valueOf(user.getId()), "user 中 Id  is null or 空字符串。");
        logger.info("UPDATEUsersinfo request Param :{}", user);
        try {
            Boolean flag = super.execute(request, response);
            if (flag) {
                    userService.updateUserInfo(user);

                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult("success");
                    return responses;
            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (IllegalArgumentException ex) {
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

    @RequestMapping(value = "/userinfo/updateroleship.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public  Response<String> SetUsersRoleShip (HttpServletRequest request, HttpServletResponse response, @RequestParam Integer userid ,@RequestParam Integer roleid){
        Response<String> responses = new Response<>();
        Assert.hasText(String.valueOf(userid), "userid is null or 空字符串。");
        Assert.hasText(String.valueOf(roleid), "roleid is null or 空字符串。");
        logger.info("SetUsersRoleShip request Param :{}", userid +"&"+ roleid );
        try {
            Boolean flag = super.execute(request, response);
            if (flag) {
                userService.updateRoleinfo(userid,roleid);
                responses.setResult("success");
                responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                return responses;
            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (IllegalArgumentException ex) {
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


    @RequestMapping(value = "/userinfo/updateuserpassword.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public  Response<String> UpdateUserPassword(HttpServletRequest request, HttpServletResponse response,@RequestParam String newpassword ,@RequestParam String oldpassword,@RequestParam Integer userid){
        Response<String> responses = new Response<>();

        try {
            Assert.hasText(String.valueOf(newpassword), "newpassword is null or 空字符串。");
            Assert.hasText(String.valueOf(oldpassword), "oldpassword is null or 空字符串。");
            Assert.hasText(String.valueOf(userid), "oldpassword is null or 空字符串。");
            logger.info("SetUsersRoleShip request Param :{}","OLD:"+ oldpassword +"& NEW:"+ newpassword+"&"+userid );
            Boolean flag = super.execute(request, response);
            if (flag) {
                OperateRoleInfo operateRoleInfo = userService.getUserinfo(userid);
                String old = operateRoleInfo.getOperatorInfo().getPassword();
                if(!old.equals(MD5Util.getMD5String(oldpassword))){
                    responses.setErrorCode(Constant.errorCodeEnum.PARAM_ERROR.getCode());
                    responses.setErrorMsg("原密码不正确");
                    return responses;
                }else{
                    TSysUser user =new TSysUser();
                    user = userService.selectByUserId(userid);
                    user.setPassword(MD5Util.getMD5String(newpassword));
                    userService.resetPwd(user);
                    responses.setResult("success");
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    return responses;
                }

            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (IllegalArgumentException ex) {
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
        return AuthorityKey.USER_MODIFY;
    }
}
