package com.ghprint.cms.utils;

import java.util.Map;

/**
 * Created by 王棠 on 2016/3/29.
 */
public class SqlProvider {

    public String selectActivityByConn(Map< String,Object > para){
        String tableStr = "";
        String whereStr = "";
        if(para.get("status")!=null&&!"".equals(para.get("status"))){
            whereStr+=" and a.activity_status='"+para.get("status")+"'";
        }
        if(para.get("channelNum")!=null&&!"".equals(para.get("channelNum"))){
            tableStr+=",t_sys_globalproperty g2";
            whereStr+=" and (a.activity_channel_num=g2.pk_id and g2.property_value='"+para.get("channelNum")+"')";
        }
        if(para.get("activityType")!=null&&!"".equals(para.get("activityType"))){
            tableStr+=",t_sys_globalproperty g1";
            whereStr+=" and (a.activity_type=g1.pk_id and g1.property_value='"+para.get("activityType")+"')";
        }
        if(para.get("businessType")!=null&&!"".equals(para.get("businessType"))){
            tableStr+=",t_sys_globalproperty g3";
            whereStr+=" and (a.activity_business_type=g3.pk_id and g3.property_value='"+para.get("businessType")+"')";
        }
        if(para.get("betaType")!=null&&!"".equals(para.get("betaType"))){
            tableStr+=",t_sys_globalproperty g4";
            whereStr+=" and (a.activity_beta_type=g4.pk_id and g4.property_value='"+para.get("betaType")+"')";
        }
        if(para.get("activityName")!=null&&!"".equals(para.get("activityName"))){
            whereStr+=" and a.activity_name like '%"+para.get("activityName")+"%'";
        }
        String QUERY_DB_ACTIVITY = "select a.pk_id,a.activity_name,a.activity_start_time,a.activity_end_time,\n" +
                "(SELECT g.property_key from t_sys_globalproperty g where g.pk_id=activity_channel_num) activity_channel_num,\n" +
                "(SELECT g.property_key from t_sys_globalproperty g where g.pk_id=activity_business_type) activity_business_type,\n" +
                "(SELECT g.property_key from t_sys_globalproperty g where g.pk_id=activity_type) activity_type,\n" +
                "(SELECT g.property_key from t_sys_globalproperty g where g.pk_id=activity_beta_type) activity_beta_type,\n" +
                "a.activity_sort,\n" +
                "a.activity_status,\n" +
                "a.activity_dec,\n" +
                "a.activity_create_time,a.activity_update_time,a.activity_update \n" +
                " from t_cms_activity a " + tableStr +
                " WHERE 1=1  \n" + whereStr;
        return QUERY_DB_ACTIVITY;
    }
}
