package com.ghprint.cms.dao.sys;




import com.ghprint.cms.dao.BaseDao;
import com.ghprint.cms.model.sys.TSysUser;
import com.ghprint.cms.pagination.Page;

import java.util.List;
import java.util.Map;

public interface UserDao extends BaseDao<TSysUser, String> {

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
	 * @param p
	 * @return List<User>
	 * @throws
	 */
	List<TSysUser> selectByParam(Page<TSysUser> p);

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
	int selectCount(String account);

	/**
	 *
	 * @Title: getUserDetail
	 * @Description: 获取用户详细信息
	 * @param userId
	 * @return User
	 * @throws
	 */
	TSysUser getUserDetail(String userId);

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
	 * @param map
	 * @return void
	 * @throws
	 */
	void updateUserStat(Map<String, Object> map);

	/**
	 *
	 * @Title: deleteUser
	 * @Description: 删除用户
	 * @param userIds
	 * @return void
	 * @throws
	 */
	int deleteUser(List<String> userIds);

	/**
	 *
	 * @Title: deleteUserRole
	 * @Description: 删除用户角色关系记录
	 * @param userIds
	 * @return void
	 * @throws
	 */
	void deleteUserRole(List<String> userIds);

	String getRoleName(String userId);

	/**
	 *
	 * @Title: getUserPwd
	 * @Description: 根据userId获取用户密码
	 * @param userId
	 * @return void
	 * @throws
	 */
	String getUserPwd(String userId);

	/**
	 *
	 * @Title: checkRoleStat
	 * @Description: 查所选的用户所属角色的状态
	 * @param userIds
	 * @return Integer
	 * @throws
	 */
	Integer checkRoleStat(List<String> userIds);

	/**
	 *
	 * @Title: resetPwd
	 * @Description: 重置密码
	 * @param map
	 * @return Integer
	 * @throws
	 */
	void resetPwd(Map<String, Object> map);
}
