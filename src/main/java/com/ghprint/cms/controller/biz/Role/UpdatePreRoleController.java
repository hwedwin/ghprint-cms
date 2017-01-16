package com.ghprint.cms.controller.biz.Role;

import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.model.sys.RoleInfoView;
import com.ghprint.cms.services.RoleService;
import com.ghprint.cms.utils.Constant;
import com.ghprint.cms.utils.Response;
import com.wordnik.swagger.annotations.ApiOperation;
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
 * Created by lenovo on 2017/1/16.
 */
@Controller
public class UpdatePreRoleController extends BaseAction {

    private static Logger logger = LoggerFactory.getLogger(UpdatePreRoleController.class);

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/roleinfo/editpreroleinfo.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    @ApiOperation(value = "加载编辑角色")
    public Response<RoleInfoView> editpreroleinfo(HttpServletRequest request, HttpServletResponse response, @RequestParam Integer roleid) {
        logger.info("enter into execute of EditPreRoleAction ");
        Response<RoleInfoView> responses = new Response<>();
        Assert.hasText(roleid.toString(), "roleid  is null or 空字符串。");
        logger.info("EditPreRoleinfo request Param :{}", roleid);
        try {
            Boolean flag = super.execute(request, response);
            if (flag) {
                if (roleid == null || roleid.equals("")) {
                    logger.error("roleid id is null");
                    responses.setErrorCode(Constant.errorCodeEnum.PARAM_ERROR.getCode());
                    responses.setErrorMsg(Constant.errorCodeEnum.PARAM_ERROR.getName());
                    return responses;
                }
                //查询role信息
                RoleInfoView roleInfoView = roleService.queryRole(roleid);
                responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                responses.setResult(roleInfoView);
                return responses;
            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception ex) {
            logger.error("系统异常  error: " + ex);
            responses.setErrorCode(Constant.errorCodeEnum.SYSTEM_ERROR.getCode());
            responses.setErrorMsg("编辑角色初始化失败:"+ex.getMessage());
            return responses;
        }

    }


    @Override
    public String getAuthorityId() {
        return AuthorityKey.ROLE_MODIFY;
    }
}
