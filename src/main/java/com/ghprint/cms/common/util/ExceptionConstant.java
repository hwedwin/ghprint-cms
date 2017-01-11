package com.ghprint.cms.common.util;

public class ExceptionConstant {

	/********************* BEGIN 渠道管理 ********************/
	/**
	 * 已存在相同名字的渠道
	 */
	public static final String SAME_CHANNEL_NAME = "已存在相同名字的渠道";

	public static final String QUERY_CHANNEL_FAIL = "查询渠道类型失败";

	public static final String INSERT_CHANNLE_FAIL = "新增渠道失败";

	public static final String DELETE_CHANNLE_FAIL = "删除渠道失败";

	public static final String UPDATE_CHANNLE_FAIL = "修改渠道失败";

	public static final String COMMON_FAIL = "fail";

	public static final String WORKBOOK_DATA_NULL = "生成workbook的数据不能为空";

	public static final String DELETE_EXCEPTION = "请确认是否还有子渠道未删除";

	public static final String QUERY_TREE_FAIL = "查询树异常";

	public static final String GENERATE_CODE_FAIL = "生成渠道编号失败";
	/********************* END 渠道管理 ********************/

	/********************* BEGIN 群组管理 ********************/
	public static final String QUERY_GROUP_FAIL = "获取群组列表失败";

	public static final String QUERY_GROUP_USER = "获取账号关联群组的信息失败";

	public static final String ADD_GROUP_FAIL = "添加群组[有excel上传]失败";

	public static final String ADD_GROUP_NOFILEFAIL = "添加群组[无excel上传]失败";

	public static final String VALID_GROUP_NAMEFAIL = "验证群组名称是否存在失败";

	public static final String ADD_GROUP_USERFAIL = "给指定的群组添加账号[有excel上传]失败";

	public static final String ADD_GROUP_USEREMPTY = "上传的excel没有合法的用户账号";

	public static final String ADD_GROUP_USERNOFILE = "给指定的群组添加账号[无excel上传]失败";

	public static final String QUERT_GROUP_DETAIL = "获取群组详细信息失败";

	public static final String ALTER_GROUP_FAIL = "修改群组[有excel上传]失败";

	public static final String ALTER_GROUP_NOFILEFAIL = "修改群组[无excel上传]失败";

	public static final String DELETE_GROUP_USER = "删除账号群组关联失败";

	public static final String INVALID_GROUP_USER = "账号在群组中置无效失败";

	public static final String VALID_GROUP_USER = "账号在群组中恢复有效失败";

	public static final String DELETE_GROUP_FAIL = "删除群组失败";

	public static final String EXPORT_GROUP_FAIL = "导出群组[关联信息]excel文档失败";

	public static final String IMPORT_GROUP_FAIL = "导入群组账号[获取导入的excel文件的数据]失败";
	/********************* END 群组管理 ********************/

	/********************* BEGIN 用户管理 ********************/
	public static final String SAME_USER_ACCOUNT = "帐号已存在";

	public static final String VALID_USER_ACCOUNT_FAIL = "检查用户帐号失败";

	public static final String QUERY_USER_FAIL = "查询用户失败";

	public static final String QUERY_USER_DETAIL_FAIL = "查询用户详细信息失败";

	public static final String INSERT_USER_FAIL = "新增用户失败";

	public static final String DELETE_USER_FAIL = "删除用户失败";

	public static final String UPDATE_USER_FAIL = "修改用户失败";

	public static final String UPDATE_USER_STAT_FAIL = "修改用户状态失败";

	public static final String UPDATE_USER_INFO_FAIL = "修改个人基本信息失败";

	public static final String USER_PWD_NOTEQUALS = "原密码错误";

	public static final String UPDATE_USER_PWD_FAIL = "修改密码失败";

	public static final String RESET_PWD_FAIL = "重置密码失败";
	/********************* END 用户管理 ********************/

	/********************* BEGIN 角色管理 ********************/
	public static final String SAME_ROLE_NAME = "角色名称已存在";

