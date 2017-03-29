package com.ghprint.cms.common;

/**
 * 权限定义
 * 
 * @author fenglei
 * 
 */
public class AuthorityKey {

	// 更新角色状态
	public static final String ROLE_MANAGER = "110000000";

	// 角色查询
	public static final String ROLE_QUERY = "110000004";

	// 角色添加
	public static final String ROLE_ADD = "110000001";

	// 角色修改
	public static final String ROLE_MODIFY = "110000002";

	// 角色删除
	public static final String ROLE_DEL = "110000003";

	// 人员修改
	public static final String USER_MODIFY = "110000007";

	// 人员删除
	public static final String USER_DEL = "110000008";

	// 人员添加
	public static final String USER_ADD = "110000006";

	// 人员查询
	public static final String USER_QUERY = "110000009";

	/**
	 * 生产质量标准修改
	 */
	public static String PRODUCTION_UPDATE= "120000004";

	/**
	 * 生产质量标准删除
	 */
	public static String PRODUCTION_DELETE = "120000003";
	/**
	 * 生产标准查询
	 */
	public static String PRODUCTION_SELECT = "120000002";

	/*
	* 生产标准增加
	* */
	public  static  String PRODUCTION_ADD="120000001";

	/*
	* 成品库存新增
	* */
	public  static  String PROSTOCKS_ADD="130000001";
	/*
	* 成品库存删除
	* */
	public  static  String PROSTOCKS_DEL="130000002";
	/*
	* 成品库存修改
	* */
	public  static  String PROSTOCKS_UPDATE="130000003";
	/*
	* 成品库存查询
	* */
	public  static  String PROSTOCKS_SELECT="130000004";
}
