package com.ghprint.cms.services;

import com.ghprint.cms.model.sys.OperateRoleInfo;
import com.ghprint.cms.model.sys.OperatorInfoView;
import com.ghprint.cms.model.sys.TSysUser;
import com.ghprint.cms.pagination.DataGridResult;

import java.util.List;

/**
 * Created by lenovo on 2017/1/7.
 */
public interface UserService {

    /**
     *
     * @Title: selectByAccount
     * @Description: 根据帐号查询用户
     * @param account
     * @return User
     * @throws
     */
    TSysUser selectByAccount(String account);



    /**
     *
     * @Title: selectAllUser
     * @Description: 查询所有用户
     * @return User
     * @throws
     */
    List<TSysUser> selectAllUser(String order);

    /**
     *
     * @Title: selectByParam
     * @Description: 根据查询条件查询用户信息
     * @param user
     * @param user
     * @return String
     * @throws
     */
    DataGridResult selectByParam(TSysUser user,  Integer page , Integer rows);

    /**
     *
     * @Title: addUser
     * @Description: 新增用户
     * @param user
     * @return void
     * @throws
     */
    int addUser(TSysUser user);

    /**
     *
     * @Title: checkUserAccount
     * @Description: 检查用户帐号是否存在
     * @param account
     * @return int
     * @throws
     */
    String checkUserAccount(String account);

    /**
     *
     * @Title: getUserDetail
     * @Description: 获取用户详细信息
     * @param userId
     * @return User
     * @throws
     */
    String getUserDetail(String userId);

    /**
     *
     * @Title: updateUser
     * @Description: 修改用户信息
     * @param user
     * @return void
     * @throws
     */
    void updateUser(TSysUser user);

    /**
     *
     * @Title: updateUserStat
     * @Description: 修改用户状态
     * @param users
     * @param stat
     * @return void
     * @throws
     */
    void updateUserStat(String users, String stat);

    /**
     *
     * @Title: deleteUser
     * @Description: 删除用户
     * @param userId
     * @return void
     * @throws
     */
    int deleteUser(Integer userId);

    /**
     *
     * @Title: getRoleName
     * @Description: 根据用户名获取角色名称
     * @param @param userId
     * @return void
     * @author Tangyinbo
     * @throws
     */
    String getRoleName(String userId);

    /**
     *
     * @Title: updateUserInfo
     * @Description: 修改个人基本信息
     * @param user
     * @return void
     * @author wjy
     * @throws
     */
    void updateUserInfo(TSysUser user);

    /**
     *
     * @Title: updateUserInfo
     * @Description: 修改个人密码
     * @param userId
     * @param oldPassword
     * @param newPassword
     * @return void
     * @author wjy
     * @throws
     */
    String updateUserPwd(String userId, String oldPassword, String newPassword);

    /**
     *
     * @Title: checkRoleStat
     * @Description: 检查所选的用户所属角色的状态
     * @param users
     * @return Integer
     * @author wjy
     * @throws
     */
    Integer checkRoleStat(String users);

    /**
     *
     * @Title: resetPwd
     * @Description: 重置密码
     * @param user
     * @author wjy
     * @throws
     */
    void resetPwd(TSysUser  user);



    /**
     *
     * @Title:
     * @Description: 登录服务
     * @param account
     * @author wjy
     * @throws
     */
    OperatorInfoView login (String account);

    //获取角色
    List getRolelist();

    //查询用户明细
    List  getUserinfo(Integer userid);

    //授予角色
    void updateRoleinfo(Integer userid , Integer roleid);

    //修改密码

}
