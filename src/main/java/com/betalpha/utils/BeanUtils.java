package com.betalpha.utils;

import com.betalpha.exception.CsvException;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author xiehai1
 * @date 2017/11/16 13:09
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public final class BeanUtils {
    private BeanUtils() {

    }

    /**
     * set object filed value
     * @param object object instance
     * @param field  field instance
     * @param value  value
     * @throws IllegalAccessException
     */
    public static void setFieldValue(Object object, Field field, String value) throws IllegalAccessException {
        Class clazz = field.getType();
        if (clazz == String.class) {
            field.set(object, value);
        } else if (clazz == int.class || clazz == Integer.class) {
            field.set(object, Integer.valueOf(value));
        } else if (clazz == long.class || clazz == Long.class) {
            field.set(object, Long.valueOf(value));
        } else if (clazz == double.class || clazz == Double.class) {
            field.set(object, Double.valueOf(value));
        } else if (clazz == float.class || clazz == Float.class) {
            field.set(object, Float.valueOf(value));
        } else if (clazz == BigDecimal.class) {
            field.set(object, new BigDecimal(value));
        } else if (clazz == BigInteger.class) {
            field.set(object, new BigInteger(value));
        } else {
            throw new CsvException("not support type:" + clazz.getName());
        }
    }
}
