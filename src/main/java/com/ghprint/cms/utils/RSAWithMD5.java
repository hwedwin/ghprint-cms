package com.ghprint.cms.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

        import java.io.*;
        import java.security.*;

/**
 * Created by zcf on 2015/11/16.
 */
public class RSAWithMD5 {
    private static Logger log = LoggerFactory.getLogger(RSAWithMD5.class);
    public static String rsaForFile(File file) {
        GetResource GR = new GetResource();
        //返回签名信息
        String result = "";
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
                Signature ss = Signature.getInstance("MD5withRSA");
                ss.initSign((PrivateKey)key);
                ss.update(byteOut.toByteArray());
                byte[] signresult = ss.sign();
                result = new BASE64Encoder().encode(signresult);
            }
        } catch (Exception e) {
            log.info("RSAWithMD5_result:{}",e);
        }
        return result;
    }
}
