package edu.java.deipss.common.util;


import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Objects;

/**
 * 异常检查类
 */
public class ThrowUtil {

    public static void ifNull(Object o, Exception e) throws Exception {
        if (Objects.isNull(o)) {
            throw e;
        }
    }

    public static void ifEmptyString(String s, Exception e) throws Exception {
        ifNull(s, e);
        if (StringUtils.isEmpty(s)) {
            throw e;
        }
    }

    public static void throwE(String s) throws Exception {
        throw new Exception(s);
    }

    public static void ifTrue(boolean b, String s) throws Exception {
        if(b) {
            throw new Exception(s);
        }
    }

    public static void ifEmptyCollection(Collection list, Exception e) throws Exception {
        ifNull(list, e);
        if (list.isEmpty()) {
            throw e;
        }
    }
}
