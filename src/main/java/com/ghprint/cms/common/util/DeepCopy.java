package com.ghprint.cms.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class DeepCopy {  
	private static Logger log = LoggerFactory.getLogger(DeepCopy.class);
    /** 
     * 深层拷贝 
     *  
     * @param <T> 
     * @param obj 
     * @return 
     * @throws Exception 
     */  
    public static <T> T copy(T obj) throws Exception {  
        //是否实现了序列化接口，即使该类实现了，他拥有的对象未必也有...  
        if(Serializable.class.isAssignableFrom(obj.getClass())){  
            //如果子类没有继承该接口，这一步会报错  
            try {  
                return copyImplSerializable(obj);  
            } catch (Exception e) {  
            	log.error("深度拷贝发生异常");
            }  
        }  
        return null;  
    }  
  
    /** 
     * 深层拷贝 - 需要类继承序列化接口 
     * @param <T> 
     * @param obj 
     * @return 
     * @throws Exception 
     */  
    @SuppressWarnings("unchecked")  
    public static <T> T copyImplSerializable(T obj) throws Exception {  
        ByteArrayOutputStream baos = null;  
        ObjectOutputStream oos = null;  
          
        ByteArrayInputStream bais = null;  
        ObjectInputStream ois = null;  
          
        Object o = null;  
        //如果子类没有继承该接口，这一步会报错  
        try {  
            baos = new ByteArrayOutputStream();  
            oos = new ObjectOutputStream(baos);  
            oos.writeObject(obj);  
            bais = new ByteArrayInputStream(baos.toByteArray());  
            ois = new ObjectInputStream(bais);  
  
            o = ois.readObject();  
            return (T) o;  
        } catch (Exception e) {  
            throw new Exception("对象中包含没有继承序列化的对象");  
        } finally{  
            try {  
                baos.close();  
                oos.close();  
                bais.close();  
                ois.close();  
            } catch (Exception e2) {  
                //这里报错不需要处理  
            }  
        }  
    }  
      
      
}  