package com.ghprint.cms.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Signature;

/**
 * Created by lenovo on 2016/9/13.
 */
public class RASWithSHA256 {
    private static Logger log = LoggerFactory.getLogger(RASWithSHA256.class);
    public static String rsaForFile(File file) {
        GetResource GR = new GetResource();
        //返回签名信息
        String result = null;
        try {
            //读取包文件
            //File file = new File("");
            InputStream in = new FileInputStream(file);
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            byte[] buf = new byte[8 * 1024];
            int read;
            while ((read = in.read(buf)) != -1) {
                byteOut.write(buf, 0, read);
            }
            in.close();
            //加载keystore
            log.info("keystore path:{}", GR.getResource(Constant.uri));
            System.out.println("keystore path:{}"+GR.getResource(Constant.uri));
            FileInputStream is = new FileInputStream(GR.getResource(Constant.uri));
            KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
            keystore.load(is, Constant.password.toCharArray());
            //设置别名
            String alias = Constant.alias;
            //获取私钥
            Key key = keystore.getKey(alias, Constant.password.toCharArray());
            if (key instanceof PrivateKey) {
                //对MD5摘要签名
                Signature ss = Signature.getInstance("SHA256withRSA");
                ss.initSign((PrivateKey)key);
                ss.update(byteOut.toByteArray());
                byte[] signresult = ss.sign();
                result = new BASE64Encoder().encode(signresult);
            }
        } catch (Exception e) {
            log.info("SHA256withRSA_result:{}",e);
        }
        return result;
    }
}
