package com.ghprint.cms.controller.biz;

import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.model.sys.TSysRole;
import com.ghprint.cms.services.RoleService;
import com.ghprint.cms.utils.Constant;
import com.wordnik.swagger.annotations.ApiOperation;
import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import com.ghprint.cms.utils.Response;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lenovo on 2017/1/12.
 */
public class DeleteRoleController  extends BaseAction{

    private static Logger logger =  org.slf4j.LoggerFactory.getLogger(DeleteRoleController.class);

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/roleinfo/deleteroleinfo.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    @ApiOperation(value = "删除角色")
    public Response<String> deleteRoleinfo(HttpServletRequest request, HttpServletResponse response, @RequestParam String roleid){
        Response <String> responses = new Response<>();
        Assert.hasText(roleid, "roleid  is null or 空字符串。");
        logger.info("enter into execute of DelRoleAction ");
        try {
            Boolean flag = super.execute(request, response);

            logger.info("delete roleinfo request Param:{}",roleid);
            if (flag) {



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

        return responses;
    }

    @Override
    public String getAuthorityId() {
        return AuthorityKey.ROLE_DEL;
    }
}
