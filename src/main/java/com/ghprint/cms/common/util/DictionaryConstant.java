package com.ghprint.cms.common.util;

/**
 * <p>
 * Title: DictionaryConstant
 * </p>
 * 
 * <p>
 * Description: 字典表常量类
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2009
 * </p>
 * 
 * <p>
 * Company: ccit
 * </p>
 * 
 * @author huchangqing
 * @version 1.0
 * @since Jun 13, 2009
 */
public class DictionaryConstant {

    /**
     * 通用状态
     */
    public static final String STATUS = "status";
    public static final String STATUS_FAIL = "2";// 非正常
    public static final String STATUS_NORMAL = "1";// 正常

    /**
     * 逻辑判断(通用状态)
     */
    public static final String JUDGE = "judge";

    /**
     * 审核类型
     */
    public static final String AUDITTYPE = "audittype";
    public static final int AUDITTYPE_SINGLE = 1; // 单级审核
    public static final int AUDITTYPE_MULTI = 2;// 多级审核

    /**
     * 证件类型
     */
    public static final String CARTTYPE = "cartType";
    public static final int CARTTYPE_ID_CARD = 1; // 身份证
    public static final int CARTTYPE_ARMY_CARD = 2;// 军官证
    public static final int CARTTYPE_PASSPORT = 3; // 护照
    public static final int CARTTYPE_SOLDIER_CARD = 4;// 士兵证
    public static final int CARTTYPE_DIPLOMATIC_CARD = 5; // 外交官证
    public static final int CARTTYPE_OFFICERS_CARD = 6;// 武警警官证
    public static final int CARTTYPE_OTHERS = 7; // 其他

    /**
     * 性别
     */
    public static final String GENDER = "gender";
    public static final int GENDER_MAIL = 1;// 男
    public static final int GENDER_FAMALE = 2; // 女

    /**
     * 密钥使用方式
     */
    public static final String KEYUSEWAY = "keyuserway";
    public static final int KEYUSERWAY_OLD = 1;// 原有密钥
    public static final int KEYUSERWAY_NEW = 2;// 新密钥

    /**
     * 密钥算法
     */
    public static final String KEYALGORITHM = "keyAlgorithm";

    /**
     * 密钥长度
     */
    public static final String KEYLENGTH = "keyLength";
    
    /**
     * ECC曲线号
     */
    public static final String CURVNUM = "curvNum";

    /**
     * 密钥保护类型
     */
    public static final String PROTECTTYPE = "protectType";
    /**
     * 数字信封
     */
    public static final String DIGITAL_ENVELOPE = "1";
    /**
     * 对称加密
     */
    public static final String SYMMETRIC_ENCRYPTION = "2";
    /**
     * 非对称加密
     */
    public static final String NON_SYMMETRIC_ENCRYPTION = "3";
    /**
     * 加密机主密钥加密
     */
    public static final String MACHINE_ENCRYPTION = "4";

    /**
     * 哈希算法
     */
    public static final String HASHALGORITHM = "hashAlgorithm";

    /**
     * 密钥产生方式
     */
    public static final String KEYHAVETYPE = "keyHaveType";

    /**
     * 审计结果
     */
    public static final String AUDIRESULT = "auditResult";

    /**
     * 申请类型
     */
    public static final String APPLYTYPE = "applyType";
    public static final int APPLY_CERT = 1;// 证书申请
    public static final int REVOKE_CERT = 2;// 证书作废
    public static final int REPLACE_CERT = 3;// 证书补发
    public static final int FREEZE_CERT = 4;// 证书冻结
    public static final int THAW_CERT = 5;// 证书解冻
    public static final int RESUME_KEY = 6;// 密钥恢复
    public static final int RESET_KEY = 7;// 重置密钥恢复码
    public static final int RENEWAL_CERT = 8;// 证书换发
    public static final int NETURAL_CERT = 9;// 证书自然到期更新
    public static final int SINGLE_TO_DOUBLE_CERT = 10;// 单证书变双证书

