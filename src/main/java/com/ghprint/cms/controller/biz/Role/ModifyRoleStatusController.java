package com.ghprint.cms.controller.biz.Role;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.services.RoleService;
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

/**
 * Created by lenovo on 2017/1/16.
 */
@Controller
public class ModifyRoleStatusController  extends BaseAction {

    private  static Logger logger = LoggerFactory.getLogger(ModifyRoleStatusController.class);

    @Autowired
    private RoleService roleService;


    @RequestMapping(value = "/roleinfo/updaterolestatus.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    //@ApiOperation(value = "更新角色状态")
    public Response<String> updaterolestatus (HttpServletRequest request, HttpServletResponse response, @RequestParam Integer roleid,@RequestParam String  status) {

        Response<String> responses = new Response<>();


        try {
            Assert.hasText(roleid.toString(), "roleid  is null or 空字符串。");
            Assert.hasText(status, "status  is null or 空字符串。");
            logger.info("UPDATERoleStatus request Param :{}", roleid.toString());
            logger.info("UPDATERoleStatus request Param :{}", status);
            Boolean flag = super.execute(request, response);
            if (flag) {
                if (roleid!=null && StringUtils.isNotBlank(status)) {
                    roleService.updateRoleStatus(roleid,status);
                    responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                }else {
                    responses.setErrorCode(Constant.errorCodeEnum.PARAM_ERROR.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.PARAM_ERROR.getName());
                }
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

    @Override
    public String getAuthorityId() {
        return AuthorityKey.ROLE_MANAGER;
    }
}
