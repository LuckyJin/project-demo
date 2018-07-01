package com.raycloud.service.common.util;

import java.util.Date;

/**
 * Created by baomingfeng at 2017-09-12 14:56:55
 */
public final class CompareUtils {

    /**
     * <pre>
     * base == null && comp == null --> false
     * base == null && comp != null --> false
     * base != null && comp != null --> base.equals(comp)
     * </pre>
     */
    public static boolean nullOrEquals(Object base, Object comp) {
        if (base == null) {
            return comp != null;
        }

        if (comp == null) {
            return false;
        }

        return base.equals(comp);
    }

    /**
     * <pre>
     * base == null && comp == null --> false
     * base == null && comp != null --> false
     * base != null && comp != null --> base.equals(comp)
     * </pre>
     */
    public static boolean nullOrEquals(Date base, Date comp) {
        if (base == null) {
            return comp != null;
        }

        if (comp == null) {
            return false;
        }

        return base.getTime() == comp.getTime();
    }

    public static boolean nullOrEquals(String base, String comp){
        if (base == null) {
            return comp != null;
        }

        if (comp == null) {
            return false;
        }

        return base.equals(comp);
    }

    private CompareUtils() {
    }


}
