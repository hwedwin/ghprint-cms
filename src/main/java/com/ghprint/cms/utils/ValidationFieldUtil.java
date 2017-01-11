package com.ghprint.cms.utils;

import java.util.regex.Pattern;

/**
 * Created by wings on 2015/12/24.
 */
public class ValidationFieldUtil {


    /*
	intege1:"^[1-9]\\d*$",					//正整数
	num:"^([+-]?)\\d*\\.?\\d+$",			//数字
	decmal:"^([+-]?)\\d*\\.\\d+$",			//浮点数

	email:"^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$", //邮件
	color:"^[a-fA-F0-9]{6}$",				//颜色
	url:"^http[s]?:\\/\\/([\\w-]+\\.)+[\\w-]+([\\w-./?%&=]*)?$",	//url
	chinese:"^[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+$",					//仅中文
	zipcode:"^\\d{6}$",						//邮编
	mobile:"^(13|15)[0-9]{9}$",				//手机
	ip4:"^(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5]).(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5]).(d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5]).(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])$",				//ip地址
	notempty:"^\\S+$",						//非空
	picture:"(.*)\\.(jpg|bmp|gif|ico|pcx|jpeg|tif|png|raw|tga)$",	//图片
	rar:"(.*)\\.(rar|zip|7zip|tgz)$",								//压缩文件
	date:"^\\d{4}(\\-|\\/|\.)\\d{1,2}\\1\\d{1,2}$",					//日期
	qq:"^[1-9]*[1-9][0-9]*$",				//QQ号码
	tel:"(\\d{3}-|\\d{4}-)?(\\d{8}|\\d{7})",	//国内电话
	username:"^\\w+$",						//用来用户注册。匹配由数字、26个英文字母或者下划线组成的字符串
	letter:"^[A-Za-z]+$",					//字母
	letter_u:"^[A-Z]+$",					//大写字母
	letter_l:"^[a-z]+$",					//小写字母
	idcard:"^[1-9]([0-9]{14}|[0-9]{17})$"	//身份证

	*/
    //整数
    public static final String INTEGER_REGEX ="^[0-9]\\d*$";
    public static final Pattern INTEGER_PATTERN = Pattern.compile(INTEGER_REGEX);
    public static boolean checkInteger(String i){
        return INTEGER_PATTERN.matcher(i).find();
    }
    //浮点数
    public static final String DECIMAL_REGEX ="^[0-9]\\d*(.\\d{1,2})?$|(0.\\d{1,2})";
    public static final Pattern DOUBLE_PATTERN = Pattern.compile(DECIMAL_REGEX);



