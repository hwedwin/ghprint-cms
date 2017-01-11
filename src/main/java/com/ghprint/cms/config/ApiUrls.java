package com.ghprint.cms.config;

/**
 * ZCF
 */
public class ApiUrls {

    //H5版本列表查询
    public static final String H5_QUERY_LIST_V1 = "/h5/v1/list/query";

    //H5版本添加与上传
    public static final String H5_INSERT_SINGLE_V1 = "/h5/v1/h5Upload";

    //H5版本信息更新
    public static final String H5_UPDATE_SINGLE_V1 = "/h5/v1/h5Update";

    //H5版本信息删除
    public static final String H5_DELETE_SINGLE_V1 = "/h5/v1/h5Delete";

    //APK版本列表查询
    public static final String APK_QUERY_LIST_V1 = "/apk/v1/list/query";

    //APK版本添加与上传
    public static final String APK_INSERT_SINGLE_V1 = "/apk/v1/apkUpload";

    //APK版本信息更新
    public static final String APK_UPDATE_SINGLE_V1 = "/apk/v1/apkUpdate";

    //APK版本信息删除
    public static final String APK_DELETE_SINGLE_V1 = "/apk/v1/apkDelete";

    //banner列表查询
    public static final String BANNER_QUERY_LIST_V1 = "/banner/v1/list/query";

    //banner添加与上传
    public static final String BANNER_INSERT_SINGLE_V1 = "/banner/v1/bannerUpload";

    //banner信息更新
    public static final String BANNER_UPDATE_SINGLE_V1 = "/banner/v1/bannerUpdate";

    //banner信息删除
    public static final String BANNER_DELETE_SINGLE_V1 = "/banner/v1/bannerDelete";

    //公告信息列表查询
    public static final String MESSAGE_QUERY_LIST_V1 = "/message/v1/list/query";

    //公告信息添加与上传
    public static final String MESSAGE_INSERT_SINGLE_V1 = "/message/v1/upload";

    //公告信息更新
    public static final String MESSAGE_UPDATE_SINGLE_V1 = "/message/v1/update";

    //公告信息删除
    public static final String MESSAGE_DELETE_SINGLE_V1 = "/message/v1/delete";

    //活动图片列表查询
    public static final String PICTURE_QUERY_LIST_V1 = "/picture/v1/list/query";

    //活动图片单条查询
    public static final String PICTURE_SINGLE_LIST_V1 = "/picture/v1/single/query";

    //活动图片添加与上传
    public static final String PICTURE_INSERT_LIST_V1 = "/picture/v1/pictureUpload";

    //活动图片信息更新
    public static final String PICTURE_UPDATE_LIST_V1 = "/picture/v1/pictureUpdate";

    //活动图片信息删除
    public static final String PICTURE_DELETE_LIST_V1 = "/picture/v1/pictureDelete";

    //活动图片详情新增
    public static final String INSERTACTIVITYDETAIL_BUSINESS_V1 = "/business/v1/insertActivityDetail";

    //活动图片详情查询
    public static final String GETACTIVITYDETAIL_BUSINESS_V1 = "/business/v1/getActivityDetail";

    //活动图片详情修改
    public static final String UPDATEACTIVITYDETAIL_BUSINESS_V1 = "/business/v1/updateActivityDetail";

    //活动图片详情删除
    public static final String DELETEACTIVITYDETAIL_BUSINESS_V1 = "/business/v1/deleteActivityDetail";

    //公共方法,根据不同的business_type不同查询同一类型的所有图片
    public static final String QUERYALLPICTUREBYBUSINESSTYPE_BUSINESS_V1 = "/business/v1/queryAllPictureByBusinessType";
  
    //用户管理类接口
    //用户查询接口
    public static final String SYSTEM_USER_QUERY_V1 = "/system/v1/userQuery";

    //用户增加接口
    public static final String SYSTEM_USER_ADD_V1 = "/system/v1/userAdd";

    //用户删除接口
    public static final String SYSTEM_USER_DELETE_V1 = "/system/v1/userDelete";

    //活动开关查询接口
    public static final String ACTIVITYSWITCHQUERY_ACTIVITY_V1 = "/activity/v1/activitySwitchQuery";

    //活动开关增加接口
    public static final String ACTIVITYSWITCHADD_ACTIVITY_V1 = "/activity/v1/activitySwitchAdd";

    //活动开关更新接口
    public static final String ACTIVITYSWITCHUPDATE_ACTIVITY_V1 = "/activity/v1/activitySwitchUpdate";

    //活动开关删除接口
    public static final String ACTIVITYSWITCHDELETE_ACTIVITY_V1 = "/activity/v1/activitySwitchDelete";

    //活动属性详情查询接口
    public static final String ACTIVITYSWITCHPROPQUERY_ACTIVITY_V1 = "/activity/v1/activitySwitchPropQuery";

    //活动属性详情添加接口
    public static final String ACTIVITYSWITCHPROPADD_ACTIVITY_V1 = "/activity/v1/activitySwitchPropAdd";

    //活动属性详情添加接口
    public static final String ACTIVITYSWITCHPROPUPDATE_ACTIVITY_V1 = "/activity/v1/activitySwitchPropUpdate";

    //活动属性详情添加接口
    public static final String ACTIVITYSWITCHPROPDELETE_ACTIVITY_V1 = "/activity/v1/activitySwitchPropDelete";

    //账号列表查询接口
    public static final String PHONEQUERY_PHONE_V1="/phone/v1/phoneQuery";

    //单条账号查询接口
    public static final String PHONEQUERYSINGLE_PHONE_V1="/phone/v1/phoneQuerySingle";

    //账号新增接口
    public static final String PHONEINSERT_PHONE_V1="/phone/v1/phoneInsert";

    //账号修改接口
    public static final String PHONEUPDATE_PHONE_V1="/phone/v1/phoneUpdate";

    //账号删除接口
    public static final String PHONEDELETE_PHONE_V1="/phone/v1/phoneDelete";

    //H5_v2版本列表查询
    public static final String H5_QUERY_LIST_V2 = "/h5/v2/list/query";

    //H5_v2版本添加与上传
    public static final String H5_INSERT_SINGLE_V2 = "/h5/v2/h5Upload";

    //H5_v2版本信息更新
    public static final String H5_UPDATE_SINGLE_V2 = "/h5/v2/h5Update";

    //H5_v2版本信息删除
    public static final String H5_DELETE_SINGLE_V2 = "/h5/v2/h5Delete";

    // 解锁
    public static final String UNLOCK_USER_INFO = "/unlock/v1/userInfo";
    public static final String UNLOCK_ACTION = "/unlock/v1/action";

}