    /**
     * 业务类型
     */
    public static final String CERTBUSINESSTYPE = "certBusinessType";
    /**
     * 监控通知方式
     */
    public static final String MONITORNOTICETYPE = "monitorNoticeType";
    /**
     * 证书申请
     */
    public static final String CERTBUSINESSTYPE_APPLY = "1";
    /**
     * 下载证书
     */
    public static final String CERTBUSINESSTYPE_DOWNLOAD = "2";
    /**
     * 证书撤消
     */
    public static final String CERTBUSINESSTYPE_CANCLE = "3";
    /**
     * 证书更新
     */
    public static final String CERTBUSINESSTYPE_CERT_UPDATW = "4";
    /**
     * 证书查询
     */
    public static final String CERTBUSINESSTYPE_CERT_QUERY = "5";
    /**
     * 证书状态查询
     */
    public static final String CERTBUSINESSTYPE_CERT_STATUS_QUERY = "6";
    /**
     * 证书冻结
     */
    public static final String CERTBUSINESSTYPE_CERTFROZEN = "7";
    /**
     * 证书解冻
     */
    public static final String CERTBUSINESSTYPE_CEERT_NO_FROZEN = "8";
    /**
     * 加密申请
     */
    public static final String CERTBUSINESSTYPE_RESUME_ENP_APPLY = "12";
    /**
     * 加密私钥恢复
     */
    public static final String CERTBUSINESSTYPE_RESUME_ENP_KEY = "9";
    /**
     * 重置密钥恢复码
     */
    public static final String CERTBUSINESSTYPE_RESUME_KEY = "10";
    /**
     * 吊销证书
     */
    public static final String CERTBUSINESSTYPE_REVOKE = "11";
    /**
     * 密钥冻结
     */
    public static final String CERTBUSINESSTYPE_KEY_FORZEN = "56";
    /**
     * 密钥使用标识
     */
    public static final String NEEDRAGENKEY = "needragenkey";
    public static final int RA_NEEDRAGENKEY = 1;// RA产生密钥
    public static final int CONTROL_NEEDRAGENKEY = 2;// 控件产生密钥
    public static final int UE_NEEDRAGENKEY = 3;// 终端产生密钥

    /**
     * 业务结果
     */
    public static final String BUSINESSRESULT = "businessResult";

    /**
     * 管理员类型
     */
    public static final String MANAGERTYPE = "managerType";

    /**
     * 操作结果
     */
    public static final String OPRESULT = "opResult";
    /**
     * 操作结果成功
     */
    public static final String OPRESULT_SUCCESS = "1";
    /**
     * 操作结果失败
     */
    public static final String OPRESULT_FAIL = "2";

    /**
     * 操作类型
     */
    public static final String OPTYPE = "opTYPE";

    /**
     * 证书应用类型
     */
    public static final String CERTAPPTYPE = "certAppType";
//    public static final String CERTAPPTYPE_TAX = "1";// 税务（报税）
//    public static final String CERTAPPTYPE_BUSINESS = "2";// 工商
//    public static final String CERTAPPTYPE_SOCIAL_SECURITY = "3";// 社保
//    public static final String CERTAPPTYPE_COMM_ORG = "4";// 公共机构
//    public static final String CERTAPPTYPE_E_GOVERNMENT = "5";// 电子政务
//    public static final String CERTAPPTYPE_E_BUSINESS = "6";// 电子商务
//    public static final String CERTAPPTYPE_FINANCE_SECURITIES = "7";// 金融证券
//    public static final String CERTAPPTYPE_APPRECIATION_PLATFORM = "8";// 增值平台
//    public static final String CERTAPPTYPE_PERSONAL_SECRET = "9";// 个人密保
//    public static final String CERTAPPTYPE_EMAIL = "10";// 电子邮箱
//    public static final String CERTAPPTYPE_OTHER = "11";// 其他
//
//    /**
//     * 证书应用类型
//     */
//    public static final String ENAPPTYPE = "enAppType";
//    public static final String ENAPPTYPE_COMM_ORG = "20";// 公共机构
//    public static final String ENAPPTYPE_E_GOVERNMENT = "21";// 电子政务
//    public static final String ENAPPTYPE_ENTERPRISE_SECRET = "22";// 企业密保
//    public static final String ENAPPTYPE_BUSINESS = "23";// 工商
//    public static final String ENAPPTYPE_SOCIAL_SECURITY = "24";// 社保
//    public static final String ENAPPTYPE_EMAIL = "25";// 电子邮箱
//    public static final String ENAPPTYPE_TAX = "26";// 税务（报税）
//    public static final String ENAPPTYPE_APPRECIATION_PLATFORM = "27";// 增值平台
//    public static final String ENAPPTYPE_FINANCE_SECURITIES = "28";// 金融证券
//    public static final String ENAPPTYPE_E_BUSINESS = "29";// 电子商务
//    public static final String ENAPPTYPE_OTHER = "30";// 其他
    /**
     * 证书存储类型
     */
    public static final String CERTSTORETYPE = "certStoreType";
    public static final String CERTSTORETYPE_UKEY = "CCIT Smartcard CSP V1.0";// key方式 
    public static final String CERTSTORETYPE_FILE = "ccit_esy_client_p12";// 文件方式
    public static final String CERTSTORETYPE_CER = "cer_store";// key方式 
    public static final String CERTSTORETYPE_BROWSER= "Browser_store";// 文件方式
    public static final String CERTSTORETYPE_UE = "3";// 终端方式

