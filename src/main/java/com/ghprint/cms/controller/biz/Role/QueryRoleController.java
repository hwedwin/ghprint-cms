package com.ghprint.cms.controller.biz.Role;

import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.model.sys.TSysRole;
import com.ghprint.cms.pagination.DataGridResult;
import com.ghprint.cms.services.RoleService;
import com.ghprint.cms.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lenovo on 2017/1/10.
 */
@Controller
public class QueryRoleController extends BaseAction {

    private static Logger logger = LoggerFactory.getLogger(QueryRoleController.class);

    @Autowired
    private RoleService roleService;


    @RequestMapping(value = "/roleinfo/queryrolelist.do", method = RequestMethod.GET)
    @ResponseBody
    public DataGridResult queryroleinfo(HttpServletRequest request, HttpServletResponse response, TSysRole role, Integer page, Integer rows) {
        // 检查参数
        DataGridResult dataGridResult = new DataGridResult();


        try {
            Assert.hasText(String.valueOf(page), "page  is null or 空字符串。");
            Assert.hasText(String.valueOf(rows), "rows  is null or 空字符串。");
            Boolean flag = super.execute(request, response);

            logger.info("queryrolelist request Param:{}", role);
            if (flag) {
                dataGridResult = roleService.getRoleList(role, page, rows);
                dataGridResult.setSuccess(Boolean.TRUE);
                return dataGridResult;
            } else {
                dataGridResult.setSuccess(Boolean.FALSE);
                dataGridResult.setMessage(request.getAttribute("message").toString());
                return dataGridResult;
            }
        } catch (IllegalArgumentException ex) {
            logger.info("参数错误  error: " + ex);
            dataGridResult.setSuccess(Boolean.FALSE);
            dataGridResult.setMessage(ex.getMessage());
            return dataGridResult;
        } catch (Exception e) {
            logger.error("系统异常  error: " + e);
            dataGridResult.setSuccess(Boolean.FALSE);
            dataGridResult.setMessage(Constant.errorCodeEnum.PARAM_ERROR.getName());
            return dataGridResult;
        }
    }

    @Override
    public String getAuthorityId() {
        return AuthorityKey.ROLE_QUERY;
    }
}
