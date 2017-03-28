package com.ghprint.cms.services;

import cn.com.bestpay.Response;
import com.ghprint.cms.model.sys.RoleInfoView;
import com.ghprint.cms.model.sys.TSysRole;
import com.ghprint.cms.pagination.DataGridResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;

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
        role.setRolename("操作员");
        dataresult = roleService.getRoleList(role,1,1);
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
        Integer roleid = 13;
        Response< String > response = new Response<>();
       response = roleService.deleteRoleInfo(roleid);
    }


    @Test
    public void testgetPrivilege() throws  Exception{
       List list =  roleService.queryPrivilege();
        Iterator iter = list.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }

    @Test
    public  void testqueryRole() throws  Exception{
        RoleInfoView roleInfoView = roleService.queryRole(1);
        System.out.print(roleInfoView);
    }

    @Test
    public  void testqueryPrivilege()throws Exception{

       List list =  roleService.queryPrivilege(1000);
        Iterator iter = list.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }

    @Test
    public  void testupdateRoleStatus()throws  Exception{
        roleService.updateRoleStatus(1,"1");
    }

    @Test
    public void testqueryRoleUserd()throws  Exception{
       System.out.print( roleService.queryRoleUserd(2));
    }

    @Test
    public  void testeditRole()throws  Exception{
        TSysRole role = new TSysRole();
        RoleInfoView roleInfoView = roleService.queryRole(1);
        role.setId(1);
        role.setRoleid(String.valueOf(roleInfoView.getRoleId()));
        role.setRolename("房管1");
        role.setRoledesc(roleInfoView.getDescription());
        role.setRolestatus(String.valueOf(roleInfoView.getRoleStatus()));
        String[] strArray={"150000007","150000009","150000011"};
        roleService.editRole(role,strArray);
    }


}
