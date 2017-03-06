package com.ghprint.cms.controller.biz.Role;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.model.sys.TSysRole;
import com.ghprint.cms.services.RoleService;
import com.ghprint.cms.utils.Constant;
import com.wordnik.swagger.annotations.ApiOperation;
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

/**
 * Created by lenovo on 2017/1/14.
 */
@Controller
public class UpdateRoleController extends BaseAction {

    private  static Logger logger = LoggerFactory.getLogger(UpdateRoleController.class);

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/roleinfo/updateroleinfo.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    @ApiOperation(value = "更新角色")
    public Response<String> updateroleinfo (HttpServletRequest request, HttpServletResponse response,  TSysRole role, String ids[]) {

        Response<String> responses = new Response<>();

        Assert.hasText(role.getRolename(), "role 中 rolename  is null or 空字符串。");
        Assert.hasText(role.getRoledesc(), "role 中 roledesc  is null or 空字符串。");
        logger.info("UPDATERoleinfo request Param :{}", role);
        logger.info("UPDATERoleinfo request Param :{}", ids);
        try {
            Boolean flag = super.execute(request, response);
            if (flag) {
                if (ids.length > 0) {
                    roleService.editRole(role,ids);
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
        return AuthorityKey.ROLE_MODIFY;
    }
}
