package com.ghprint.cms.services;


import com.alibaba.fastjson.JSON;
import com.ghprint.cms.common.entity.PageData;
import com.ghprint.cms.common.util.DictionaryConstant;
import com.ghprint.cms.common.util.ToolUtils;
import com.ghprint.cms.dao.sys.UserDao;
import com.ghprint.cms.model.sys.*;
import com.ghprint.cms.pagination.Page;
import com.ghprint.cms.pagination.PageParameter;
import com.ghprint.cms.serviceDao.*;
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
    public List<TSysUser> selectAllUser(String order) {
        return userDao.selectAllUser(order);
    }

    @Override
    public String selectByParam(TSysUser user, String page) {
        PageData<TSysUser> pageList = new PageData<TSysUser>();
        PageParameter parameter = new PageParameter();
        parameter.setCurrentPage(Integer.parseInt(page));
        Page<TSysUser> p = new Page<TSysUser>(parameter);
        p.setEntity(user);
        pageList.setRows(userDao.selectByParam(p));
        pageList.setTotal(p.getPage().getTotalCount());
        return JSON.toJSONString(pageList);
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
    public int deleteUser(String users) {
        List<String> userIds = ToolUtils.getByStringNonRepeat(users, ";");
        return userDao.deleteUser(userIds);
        /*userDao.deleteUserRole(userIds);*/
    }

    @Override
    public String getRoleName(String userId) {
        return userDao.getRoleName(userId);
    }

    @Override
    public void updateUserInfo(TSysUser user) {
        userDao.updateUser(user);
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
    public void resetPwd(String users) {

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






    }