    /**
     * 证书类型
     */
    public static final String CERTTYPE = "certType";
    public static final String CERTTYPE_SINGLE = "1";// 单证书
    public static final String CERTTYPE_DOUBLE = "2";// 双证书

    /**
     * 证书使用类型
     */
    public static final String CERTUSETYPE = "certUseType";
    public static final String CERTUSETYPE_encrypt = "1";// 加密证书
    public static final String CERTUSETYPE_SIGN = "2";// 签名证书
    public static final String CERTUSETYPE_encrypt_SIGN = "3";// 加密并签名证书
    public static final String CERTUSETYPE_encrypt_or_SIGN = "4";// 加密并签名证书

    /**
     * 证书种类
     */
    public static final String CERTSORT = "certSort";
    public static final String CERTSORT_PERSONAL_GENERAL = "1";// 个人UKEY证书
    public static final String CERTSORT_ENT_GENERAL = "2";// 企业普通证书
    public static final String CERTSORT_PERSONAL_NOTINDIVIDUAL="3";//个人非实名证书
    public static final String CERTSORT_PERSONAL_SERVER = "4";// 个人服务器证书
    public static final String CERTSORT_ENT_SERVER = "5";// 企业服务器证书
    public static final String CERTSORT_PERSONAL_CODE = "6";// 个人代码签名证书
    public static final String CERTSORT_ENT_CODE = "7";// 企业代码签名证书
    public static final String CERTSORT_PERSONAL_MM="8";//终端应用个人开发者标识证书  
    public static final String CERTSORT_ENT_MM="9";// 终端应用企业开发者标识证书   
    public static final String CERTSORT_Device="10";//移动终端设备证书    
    public static final String CERTSORT_TEL_NOTINDIVIDUAL="11";//手机号码证书   
    public static final String CERTSORT_TEL_INDIVIDUAL="12";//手机实名证书  
    
    public static final String CERTSORT_APPRELEASE="14";//开发者应用发布证书
    public static final String CERTSORT_CIDC="15";//终端应用内容标识证书
    public static final String CERTSORT_TAAC="16";//TAAC版权声明证书
    
    public static final String CERTSORT_PERSONAL_TEST = "98";// 个人测试证书
    public static final String CERTSORT_ENTERPRISE_TEST = "99";// 企业测试证书


    /**
     * LDAP状态
     */
    public static final String LDAPSTATUS = "ldapStatus";

    /**
     * 申请处理状态
     */
    public static final String APPROVALTYPE = "approvalType";
    public static final String NO_AUDIT = "1";// 未审批
    public static final String PASS_AUDIT = "2";// 审批通过
    public static final String NOT_PASS_AUDIT = "3";// 审批不通过
    public static final String ALREADY_ISSUED = "4";// 已签发
    public static final String WAIT_AUDIT = "5";// 等待审核员审批

    /**
     * 用户类型
     */
    public static final String USERTYPE = "userType";
    public static final String USERTYPE_NATURAL = "1";// 自然人
    public static final String USERTYPE_LEGAL_PERSONAL = "2";// 企业法人

