package com.ghprint.cms.controller.biz.Role;

import cn.com.bestpay.Response;
import com.ghprint.cms.common.AuthorityKey;
import com.ghprint.cms.controller.BaseAction;
import com.ghprint.cms.services.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lenovo on 2017/1/14.
 */
public class UpdateRoleController extends BaseAction {

    private  static Logger logger = LoggerFactory.getLogger(UpdateRoleController.class);

    @Autowired
    private RoleService roleService;







    @Override
    public String getAuthorityId() {
        return AuthorityKey.ROLE_MODIFY;
    }
}
