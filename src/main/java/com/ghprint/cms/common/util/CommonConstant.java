package com.ghprint.cms.common.util;

public class CommonConstant {
	/**
	 * 
	 */
	public static final String COMMON_PATH = "common";

	public static final String UPLOAD_PATH = "upload";


	/**
	 * 每页显示数目
	 */
	public static final Integer PAGE_SIZE = 10;

	/**
	 * 常量0
	 */
	public static final Integer CONST_ZERO = 0;

	/**
	 * 常量1
	 */
	public static final Integer CONST_ONE = 1;

	/**
	 * 常量success
	 */
	public static final String SUCCESS = "success";

	/**
	 * 常量100000
	 */
	public static final Integer CONST_100K = 100000;

	/**
	 * 字段有效状态
	 */
	public static final String VALID_STATE = "S0A";

	/**
	 * 字段冻结状态
	 */
	public static final String VALID_STATE_S0F = "S0F";

	/**
	 * 逗号
	 */
	public static final String STRING_COMMA = ",";

	/**
	 * 操作成功
	 */
	public static final String OPERATE_SUCCESS = "操作成功";

	/**
	 * 
	 */
	public static final String FAIL_RESULT = "failMsg";

	/**
	 * 验证码保存在session中的属性名
	 */
	public static final String LOGIN_VERIFY_CODE = "LOGIN_VERIFY_CODE";


	/**
	 * 图片文件
	 */
	public static final String EXT_PIC = "bmp,jpg,jpeg,gif,png";

	/**
	 * 返利活动图片上传路径
	 */
	public static final String MRA_UPLOAD_PATH = ConfigReader.readConfig(UPLOAD_PATH, "MRA_UPLOAD_PATH");

	/**
	 * 返利活动图片映射路径
	 */
	public static final String MRA_IMG_PATH = ConfigReader.readConfig(UPLOAD_PATH, "MRA_IMG_PATH");

	/**
	 * fastdfs访问路径
	 */
	public static final String FASTDFS_WEB_URL = ConfigReader.readConfig(COMMON_PATH, "FASTDFS_WEB_URL");

	/**
	 * 非法字符
	 */
	public static final int ILLEGAL_CHARACTERS=999;


	/**
	 * 通用状态
	 */
	public static final String STATUS = "status";
	public static final String STATUS_FAIL = "2";// 非正常
	public static final String STATUS_NORMAL = "1";// 正常


}
