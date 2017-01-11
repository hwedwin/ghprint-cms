package com.ghprint.cms.utils;

/**
 * Created by Administrator on 2016/3/8.
 */
public class GetResource {

    /**
     * @说明: 获取文件的uri
     * @param fileName(如"/keystore/orangeApp.cer")
     * @return
     */
    public String getResource(String fileName){
        return this.getClass().getResource(fileName).toString().substring(5);
    }
}