	public static final String VALID_ROLE_NAME_FAIL = "检查角色名称失败";

	public static final String QUERY_ROLE_DETAIL_FAIL = "查询角色详细信息失败";

	public static final String QUERY_ROLE_FAIL = "查询角色失败";

	public static final String INSERT_ROLE_FAIL = "新增角色失败";

	public static final String DELETE_ROLE_FAIL = "删除角色失败";

	public static final String UPDATE_ROLE_FAIL = "修改角色失败";

	public static final String UPDATE_ROLE_STAT_FAIL = "修改状态失败";

	/********************* END 角色管理 ********************/

	/********************* BEGIN 权限管理 ********************/
	public static final String QUERY_PRIV_DETAIL_FAIL = "查询权限详细信息失败";

	public static final String QUERY_PRIV_FAIL = "查询权限失败";

	public static final String INSERT_PRIV_FAIL = "新增权限失败";

	public static final String DELETE_PRIV_FAIL = "删除权限失败";

	public static final String UPDATE_PRIV_FAIL = "修改权限失败";

	public static final String QUERY_PRIV_TREE_FAIL = "获取权限树失败";
	/********************* END 权限管理 ********************/
	/********************* BEGIN 日志管理 ********************/
	public static final String QUERY_LOGS_FAIL = "查询日志列表失败";

	public static final String INSERT_LOGS_FAIL = "插入日志失败";

	public static final String EXPORT_LOGS_FAIL = "导出日志失败";

	/********************* END 日志管理 ********************/
	/********************* BEGIN广告管理 ********************/
	public static final String QUERY_ADVERTISE_LIST = "查询广告信息失败";
	public static final String QUERY_ADVERTISE_CONFIG_FAIL = "查询广告配置信息失败";
	public static final String UPDATE_ADVERTISE_CONFIG_FAIL = "修改广告配置信息失败";
	public static final String DELETE_ADVERTISE_CONFIG_FAIL = "删除广告失败";
	public static final String UPDATE_ADVERTISE_FAIL = "修改广告信息失败";
	public static final String IMAGE_UPLOAD_FAIL = "图片上传失败";
	public static final String QUERY_ADVERTISE_DETAIL_FAIL = "查询广告明细失败";
	public static final String CHECK_APP_ADVERTISE_EXISTS_FAIL = "检查所选应用是否存在广告";
	public static final String SAVE_ADVERTISE_FAIL = "新增广告失败";
	/********************* END广告管理 ********************/
	/********************* BEGIN广告动态配置管理 ********************/
	public static final String QUERY_ADVERT_LIST = "查询广告信息失败";
	public static final String QUERY_ADVERT_CONFIG_FAIL = "查询广告配置信息失败";
	public static final String UPDATE_ADVERT_CONFIG_FAIL = "修改广告配置信息失败";
	public static final String DELETE_ADVERT_CONFIG_FAIL = "删除广告失败";
	public static final String UPDATE_ADVERT_FAIL = "修改广告信息失败";
	public static final String QUERY_ADVERT_DETAIL_FAIL = "查询广告明细失败";
	public static final String CHECK_APP_ADVERT_EXISTS_FAIL = "检查所选应用是否存在广告";
	public static final String SAVE_ADVERT_FAIL = "新增广告失败";
	public static final String ADVERT_GETRESCTIEM_ERRCODE = "010072";
	public static final String ADVERT_GETRESCTIEM_ERRCODE_MSG = "获取广告图片文件时间戳出错！";
	/********************* END广告管理 ********************/

	/********************* BEGIN理财产品开通状态 ********************/
	public static final String QUERY_MONEY_STATE = "查询理财产品开通状态失败";
	public static final String INSERT_MONEY_STATE_FAIL = "新增理财产品开通状态失败";
	public static final String UPDATE_MONEY_STATE_FAIL = "修改理财产品开通状态失败";
	/********************* END理财产品开通状态 ********************/

