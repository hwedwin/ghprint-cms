package com.ghprint.cms.services;

import com.ghprint.cms.model.sys.OperateRoleInfo;
import com.ghprint.cms.model.sys.OperatorInfoView;
import com.ghprint.cms.model.sys.RolePrivilegeInfo;
import com.ghprint.cms.model.sys.TSysUser;
import com.ghprint.cms.pagination.DataGridResult;
import com.ghprint.cms.serviceDao.LoginMapper;
import com.ghprint.cms.serviceDao.TSysRolePrivilegeMapper;
import com.ghprint.cms.serviceDao.TSysUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lenovo on 2017/1/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestUserService {

    @Autowired
    private UserService userService;

    @Test
    public void testAdd() throws Exception {
        TSysUser user = new TSysUser("test", "小李", "", "", "123456", new Date());
        userService.addUser(user,"2");
    }


    @Test
    public void testSelect() throws Exception {
        TSysUser user = userService.selectByAccount("zhangsan");
        System.out.print(user);
    }

    @Test
    public void testlogin() throws Exception {
        OperatorInfoView operatorInfoView = userService.login("zhangsan");
        System.out.print(operatorInfoView.getPrivilegeList());
    }

    @Test
    public void testLoginMapper() {
        //创建一个spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //从spring容器中获得Mapper的代理对象
        LoginMapper loginMapper = applicationContext.getBean(LoginMapper.class);
        TSysRolePrivilegeMapper tSysRolePrivilegeMapper = applicationContext.getBean(TSysRolePrivilegeMapper.class);
           List privilegeList = loginMapper.queryOperatroInfo("1");
//        TSysUser tSysUser  = tSysUserMapper.selectByPrimaryKey(1);
//        System.out.print(tSysUser);

        Iterator <OperateRoleInfo>iter = privilegeList.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        List prilist =tSysRolePrivilegeMapper.queryRoleList("200000");
        Iterator <RolePrivilegeInfo>iters = prilist.iterator();
        while (iters.hasNext()) {
            System.out.println(iters.next());
        }


    }



    @Test
    public void testselectByParam(){
        TSysUser user = new TSysUser();
        user.setUsername("test");
        DataGridResult dataGridResult =userService.selectByParam(user,1,3);
        System.out.print(dataGridResult.getRows().get(1));
    }

    @Test
    public void testdeluserinfo(){
       System.out.print(userService.deleteUser(3));
    }

    @Test
    public  void  testgetRolelist(){
       List list = userService.getRolelist();
        Iterator iter = list.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }


    @Test
    public  void testupdateRoleinfo(){
        userService.updateRoleinfo(2,1);
    }

    @Test
    public  void testresetPwd(){
        TSysUser user = new TSysUser();
        user.setId(2);
        user.setPassword("123456");
        userService.resetPwd(user);
    }

    @Test
    public void testupdateUserInfo(){
        TSysUser user = new TSysUser();
        user = userService.selectByUserId(2);
        user.setUsername("马云");
        userService.updateUserInfo(user);
    }

    @Test
    public void testgetUserinfo(){
        OperateRoleInfo operateRoleInfo = userService.getUserinfo(1);
        System.out.print(operateRoleInfo);
    }
}
