package com.ghprint.cms.controller.biz.User;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.services.UserService;
import com.ghprint.cms.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lenovo on 2017/1/17.
 */
@Controller
public class DeleUserController extends BaseAction  {
    private  static Logger logger = LoggerFactory.getLogger(DeleUserController.class);
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/userinfo/deleteuserinfo.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response<String> deleteUsersinfo(HttpServletRequest request, HttpServletResponse response, @RequestParam Integer userid){

        Response<String> responses = new Response<>();

        try {
            Assert.hasText(String.valueOf(userid), "userid  is null or 空字符串。");
            logger.info("enter into execute of DelUsersAction ");
            Boolean flag = super.execute(request, response);

            logger.info("delete userinfo request Param:{}",userid);
            if (flag) {
                if(userid!= null && userid > 0){

                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                    responses.setResult(String.valueOf(userService.deleteUser(userid)));
                    return responses;
                }
                else{
                    responses.setErrorCode(Constant.errorCodeEnum.PARAM_ERROR.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.PARAM_ERROR.getName());
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
        }catch (Exception e) {
            logger.error("系统异常  error: " + e);
            responses.setErrorCode(Constant.errorCodeEnum.SYSTEM_ERROR.getCode());
            responses.setErrorMsg(Constant.errorCodeEnum.SYSTEM_ERROR.getName());
            return responses;
        }
    }
    @Override
    public String getAuthorityId() {
        return AuthorityKey.USER_DEL;
    }
}