	/********************* BEGIN理财消息问题管理 ********************/
	public static final String QUERY_MONEY_QUESTION_FAIL = "查询理财消息问题失败";
	public static final String QUERY_MONEY_QUESTION_DETAIL_FAIL = "查询理财消息问题详情失败";
	public static final String INSERT_MONEY_QUESTION_FAIL = "新增理财消息问题失败";
	public static final String UPDATE_MONEY_QUESTION_FAIL = "修改理财消息问题失败";
	public static final String UPDATE_MONEY_QUESTION_STATE_FAIL = "修改理财消息问题状态失败";
	/********************* END理财消息问题管理 ********************/

	/********************* BEGIN活动返利管理 ********************/
	public static final String QUERY_ACT_FAIL = "查询活动信息失败";
	public static final String QUERY_ACT_AREA_FAIL = "获取区域树失败";
	public static final String QUERY_ACT_APP_FAIL = "获取应用信息失败";
	public static final String INSERT_ACT_FAIL = "新增活动失败";
	public static final String UPDATE_ACT_FAIL = "修改活动失败";
	public static final String QUERY_ACT_DETAIL_FAIL = "查询活动详情失败";
	public static final String ACT_SETINVAILD_FAIL = "置无效活动失败";
	public static final String ACT_SETSTOP_FAIL = "暂停活动失败";
	/********************* END活动返利管理 ********************/

	public static final String QUERY_ACTIONlOG_FAIL = "查询用户行为统计列表失败";
	public static final String EXPORT_ACTIONLOG_FAIL = "导出用户行为统计列表失败";

	/********************** BEGIN消息推送 *********************************/
	public static final String QUERY_MsgPush_FAIL = "查询消息推送失败";
	public static final String INSERT_PUSH_FAIL = "新增消息推送失败";
	public static final String DELETE_PUSH_FAIL = "删除推送消息失败";
	public static final String DETAIL_PUSH_FAIL = "查询推送消息明细失败";
	/********************** END消息推送 *********************************/

	/********************* BEGIN消息推送审核 add by wjy 20140319 ********************/
	public static final String QUERY_PUSH_AUDIT_FAIL = "查询消息推送失败";
	public static final String QUERY_PUSH_AUDIT_DETAIL_FAIL = "查询消息推送详情失败";
	public static final String PUSH_AUDIT_FAIL = "消息推送审核失败";
	/********************* BEGIN消息推送审核 ********************/

	/******************************** cmsStart ******************************************/
	public static final String ADD_HTML_FAIL = "添加静态页面失败";
	public static final String DELETE_HTML_FAIL = "删除静态页面失败";
	public static final String EDIT_HTML_FAIL = "修改静态页面失败";
	public static final String BAKUP_HTML_FAIL = "备份失败";
	public static final String ROLLBACK_HTML_FAIL = "回滚失败";
	public static final String UPLOAD_IMG_FAIL = "上传图片失败";
	public static final String UPLOAD_IMG_SUCCESS = "上传图片成功";
	/******************************** cmsEnd ******************************************/
	
	/******************************** cmsStart ******************************************/
	public static final String TERMINAL_CHECK_PLFM_CODE_ERROR = "系统版本号不能为空";
	public static final String TERMINAL_CHECK_PLFM_NAME_ERROR = "系统名称不能为空";
	public static final String TERMINAL_CHECK_PLFM_CODE_EXISTS = "该系统的该版本已经存在";
	public static final String TERMINAL_CHECK_TERMNAME_EXISTS = "手机品牌已经存在";
	/******************************** cmsEnd ******************************************/

	public static final String TERMINAL_ADDTERM_ERROR = "添加终端失败";

	public static final String TERMINAL_EDITTERM_ERROR = "修改终端失败";

	public static  final String TERMINAL_DELETETERM_ERROR="删除终端信息失败";

	public static final String TERMINAL_ADDCATEGORY_ERROR = "添加类别失败";

	public static final String TERMINAL_EDITCATEGORY_ERROR = "修改类别";
	
	
	
	
	
	
}
