package com.ghprint.cms.controller.biz.Role;

import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.model.sys.GradePrivilegeView;
import com.ghprint.cms.services.RoleService;
import com.ghprint.cms.utils.Constant;
import com.ghprint.cms.utils.Response;
import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lenovo on 2017/1/16.
 */
@Controller
public class AddPreRoleController  extends BaseAction {
    private  static Logger logger = LoggerFactory.getLogger(AddPreRoleController.class);

    @Autowired
    private RoleService roleService ;

    @RequestMapping(value = "/roleinfo/addpreroleinfo.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    //@ApiOperation(value = "加载添加角色")
    public Response<List> addpreroleinfo (HttpServletRequest request, HttpServletResponse response){

        Response <List> responses = new Response<>();

        logger.info("enter into execute of AddPreRoleAction ");
        // 获取权限列表
        try {
            Boolean flag = super.execute(request, response);
            if (flag) {
            List <GradePrivilegeView>list = roleService.queryPrivilege();
                responses.setErrorCode(Constant.errorCodeEnum.SUCCESS.getCode());
                responses.setErrorMsg(Constant.errorCodeEnum.SUCCESS.getName());
                responses.setResult(list.get(0).getPrivilegeList());
                return  responses;
            } else {
                responses.setErrorCode(Constant.errorCodeEnum.LOGIN_TIMEOUT_ERROE.getCode());
                responses.setErrorMsg(request.getAttribute("message").toString());
                return responses;
            }
        } catch (Exception e) {
            logger.error("添加角色初始化失败=:", e);
            responses.setErrorCode(Constant.errorCodeEnum.FAILURE.getCode());
            responses.setErrorMsg("添加角色初始化失败");
            return  responses;
        }
    }

    @Override
    public String getAuthorityId() {
        return AuthorityKey.ROLE_ADD;
    }
}
