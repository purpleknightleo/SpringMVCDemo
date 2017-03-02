package com.lee.demo.springmvc.utils;

import java.beans.PropertyDescriptor;
import java.util.Collection;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

/**
 * POJO工具类
 *
 * Created by hzlifan on 2017/2/7.
 */
public class BeanUtil {

    private static final Logger logger = Logger.getLogger(BeanUtil.class);

    /**   */
    /**
     * 将orig的属性拷贝到dest
     *
     * @param dest
     * @param orig
     * @return the dest bean
     */
    public static Object copyProperties(Object dest, Object orig) {
        return copyProperties(dest, orig, null);
    }

    /**   */
    /**
     * 将orig的属性拷贝到dest，ignores为忽略的属性
     *
     * @param dest
     * @param orig
     * @param ignores
     * @return the dest bean
     */
    public static Object copyProperties(Object dest, Object orig, String[] ignores) {
        if (dest == null || orig == null) {
            return null;
        }

        PropertyDescriptor[] destDesc = PropertyUtils.getPropertyDescriptors(dest);
        try {
            for (int i = 0; i < destDesc.length; i++) {
                if (contains(ignores, destDesc[i].getName())) {
                    continue;
                }

                Class destType = destDesc[i].getPropertyType();
                Class origType = PropertyUtils.getPropertyType(orig, destDesc[i].getName());
                if (destType != null && destType.equals(origType) && !destType.equals(Class.class)) {
                    if (!Collection.class.isAssignableFrom(origType)) {
                        Object value = PropertyUtils.getProperty(orig, destDesc[i].getName());
                        PropertyUtils.setProperty(dest, destDesc[i].getName(), value);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("fail to copy properties",e);
        }
        return dest;
    }

    /**
     * 是否包括制定字符串
     *
     * @param ignores
     * @param name
     * @return
     */
    private static boolean contains(String[] ignores, String name) {
        boolean ignored = false;
        for (int j = 0; ignores != null && j < ignores.length; j++) {
            if (ignores[j].equals(name)) {
                ignored = true;
                break;
            }
        }
        return ignored;
    }

}