    /**
     * 国家
     */
    public static final String COUNTRY = "country";

    /**
     * 省
     */
    public static final String PROVINCE = "province";

    /**
     * 申请方式
     */
    public static final String APPLYMODE = "applymode";
    public static final String APPLYCERT_WEB = "1";// WEB方式申请
    public static final String APPLYCERT_FACE_TO_FACE = "2";// 面对面申请
    public static final String APPLYCERT_UE = "3"; // 终端方式（手机）

    /**
     * 证书下载
     */
    public static final int DOWNLOAD_CERT = 2;
    /**
     * 证书状态
     */
    public static final String CERTSTATUS = "certStatus";

    /**
     * 证书状态为有效
     */
    public static final String CERTSTATUS_VALID = "1";
   
    /**
     * 证书状态为冻结
     */
    public static final String CERTSTATUS_FREEZE = "2";
    /**
     * 证书状态为作废
     */
    public static final String CERTSTATUS_REVOKE = "3";
    /**
     * 证书状态为更新有效
     */
    public static final String CERTSTATUS_CHANGE_VALID = "6";
    /**
     * 证书状态为更新作废
     */
    public static final String CERTSTATUS_CHANGE_REVOKE = "7";
    /**
     * 证书状态为过期
     */
    public static final String CERTSTATUS_NOTVALID = "4";

    /**
     * 证书作废原因
     */
    public static final String REVOKECAUSE = "revokeCause";
    public static final int REVOKECAUSESIX = 0;// 吊销原因未指明
    public static final int REVOKECAUSEONE = 1;// 私钥泄露
    public static final int REVOKECAUSETWO = 2;// CA泄露
    public static final int REVOKECAUSETHE = 3;// 从属关系改变
    public static final int REVOKECAUSEFOR = 4;// 证书更换
    public static final int REVOKECAUSEFIV = 5;// 操作终止

    /**
     * 密钥使用方式
     */
    public static final String USERKEYFLAG = "userKeyFlag";
    public static final int USERKEYFLAGONE = 1;// 原有密钥
    public static final int USERKEYFLAGTWO = 2;// 更新密钥

    /**
     * 用户数据表
     */
    public static final String INFOTABLES = "infoTables";
    public static final String INFOTABLES_USER = "user_info";// 个人用户信息表
    public static final String INFOTABLES_USER_TEMP = "user_info_temp";// 个人用户信息申请表
    public static final String INFOTABLES_ENTERPRISE = "enterprise_info";// 企业信息表
    public static final String INFOTABLES_ENTERPRISE_TEMP = "enterprise_info_temp";// 企业信息申请表
    public static final String INFOTABLES_ENTERPRISE_USER_INFO_TEMP = "enterprise_user_info_temp";// 企业用户对应申请表
    public static final String INFOTABLES_ENTERPRISE_USER_INFO = "enterprise_user_info";// 企业用户对应用户表
    /**
     * 签名算法
     */
    public static final String SIGNALGORITHM = "signAlgorithm";
    public static final String SIGNALGORITHM_SHA1WITHRSA = "SHA1WITHRSA";
    public static final String SIGNALGORITHM_MD2WITHRSA = "MD2WITHRSA";
    public static final String SIGNALGORITHM_MD5WITHRSA = "MD5WITHRSA";
    public static final String SIGNALGORITHM_ECC = "SM3/ECC";
    /**
     * 证书模板状态
     */
    public static final int CERT_TEMPLATE_STATUS_START = 1;// 模板启用
    public static final int CERT_TEMPLATE_STATUS_STOP = 2;// 模板停用，默认为停用
    /**
     * 新老用户标识
     */
    public static final String NEW_USER_FLAG = "1";// 新用户
    public static final String OLD_USER_FLAG_UPDATE = "2";// 老用户修改信息
    public static final String ODL_USER_FLAG_NO_UPDATE = "3";// 老用户没有修改信息
    /**
     * 查询字典表用 省
     */
    public static final String DIC_PROVINCEINFO = "ProvinceInfo";

    /**
     * 查询字典表用 市
     */
    public static final String DIC_CITYINFO = "CityInfo";

