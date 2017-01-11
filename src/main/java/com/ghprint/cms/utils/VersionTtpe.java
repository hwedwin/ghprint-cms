package com.ghprint.cms.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zcf on 2015/11/4.
 */
public class VersionTtpe {
    protected static final Logger LOG = LoggerFactory.getLogger(VersionTtpe.class);
    /**
     * 说明：将string的版本号转换成规定的整数类型
     * 规则：verint[0] * 10000000 + verint[1] * 10000 + verint[2]
     *      e.g:4.1.1转换成40010001
     * @param version
     * @return result
     */
    public static int versionToint(String version) {
        int result = 0;
        try {
            String[] ver = version.split("\\.");
            int[] verint = new int[ver.length];
            for (int i = 0; i < ver.length; i++) {
                verint[i] = Integer.parseInt(ver[i]);
            }
            result = verint[0] * 10000000 + verint[1] * 10000 + verint[2];
        }catch (Exception e){
            LOG.info("版本转换异常:{}",e);
        }
        return result;
    }
}