    //手机号
    public static final String MOBILE_REGEX ="^(1[3-8])[0-9]{9}$";
    public static final Pattern MOBILE_PATTERN = Pattern.compile(MOBILE_REGEX);
    public static boolean checkMobile(String mobile){
        return mobile.length() != 0 && MOBILE_PATTERN.matcher(mobile).find();
    }
    //客户号
    public static final String CUSTOMER_NO_REGEX ="^[A-Za-z0-9]{16}$";
    public static final Pattern CUSTOMER_NO_PATTERN = Pattern.compile(CUSTOMER_NO_REGEX);
    public static boolean checkCustomerNo(String customerNo){
        return CUSTOMER_NO_PATTERN.matcher(customerNo).find();
    }
    //座机
    public static final String TEL_REGEX ="^(\\d{3}-|\\d{4}-)?(\\d{8}|\\d{7})$";
    public static final Pattern TEL_PATTERN = Pattern.compile(TEL_REGEX);
    public static boolean checkTelephone(String telephone){
        return TEL_PATTERN.matcher(telephone).find();
    }
    //email
    public static final String EMAIL_REGEX ="^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
    public static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    public static boolean checkEmail(String e){
        return EMAIL_PATTERN.matcher(e).find();
    }
    //中文
    public static final String CHINESE_REGEX ="^[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+$";
    public static final Pattern CHINESE_PATTERN = Pattern.compile(CHINESE_REGEX);
    public static boolean checkChinese(String c){
        return CHINESE_PATTERN.matcher(c).find();
    }
    //邮编
    public static final String ZIP_CODE_REGEX ="^\\d{6}$";
    public static final Pattern ZIP_CODE_PATTERN = Pattern.compile(ZIP_CODE_REGEX);
    public static boolean checkPostCode(String p){
        return ZIP_CODE_PATTERN.matcher(p).find();
    }
    //身份证
    public static final String ID_REGEX ="^[1-9]([0-9]{14}|[0-9|X|x]{17})$";
    public static final Pattern ID_PATTERN = Pattern.compile(ID_REGEX);
    public static boolean checkIdNumber(String idNumber){
        return ID_PATTERN.matcher(idNumber).find();
    }
    //过滤特殊字符   ^[\u4E00-\u9FA5\uF900-\uFA2D\|a-z\|A-Z\|0-9]+$
    public static final String CDE_REGEX ="^[\\u4E00-\\u9FA5\\uF900-\\uFA2D\\|\\s*|[\\s ]|a-z\\|A-Z\\|0-9\\()（）]*\\s*|[\\s ]+$";
    public static final Pattern CDE_PATTERN = Pattern.compile(CDE_REGEX);
    public static boolean checkCde(String c){
        return CDE_PATTERN.matcher(c).find();
    }
    //非空 不能校验null
    public static final String EMPTY_REGEX ="^\\S+$";
    public static final Pattern EMPTY_PATTERN = Pattern.compile(EMPTY_REGEX);
    public static boolean checkEmpty(String e){
        return EMPTY_PATTERN.matcher(e).find();
    }
    //密码
    public static final String PASSWORD_REGEX ="^\\S+$";
    public static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);
    public static boolean checkPassWord(String p){
        return PASSWORD_PATTERN.matcher(p).find();
    }
    //新密码规则 （登录密码必须由字母、数字和特殊字符中的两种组成）
    public static final String PASSWORD_REGEX_NEW ="^(?![a-zA-z]+$)(?!\\d+$)(?![!@#$%^&*]+$)[a-zA-Z\\d!@#$%^&*]{6,20}$";
    public static final Pattern PASSWORD_PATTERN_NEW = Pattern.compile(PASSWORD_REGEX_NEW);

    //IVR密码
    public static final String IVR_PASSWORD_REGEX ="^[0-9]{6}$";
    public static final Pattern IVR_PASSWORD_PATTERN = Pattern.compile(IVR_PASSWORD_REGEX);
    public static boolean checkIVRPassWord(String IVR){
        return IVR_PASSWORD_PATTERN.matcher(IVR).find();
    }
    //
    /**金钱的匹配模式  小数点后2位*/
    public static final String MONEY_REGEX = "^(?!0$)(?!0.0$)(?!0.00$)(([1-9]\\d*)|0)(\\.\\d{1,2})?$";
    public static final Pattern MONEY_PATTERN = Pattern.compile(MONEY_REGEX);
    public static boolean checkMoney(String m){
        return MONEY_PATTERN.matcher(m).find();
    }
    //数字和英文字符
    public static final String CHAR_REGEX ="^[a-z\\|A-Z\\|0-9]+$";
    public static final Pattern CHAR_PATTERN = Pattern.compile(CHAR_REGEX);


    public static boolean checkChar(String c){
        return CHAR_PATTERN.matcher(c).find();
    }

    //中文英文
    public static final String CE_REGEX ="[\\u4E00-\\u9FA5\\uF900-\\uFA2D]*[a-z]*[A-Z]*\\d*\\.*\\|*\\,*-*'*:*\\{*\\}*\\[*\\]*\\s*";
    public static final Pattern CE_PATTERN = Pattern.compile(CE_REGEX);
    public static boolean checkChineseEnglish(String c){
        return CE_PATTERN.matcher(c).find();

    }


    //校验是否为电信手机号           ^(133|153|189|180|181|177)[0-9]{8}$
    public static final String TELECOM_MOBILE_REGEX ="^((133|153|189|180|181|177)[0-9]|1700)[0-9]{7}$";
    public static final Pattern TELECOM_MOBILE_PATTERN = Pattern.compile(TELECOM_MOBILE_REGEX);
    public static boolean checkTelecomMobile(String c){
        return TELECOM_MOBILE_PATTERN.matcher(c).find();

    }

    //校验是否为非电信手机号      ^(13[0-24-9]|15[0-24-9]|18[2-8]|14[7]|17[068])[0-9]{8}$
    public static final String NOT_TELECOM_MOBILE_REGEX ="^((13[0-24-9]|15[0-24-9]|18[2-8]|14[7]|17[68])[0-9]|170[1-9])[0-9]{7}$";
    public static final Pattern NOT_TELECOM_MOBILE_PATTERN = Pattern.compile(NOT_TELECOM_MOBILE_REGEX);
    public static boolean checkNotTelecomMobile(String c){
        return NOT_TELECOM_MOBILE_PATTERN.matcher(c).find();

    }
}
