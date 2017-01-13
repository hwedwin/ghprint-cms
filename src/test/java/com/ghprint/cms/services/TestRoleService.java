package com.ghprint.cms.services;

import cn.com.bestpay.Response;
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

    @Test
    public void testaddRoleinfo()throws  Exception{
        TSysRole role = new TSysRole();
        role.setRolename("测试管理员");
        role.setRoledesc("测试案例");
        role.setRolestatus("1");
        String[] strArray={"140000008","140000009","140000010"};
        roleService.addRoleInfo(role,strArray);
    }

    @Test
    public  void testdelRoleinfo()throws Exception{
        Integer roleid = 12;
        Response< String > response = new Response<>();
       response = roleService.deleteRoleInfo(roleid);
    }


}
