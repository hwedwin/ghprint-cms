package com.ghprint.cms.common;

/**
 * 权限定义
 * 
 * @author fenglei
 * 
 */
public class AuthorityKey {

	// 角色查询
	public static final String ROLE_QUERY = "110000004,120000004,140000007";

	// 角色添加
	public static final String ROLE_ADD = "110000001,120000001,130000001";

	// 角色修改
	public static final String ROLE_MODIFY = "110000002,120000002,130000002";

	// 角色删除
	public static final String ROLE_DEL = "110000003,120000003,130000003";

	// 角色管理
	public static final String ROLE_MANAGER = "110000000,120000000,130000000";

	// 人员修改
	public static final String USER_MODIFY = "110000007,120000007,130000007";

	// 人员删除
	public static final String USER_DEL = "110000008,120000008,130000008";

	// 人员管理
	public static final String USER_MANAGER = "110000005,120000008,130000008";

	// 人员添加
	public static final String USER_ADD = "110000006,120000006,130000006";

	// 人员查询
	public static final String USER_QUERY = "110000009,120000009,130000009";

	// KMC管理
	public static final String KMC_MANAGER = "130000010";

	// KMC添加
	public static final String KMC_ADD = "130000011";

	// KMC删除
	public static final String KMC_DEL = "130000013";

	// CA停用
	public static final String CA_STOP = "130000025";

	// 导出模板文件
	public static final String TEMPLETFILE_EXPORT = "130000056";

	// 服务器CSR文件生成
	public static final String SERVERCSR_MAKE = "130000072";

	// CA管理
	public static final String CA_MANAGER = "130000020";

	// CA删除
	public static final String CA_DEL = "130000023";

	// RA添加
	public static final String RA_ADD = "130000031";

	// 添加模板策略
	public static final String TEMPLETSTRSTEGY_ADD = "130000053";

	// 添加CRL策略
	public static final String CELSTRSTEGY_ADD = "130000062";

	// 证书统计
	public static final String CERT_STAT = "130000070";

	// 归档证书
	public static final String CERT_ARCHIVE = "130000071";

	// 服务器证书申请
	public static final String CERVERCERT_APPLY = "130000073";

	// 启用模板策略
	public static final String TEMPLETSTRSTEGY_START = "130000054";

	// RA启用
	public static final String RA_START = "130000036";

	// 冻结RA管理员
	public static final String RAADMINISTERTOR_FREEZE = "130000039";

	// 停用模板策略
	public static final String TEMPLETSTRSTEGY_STOP = "130000055";

	// 解冻RA管理员
	public static final String RAADMINISTERTOR_THAW = "130000040";

	// CA添加
	public static final String CA_ADD = "130000021";

	// CA查询
	public static final String CA_QUERY = "130000024";

	// RA管理
	public static final String RA_MANAGER = "130000030";

	// RA修改
	public static final String RA_MODIFY = "130000032";

	// RA停用
	public static final String RA_STOP = "130000035";

	// 查询RA管理员
	public static final String RAADMINISTERTOR_QUERY = "130000037";

	// 吊销RA管理员
	public static final String RAADMINISTERTOR_REVOKE = "130000038";

	// 添加RA人员信息
	public static final String RAADMINISTERTOR_ADD = "130000042";

	// 修改RA人员信息
	public static final String RAADMINISTERTOR_MOD = "130000043";

	// CRL策略管理
	public static final String CRLSTRSTEGY_MANAGER = "130000061";

	// KMC启用
	public static final String KMC_START = "130000016";

	// RA查询
	public static final String RA_QUERY = "130000034";

	// 模板策略管理
	public static final String TEMPLETSTRSTEGY_MANAGER = "130000052";

	// KMC查询
	public static final String KMC_QUERY = "130000014";

	// KMC停用
	public static final String KMC_STOP = "130000015";
	// 查询KMC管理员
	public static final String KMCADMINISTERTOR_QUERY = "130000017";

	// 吊销KMC管理员
	public static final String KMCADMINISTERTOR_REVOKE = "130000018";

	// 添加KMC人员信息
	public static final String KMCADMINISTERTOR_ADD = "130000019";

	// 修改KMC人员信息
	public static final String KMCADMINISTERTOR_MOD = "130000120";

	// CA启用
	public static final String CA_START = "130000026";

	// 制作证书模板
	public static final String CERTTEMPLET_MAKE = "130000051";

	// 修改CRL策略
	public static final String CRLSTRSTEGY_MODIFY = "130000063";

	// KMC修改
	public static final String KMC_MODIFY = "130000012";

	// CA修改
	public static final String CA_MODIFY = "130000022";

	// RA删除
	public static final String RA_DEL = "130000033";
	// 证书统计
	public static final String CA_STATIC_CERT = "140000000";
	// RA业务统计
	public static final String CA_STATIC_BUSINESS = "140000001";

	// 密钥业务统计
	public static final String CA_STATIC_KEY = "140000002";
	// /**
	// * 管理员组的查询
	// */
	// public static final String QUERY_OPERATOR_GROUP = "140000003";
	// /**
	// * 管理员组的添加
	// */
	// public static final String ADD_OPERATOR_GROUP = "140000004";
	// /**
	// * 管理员组的删除
	// */
	// public static final String DELETE_GROUP = "140000005";

	public static String DEPLOY_CRL = "140000005";
	/**
	 * 配置ldap
	 */
	public static String CONFIG_LDAP = "140000006";

	/** 修改服务端口 * */
	public static final String MODIFY_SERVER_PORT = "130000101";

	/** 修改数据源配置 * */
	public static final String MODIFY_DATASOURCE_CONFIG = "130000104";

	/** 重启服务 * */
	public static final String RESTART_SERVER = "130000103";
	// 删除加密机配置
	public static final String ENCRYPTIONMACHINECONFIG_DEL = "140000007";
	// 加密机配置查询
	public static final String ENCRYPTIONMACHINECONFIG_QUERY = "140000008";
	// 添加加密机配置
	public static final String ENCRYPTIONMACHINECONFIG_ADD = "140000009";

	public static final String ENCRYPTIONMACHINECONFIG_MODIFY = "140000010";

	/**
	 * 数据备份
	 */
	public static final String DATA_BACKUP = "130000085";

	/**
	 * 数据恢复
	 */
	public static final String DATA_RECOVER = "130000086";
	/**
	 * 手工发布证书
	 */
	public static String DEPLOYCERT = "140000011";

	/**
	 * 审计日志
	 */
	public static String AUDIT_LOG = "140000007";
	/**
	 * 生产标准查询
	 */
	public static String PRODUCTION_SELECT = "120000002";

	/*
	* 生产标准增加
	* */
	public  static  String PRODUCTION_ADD="120000001";
}
