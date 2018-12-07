package com.cn.service.common.util;

/**
 * Created by baomingfeng at 2017-12-03 19:29:35
 */
public final class ConvertUtils {

    /**
     * obj == null --> return null
     */
    public static String stringValueOf(Object obj) {
        return (obj == null) ? null : obj.toString();
    }

    /**
     * obj == null --> return null
     */
    public static <E extends Enum> String stringValueOf(E en) {
        return (en == null) ? null : en.name();
    }

    /**
     * 返回指定名称的枚举类型, 不合法的枚举名返回null
     */
    public static <T extends Enum<T>> T enumValue(Class<T> enumType, String name) {
        try {
            return Enum.valueOf(enumType, name);
        } catch (RuntimeException ignored) {
        }//NullPointerException,IllegalArgumentException
        return null;
    }

    /**
     * Boolean --> boolean
     */
    public static boolean booleanValue(Boolean bool) {
        return bool != null && bool;
    }

    private ConvertUtils() {
    }
}
