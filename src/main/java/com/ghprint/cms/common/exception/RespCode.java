package com.ghprint.cms.common.exception;

/**
 * zcf
 * Description:交易异常响应码
 */
public enum RespCode {
    _000001("000001", "传入参数为空"),
    _000002("000002", "版本整型转换异常"),
    _000003("000003", "账号类型查询异常"),
    _000004("000004", "查询可升级的H5版本失败"),
    _000005("000005", "查询可升级的APK版本失败"),
    _000006("000006", "查询apk版本是否强制升级失败"),
    _000007("000007", "截取原有图片ID失败"),
    _000008("000008", "获取最新有效的banner失败"),
    _000009("000009", "查询最新有效的公告信息失败"),
    _000010("000010", "信息插入数据库操作异常"),
    _000011("000011", "数据库信息更新操作异常"),
    _000012("000012", "数据库信息删除操作异常"),
    _000013("000013", "数据库列表查询操作异常"),
    _000014("000014", "查询最新有效的活动图片列表失败"),
    _000015("000015", "查询活动图片属性列表失败");


    private String code;  //交易响应码
    private String desc;  //响应码描述

    private RespCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return this.getCode() + ":" + this.getDesc();
    }
}
