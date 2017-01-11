package com.ghprint.cms.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by Administrator on 2015/11/19.
 */
public class FileUtil {
    protected static final Logger LOG = LoggerFactory.getLogger(FileUtil.class);
    public static int fileSize(String fileuri){
        int tempbyte = 0;
        //包大小
        try {
            InputStream in = new FileInputStream(new File(fileuri));
            while ((tempbyte = in.read()) != -1) {
                System.out.write(tempbyte);
            }
            in.close();
        }catch (Exception e){
            LOG.error("读取包文件大小异常:{}",e);
        }
        return tempbyte;
    }

    //将byte数组写入文件
    public  static void createFile(String path, byte[] content) throws IOException {

        FileOutputStream fos = new FileOutputStream(path);

        fos.write(content);
        fos.close();
    }
}
