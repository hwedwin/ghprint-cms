package com.ghprint.cms.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaowei on 2016/5/31.
 * 将{key:value,key:value}或者{key=value,key=value}形式的string装换为map
 */
public class String2Map {

    public static Map StringToMap(String str){
        if(null==str||str.equals("")){
            return null;
        }
        Map map = new HashMap();
        str = str.substring(1,str.length()-1);//去掉前后大括号
        String[] arrayData = str.split(",");
        for(int i=0;i<arrayData.length;i++){
            int j = 0;
            if(str.contains(":")){
                j = arrayData[i].indexOf(":");
            }else if (str.contains("=")){
                j = arrayData[i].indexOf("=");
            }
            map.put(arrayData[i].substring(0,j),arrayData[i].substring(j+1,arrayData[i].length()));
        }
        return map;
    }

}
