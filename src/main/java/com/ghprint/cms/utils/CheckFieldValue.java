package com.ghprint.cms.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by robin on 2015/11/23.
 */
public class CheckFieldValue {
    /**
     * 判断一个对象所有的属性是否为空
     * @param bean
     * @return 如果true，则为空
     */
    public static boolean checkFieldValueNull(Object bean) {
        boolean result = true;
        if (bean == null) {
            return true;
        }
        Class<?> cls = bean.getClass();
        Method[] methods = cls.getDeclaredMethods();
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            try {
                String fieldGetName = parGetName(field.getName());
                if (!checkGetMet(methods, fieldGetName)) {
                    continue;
                }
                Method fieldGetMet = cls.getMethod(fieldGetName, new Class[]{});
                Object fieldVal = fieldGetMet.invoke(bean, new Object[]{});
                if (fieldVal != null) {
                    if (!"".equals(fieldVal)) {
                        result = false;
                        break;
                    }
                }
            } catch (Exception e) {
                continue;
            }
        }
        return result;
    }

    /**
     * 拼接某属性的 get方法
     *
     * @param fieldName
     * @return String
     */
    public static String parGetName(String fieldName) {
        if (null == fieldName || "".equals(fieldName)) {
            return null;
        }
        int startIndex = 0;
        if (fieldName.charAt(0) == '_')
            startIndex = 1;
        return "get"
                + fieldName.substring(startIndex, startIndex + 1).toUpperCase()
                + fieldName.substring(startIndex + 1);
    }

    /**
     * 判断是否存在某属性的 get方法
     *
     * @param methods
     * @param fieldGetMet
     * @return boolean
     */
    public static boolean checkGetMet(Method[] methods, String fieldGetMet) {
        for (Method met : methods) {
            if (fieldGetMet.equals(met.getName())) {
                return true;
            }
        }
        return false;
    }


    /**
     * @说明 判断list元素中的实体对象是否为空
     * 如果为null，返回true
     * 如果没有元素，返回true
     * 如果元素全是字符串，返回ture
     * 如果元素中对象为空，返回true
     * @param list
     * @return boolean
     */
    public static boolean checkListObjectNull (List list){
        if(list==null) {return true;}
        if(list.isEmpty()) {return true;}
        if(list.size()<=0) {return true;}
        for(int i = 0;i < list.size();i++){
            if(!checkFieldValueNull(list.get(i))) {return false;}
        }
        return false;
    }
}
