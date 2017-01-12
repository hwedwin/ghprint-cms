package com.ghprint.cms.utils;

import java.util.Random;

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

    /**
     * 产生4位随机数(0000-9999)
     * @return 4位随机数
     */
    public static String getFourRandom(){
        Random random = new Random();
        String fourRandom = random.nextInt(10000) + "";
        int randLength = fourRandom.length();
        if(randLength<4){
            for(int i=1; i<=4-randLength; i++)
                fourRandom = "0" + fourRandom  ;
        }
        return fourRandom;
    }


}
