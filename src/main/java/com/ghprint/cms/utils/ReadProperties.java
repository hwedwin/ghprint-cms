package com.ghprint.cms.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by robin on 2015/12/11.
 */
public class ReadProperties {
    private static Properties prop = new Properties();
    static {

    }

    /**
     * 读取属性文件
     * @param fileName 属性文件名称
     * @param proName 属性名称
     * @return 查询的属性名称
     * @throws IOException
     */
    public static String getProValue(String fileName,String proName) throws IOException{
        if (fileName!=null) {
            InputStream bt = ReadProperties.class.getClassLoader().getResourceAsStream(fileName);
            prop.load(bt);
        }
        String value = prop.getProperty(proName);
        return value;
    }
}