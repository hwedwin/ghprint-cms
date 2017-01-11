package com.ghprint.cms.utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by zcf on 2016/6/2.
 */
public class PageSelect {
    private static Logger log = LoggerFactory.getLogger(PageSelect.class);
    public static List PageSelect(List list,String page,String rows){
        int pagenm = 0;//页数
        if(list.size()%Integer.parseInt(rows)>0){
            pagenm = (int)(list.size()/Integer.parseInt(rows))+1;  //总页数
        }else{
            pagenm = (int)(list.size()/Integer.parseInt(rows));  //总页数
        }
        int begin = ((Integer.parseInt(page)-1)*Integer.parseInt(rows)); //截取的起始索引
        int end = 0; //截取的终止索引
        if(pagenm-(Integer.parseInt(page))>0){
            end = (Integer.parseInt(page)*Integer.parseInt(rows));
        }else{
            end = list.size();
        }
        return list.subList(begin,end);
    }
}
