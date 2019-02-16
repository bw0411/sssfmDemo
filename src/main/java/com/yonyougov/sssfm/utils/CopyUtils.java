package com.yonyougov.sssfm.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zhangshc
 * @Date: 2019/1/10 14:20
 * @Version 1.0
 */
public class CopyUtils {

    public static String[] getNullPropertyNames (Object source,Object target) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        final BeanWrapper tar = new BeanWrapperImpl(target);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            Object tarValue = tar.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
            if (srcValue != null && !"".equals(srcValue)){
                if(tarValue.equals(srcValue))emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public static void copyProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src,target));
    }
}