    /**
     * 密钥存储方式
     */
    public static final String KEY_STORETYPE = "keyStoreType";
    /**
     * 加密机存储
     */
    public static final String KEY_STORE_MACHINE = "2";
    /**
     * 软库存储
     */
    public static final String KEY_STORE_SOFT = "1";

    /**
     * 加密机存储
     */
    public static final String KEY_STORE_MACHINE2 = "加密机存储";
    /**
     * 软库存储
     */
    public static final String KEY_STORE_SOFT2 = "软库存储";

    /**
     * 通知类型
     */
    public static final String NOTICE_TYPE = "noticetype";
    /**
     * 作废通知类型
     */
    public static final String NOTICE_TYPE_REVOKE = "4";
    /**
     * 解冻通知类型
     */
    public static final String NOTICE_TYPE_THAW = "3";
    /**
     * 到期更新
     */
    public static final String NOTICE_TYPE_UPDATE = "1";
    /**
     * 单变双通知类型
     */
    public static final String NOTICE_TYPE_SINGLE_TO_DOUBLE = "10";
    /**
     * 补发通知类型
     */
    public static final String NOTICE_TYPE_REPLACE = "5";
    /**
     * 换发通知类型
     */
    public static final String NOTICE_TYPE_RENEWAL = "8";
    
    /**
     * 证书闭环确认
     */
    public static final String NOTICE_TYPE_CONFIRMCERT= "11";
    
    /**
     * 下发passcode
     */
    public static final String NOTICE_TYPE_PASSCODE= "12";
    /**
     * CA 类型
     */
    public static final String CA_TYPE = "caType";
    /**
     * 个人证书CA
     */
    public static final String CA_PERSON = "1";
    /**
     * 个人ECC证书CA
     */
    public static final String CA_PERSON_ECC = "8";
    /**
     * 企业证书CA
     */
    public static final String CA_ENT = "2";
    /**
     * 企业ECC证书CA
     */
    public static final String CA_ENT_ECC = "9";
    /**
     * 服务器证书CA
     */
    public static final String CA_SERVER = "3";
    /**
     * 服务器ECC证书CA
     */
    public static final String CA_SERVER_ECC = "10";
    /**
     * System CA
     */
    public static final String CA_SYSTEM = "4";
    /**
     * 代码签名证书CA
     */
    public static final String CA_CODE = "5";
    /**
     * 代码签名ECC证书CA
     */
    public static final String CA_CODE_ECC = "11";
    /**
     * 大客户运营CA
     */
    public static final String CA_BUSINESS = "6";

    /**
     * 所属系统
     */
    public static final String BOLONG_SYSTEM = "bolongSystem";
    /**
     * 管理员类型
     */
    public static final String ADMIN_TYPE = "managerType";
    /**
     * 审计管理员
     */
    public static final int ADMIN_TYPE_AUDIT = 4;
    /**
     * 超级管理员
     */
    public static final int ADMIN_TYPE_SUPER = 1;
    /**
     * 安全管理员
     */
    public static final int ADMIN_TYPE_ANQUAN = 6;
    /**
     * 作废原因
     */
    public static final String REVOKE_REASON = "revokeReason";
    /**
     * 证书来源(导入/自签)
     */
    public static final String CERT_SOUTCE = "certSource";

    /**
     * 证书模板最大有效期
     */
    public static final String MAX_DATE = "maxDate";
    /**
     * 证书模板默认有效期
     */
    public static final String DEFAULT_DATE = "defaultDate";
    /**
     * 证书有效期单位
     */
    public static final String DATEUNIT="dateUnit";
    /**
     * 证书国家代码
     */
    public static final String CN_TYPE = "CNType";
    /**
     * 密钥归档原因
     */
    public static final String ARCHIVE_KEY = "archivekeyreson";
    /**
     * CRL策略发布方式
     */
    public static final String CRL_PUBLISH_TYPE = "crlPublishType";
    public static final int FULL_TYPE = 1; // 全量
    public static final int INCREMENT_TYPE = 2; // 增量
    /**
     * CRL策略状态
     */
    public static final String CRL_STATUS = "crlStatus";
    /**
     * CRL签发CA
     */
    public static final String CRL_SIGN_TYPE = "crlSignType";

