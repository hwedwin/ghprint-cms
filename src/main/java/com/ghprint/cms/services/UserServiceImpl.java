package com.ghprint.cms.services;


import com.alibaba.fastjson.JSON;
import com.ghprint.cms.common.algorithm.MD5Util;
import com.ghprint.cms.common.entity.PageData;
import com.ghprint.cms.common.util.DictionaryConstant;
import com.ghprint.cms.common.util.ToolUtils;
import com.ghprint.cms.dao.sys.UserDao;
import com.ghprint.cms.model.sys.*;
import com.ghprint.cms.pagination.DataGridResult;
import com.ghprint.cms.pagination.Page;
import com.ghprint.cms.pagination.PageParameter;
import com.ghprint.cms.serviceDao.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;
    @Autowired
    private TSysUserMapper tSysUserMapper;

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private TSysRolePrivilegeMapper tSysRolePrivilegeMapper;

    @Autowired
    private  TSysUserRoleMapper userRoleMapper;

    @Autowired
    private  TSysRoleMapper roleMapper;

    @Override
    public TSysUser selectByAccount(String account) {
        TSysUserExample tSysUserExample = new TSysUserExample();
        TSysUserExample.Criteria criteria = tSysUserExample.createCriteria();
        criteria.andUseridEqualTo(account);
        List<TSysUser> list = tSysUserMapper.selectByExample(tSysUserExample);
        if (list != null && list.size() > 0) {
            return (TSysUser) list.get(0);
        }
        return null;
    }

    @Override
    public TSysUser selectByUserId(Integer userid) {
        if(userid!= null){
           return tSysUserMapper.selectByPrimaryKey(userid);
        }
        return  null;
    }

    @Override
    public List<TSysUser> selectAllUser(String order) {
        return userDao.selectAllUser(order);
    }

    @Override
    public DataGridResult selectByParam(TSysUser user,  Integer page , Integer rows) {
        TSysUserExample userExample = new TSysUserExample();
        PageHelper.startPage(page, rows);
        List<TSysUser> userList = tSysUserMapper.selectByExample(userExample);
        DataGridResult dataGridResult = new DataGridResult();
        dataGridResult.setRows(userList);
        //取记录总条数
        PageInfo<TSysUser> pageInfo = new PageInfo<>(userList);

        dataGridResult.setCurrentPage(page);
        dataGridResult.setEveryPage(rows);
        dataGridResult.setTotalCount(pageInfo.getTotal());
        dataGridResult.setTotalPage(pageInfo.getPages());
        return dataGridResult;
    }

    @Override
    public int addUser(TSysUser user) {

        //	String password = encoder.encode(user.getPassword());
        //	user.setPassword(password);
        return userDao.addUser(user);
        //userDao.addUserRoleRelation(user);
    }


    @Override
    public String checkUserAccount(String account) {
        int count = userDao.selectCount(account);
        if (count > 0)
            return "exists";
        else
            return "notExists";
    }

    @Override
    public String getUserDetail(String userId) {
        return JSON.toJSONString(userDao.getUserDetail(userId));
    }

    @Override
    public void updateUser(TSysUser user) {
        userDao.updateUser(user);
        List<String> userIds = new ArrayList<String>();
        userIds.add(user.getUserid());
    }

    @Override
    public void updateUserStat(String users, String stat) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<String> userIds = ToolUtils.getByStringNonRepeat(users, ";");
        map.put("userIds", userIds);
        map.put("stat", stat);
        userDao.updateUserStat(map);
    }

    @Override
    public int deleteUser(Integer userId) {
        try {
            int  a=0;
          TSysUser user=  tSysUserMapper.selectByPrimaryKey(userId);
                    if(user == null){
                        log.info("没有符合条件的记录");
                        return  a;
                    }else{
                        tSysUserMapper.deleteByPrimaryKey(userId);
                        TSysUserRoleExample userRoleExample = new TSysUserRoleExample();
                        TSysUserRoleExample.Criteria criteria = userRoleExample.createCriteria();
                        criteria.andUseridEqualTo(String.valueOf(userId));
                        a =userRoleMapper.deleteByExample(userRoleExample);
                        return  a;
                    }

        }catch (Exception e){
            log.error("DeleUsers exception:");
            e.printStackTrace();
            return  0;
        }
    }

    @Override
    public String getRoleName(String userId) {
        return userDao.getRoleName(userId);
    }

    @Override
    public void updateUserInfo(TSysUser user) {
        if(user != null && user.getId()!=null){
            tSysUserMapper.updateByPrimaryKey(user);
        }
    }

    @Override
    public String updateUserPwd(String userId, String oldPassword,
                                String newPassword) {

        return null;
    }

    @Override
    public Integer checkRoleStat(String users) {
        List<String> userIds = ToolUtils.getByStringNonRepeat(users, ";");
        return userDao.checkRoleStat(userIds);
    }

    @Override
    public void resetPwd(TSysUser user) {
        TSysUser u = new TSysUser();
        u = tSysUserMapper.selectByPrimaryKey(user.getId());
        if(u!=null) {
            u.setPassword(MD5Util.getMD5String(user.getPassword()));
            tSysUserMapper.updateByPrimaryKey(u);
        }
    }

    @Override
    public OperatorInfoView login(String account) {
        OperatorInfoView operatorInfoView = new OperatorInfoView();
        TSysUserExample tSysUserExample = new TSysUserExample();
        TSysUserRoleExample userole = new TSysUserRoleExample();
        TSysUserExample.Criteria criteria = tSysUserExample.createCriteria();
        TSysUserRoleExample.Criteria rcriteria = userole.createCriteria();
        criteria.andUseridEqualTo(account);
        try {
            List<TSysUser> list = tSysUserMapper.selectByExample(tSysUserExample);
            if (list != null && list.size() > 0) {
                operatorInfoView.setUser(list.get(0));
                // 验签通过，获取权限及用户信息
                List lists = new ArrayList();
                List privilegeList = loginMapper.queryOperatroInfo(String.valueOf(operatorInfoView.getUser().getId()));
                if (privilegeList == null || privilegeList.isEmpty()) {
                    log.info("the operator's status is not common");
                } else {
                    for (int i = 0; i < privilegeList.size(); i++) {
                        OperateRoleInfo info1 = (OperateRoleInfo) privilegeList
                                .get(i);
                        if (info1.getRoleInfo().getRolestatus() != null
                                && !info1.getRoleInfo().getRolestatus().equals(
                                DictionaryConstant.STATUS_FAIL)) {
                            List prilist = tSysRolePrivilegeMapper.queryRoleList(info1.getRoleInfo().getRoleid());
                            if (prilist != null && prilist.size() > 0) {
                                for (int j = 0; j < prilist.size(); j++) {
                                    RolePrivilegeInfo infos = (RolePrivilegeInfo) prilist
                                            .get(j);
                                    ListNode node = new ListNode();
                                    node.setKey(String.valueOf(infos
                                            .getPrivilegeInfo().getPrivilegeid()));
                                    node.setValue(infos.getPrivilegeInfo()
                                            .getPrivilegename());
                                    lists.add(node);
                                    System.out.print(node);
                                }
                            }
                        }
                        operatorInfoView.setPrivilegeList(lists);
                    }

                }
            }
                return operatorInfoView;
            }catch(Exception e){
                log.error("登录失败：", e);

            }
            return null;
        }

    @Override
    public List getRolelist() {
        TSysRoleExample roleExample = new TSysRoleExample();
        List<TSysRole>  list = roleMapper.selectByExample(roleExample);
        return list;
    }

    @Override
    public List getUserinfo(Integer userid) {
        List  list = roleMapper.getRolelist(userid);
        return  list.isEmpty()?null:list;
    }

    @Override
    public void updateRoleinfo(Integer userid, Integer roleid) {
        if(userid!=null && roleid!=null) {
            TSysUserRoleExample userRoleExample = new TSysUserRoleExample();
            TSysUserRoleExample.Criteria criteria = userRoleExample.createCriteria();
            criteria.andUseridEqualTo(String.valueOf(userid));
            userRoleMapper.deleteByExample(userRoleExample);
            TSysUserRole userRole = new TSysUserRole();
            userRole.setUserid(String.valueOf(userid));
            userRole.setRoleid(String.valueOf(roleid));
            userRoleMapper.insert(userRole);
        }
    }


}
