package com.abhi.mvp.utils;

import java.util.List;

/**
 * check objects
 *
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12 /16/17.
 */
public class ObjectUtil {
    /**
     * Is empty boolean.
     *
     * @param string the string
     * @return the boolean
     */
    public static boolean isEmpty(String string) {
        return string == null || string.length() == 0;
    }

    /**
     * Is null boolean.
     *
     * @param obj the obj
     * @return the boolean
     */
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    /**
     * Is empty list boolean.
     *
     * @param list the list
     * @return the boolean
     */
    public static boolean isEmptyList(List list) {
        return list == null || list.isEmpty();
    }
}
