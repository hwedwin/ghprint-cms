package com.ghprint.cms.utils;

/**
 * Created by robin on 2015/11/12.
 */
public class SplicingCharacterUtil {
    /**
     * 拼接字符串,并去掉其中的空格
     * @param str
     * @return
     */
    public static String getNewString(String ... str){
        StringBuffer buffer = new StringBuffer();
        for (int i=0;i<str.length;i++){
            buffer.append(str[i].replace(" ",""));
            if (i!=str.length-1){
                buffer.append(":");
            }
        }
        return new String(buffer);
    }

    /**
     * 拼接字符串
     * @param str
     * @return
     */
    public static String getString(String ... str){
        StringBuffer buffer = new StringBuffer();
        for (int i=0;i<str.length;i++){
            buffer.append(str[i]);
        }
        return new String(buffer);
    }



}
