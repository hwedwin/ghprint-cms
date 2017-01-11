package com.ghprint.cms.utils;

/**
 * Created by zcf on 2015/11/16.
 */
public class Constant {
    //RSA的keystore路径
    public static final String uri = "/keystore/OfficeA.jks";

    //RSA的keystore的密码
    public static final String password = "123456";

    //RSA的keystore的秘钥对别名
    public static final String alias = "mykey";

    //返回结果码
    public enum errorCodeEnum{
        SUCCESS("000000","操作成功"),
        FAILURE("100000","操作失败"),
        PARAM_ERROR("100001","参数错误"),
        SYSTEM_ERROR("900000","系统异常"),
        LOGIN_ACCOUNT_NULL("110000","账号不存在"),
        LOGIN_PASSWORD_ERROE("120000","密码不正确");

        private String code;
        private String name;
        errorCodeEnum (String code,String name){
            this.code=code;
            this.name=name;
        }
        public String getCode() {
            return code;
        }
        public String getName() {
            return name;
        }
    }
}