    public static final String PERSONAL_TEMPLATE = "personalTemplate";
    public static final String COMPANY_TEMPLATE = "companyTemplate";
    /**
     * 证书所在库
     */
    public static final String CERT_LIBRARY = "certLibary";
    /**
     * 证书所在库 在用库
     */
    public static final String CERT_LIBRARY_INUSE = "1";
    /**
     * 证书所在库 历史库
     */
    public static final String CERT_LIBRARY_HISTORY = "2";

    /**
     * 管理根CA类型
     */
    public static final String CATYPE_MANAGE_CA = "1";
    /**
     * 管理子CA类型
     */
    public static final String CATYPE_MGR_SUN_CA = "2";
    /**
     * 离线管理CA类型
     */
    public static final String CATYPE_OFFLINE_MGR_CA = "3";
    /**
     * 在线人员证书
     */
    public static final String CATYPE_ONLINE_PERSON_CA = "4";
    /**
     * 离线人员证书
     */
    public static final String CATYPE_OFFLINELINE_PERSON_CA = "5";
    /**
     * 站点证书
     */
    public static final String CATYPE_ONLINE_SERVER_CA = "6";
    /**
     * 业务根证书类型
     */
    public static final String ROOTCATYPE = "rootCaType";
    /**
     * 外部CA根
     */
    public static final String ROOTCATYPE_OUTER_CA = "1";
    /**
     * 内部CA根
     */
    public static final String ROOTCATYPE_INNER_CA = "2";
    /**
     * 代码签名CA根
     */
    public static final String ROOTCATYPE_CODESIGN_CA = "3";

    /**
     * passcode 使用状态
     */
    public static final int UNUSED = 1; // 未使用
    public static final int USED = 2; // 已使用

    /**
     * 加密机类型
     */
    public static final String ENTRYMACHINE_TYPE = "entrymachineType";
    public static final String LDAP_CONFIG_PATH = "ldappath";

    /** 数据库类型 */
    public static final String DB_TYPE = "dbtype";
    public static final String DB_TYPE_ORACLE = "1";
    public static final String DB_TYPE_DB2 = "2";
    public static final String DB_TYPE_MYSQL = "3";
    /**
     * 已经审计
     */
    public static String IS_AUDIT_YES = "1";
    /**
     * 没审计
     */
    public static String IS_AUDIT_NOT = "2";
    /**
     * 数据恢复表类型
     * */
    public static String RESUME_BACKUP_TABLE = "tabletype";

    /**
     * 数据表
     */
    public static final String TABLESHOW = "tableShow";

    /**角色状态*/
    public static final String ROL_STATUS = "rolStatus";
    
    /**
     * 证书种类范围
     */
    public static final String CERTSORT_RANGE = "certSortrange";
    public static final String CERTSORT_PERSONRANGE = "1"; //个人证书
    public static final String CERTSORT_ENTRANGE = "2";//企业证书
    public static final String CERTSORT_ACCOUNTRANGE = "3"; //账号
    
    /**
     * 证书请求动作
     */
    
    public static final String CERTAPPLYTYPE = "certApplyType";
    /**
     * 证书动作为新增
     */
    public static final String CERTAPPLYTYPE_VALID = "1";

    /**
     * 证书动作为作废
     */
    public static final String CERTAPPLYTYPE_REVOKE = "3";
    /**
     * 证书动作为更新
     */
    public static final String CERTAPPLYTYPE_CHANGE_VALID = "6";
    /**
     * 证书动作为更新作废
     */
    public static final String CERTAPPLYTYPE_CHANGE_REVOKE = "7";
    /**
     * 证书动作为过期
     */
    public static final String CERTAPPLYTYPE_NOTVALID = "4";
    
    /**
     * 证书确认状态
     */
    public static final String CERTCONFIRMSTATUS="certConfirmStatus";
    public static final String CERTCONFIRMSTATUS_UNCONFIRM="0"; //未确认
    public static final String CERTCONFIRMSTATUS_CONFIRM="1";   //已确认
    /**
     * 密钥类型
     */
    public static final String KEYTYPE_RSA = "RSA";
    public static final String KEYTYPE_SM2 = "SM2";
    
    
    
    
}
