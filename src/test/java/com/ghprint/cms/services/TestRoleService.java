package com.ghprint.cms.services;

import com.ghprint.cms.model.sys.TSysRole;
import com.ghprint.cms.pagination.DataGridResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lenovo on 2017/1/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestRoleService {

    @Autowired
    private RoleService roleService;

    @Test
    public void testgetRolelist() throws Exception {
        DataGridResult dataresult = new DataGridResult();
        TSysRole role = new TSysRole();
        dataresult = roleService.getRoleList(role,1,3);
        System.out.print(dataresult.getRows().get(0));
    }


}
