package com.ghprint.cms.dao.sys;
import com.ghprint.cms.dao.BaseDaoImp;
import com.ghprint.cms.model.sys.TSysUser;
import com.ghprint.cms.pagination.Page;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName: UserDaoImpl
 * @Description:
 * @author wjy
 * @date 2013-11-19 下午3:48:58
 * 
 */
@Repository
public class UserDaoImpl extends BaseDaoImp<TSysUser, String> implements UserDao {


	public UserDaoImpl() {
		super("com.ghprint.cms.serviceDao.TSysUserMapper");
	}

	@Override
	public TSysUser selectByAccount(String account) {
		TSysUser user = this.get("selectByAccount", account);
		return user;
	}


	@Override
	public List<TSysUser> selectAllUser(String order){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderString", order);
		List<TSysUser> user = this.select("selectAllUser",map);
		return user;
	}

	@Override
	public List<TSysUser> selectByParam(Page<TSysUser> p) {
		return this.selectPage("selectByParamByPage", p);
	}

	@Override
	public int addUser(TSysUser user) {
		return this.insert(user);
	}


	@Override
	public int selectCount(String account) {
		return this.count("checkUserAccount", account);
	}

	@Override
	public TSysUser getUserDetail(String userId) {
		return this.get("getUserDetail", userId);
	}

	@Override
	public void updateUser(TSysUser user) {
		this.update(user);
	}

	@Override
	public void updateUserStat(Map<String, Object> map) {
		this.update("updateUserStat", map);
	}

	@Override
	public int deleteUser(List<String> userIds) {
		return this.sessionTemplate.delete(this.spaceName + ".delete", userIds);
	}

	@Override
	public void deleteUserRole(List<String> userIds) {
		this.sessionTemplate
				.delete(this.spaceName + ".deleteUserRole", userIds);
	}

	@Override
	public String getRoleName(String userId) {
		return this.sessionTemplate.selectOne(this.spaceName
				+ ".selectRoleName", userId);
	}

	@Override
	public String getUserPwd(String userId) {
		return this.sessionTemplate.selectOne(this.spaceName + ".getUserPwd",
				userId);
	}

	@Override
	public Integer checkRoleStat(List<String> userIds) {
		return (Integer) this.sessionTemplate.selectOne(this.spaceName
				+ ".checkRoleStat", userIds);
	}

	@Override
	public void resetPwd(Map<String, Object> map) {
		this.sessionTemplate.update(this.spaceName+".resetPwd", map);
	}

}
