package edu.java.deipss.base.util;

import org.apache.logging.log4j.util.Strings;

import java.util.Collection;
import java.util.Objects;

/**
 * 异常检查类
 */
public class ThrowUtil {

    public static void throwIfNull(Object o, Exception e) throws Exception {
        if (Objects.isNull(o)) {
            throw e;
        }
    }

    public static void throwIfEmptyString(String s, Exception e) throws Exception {
        throwIfNull(s, e);
        if (Strings.isEmpty(s)) {
            throw e;
        }
    }

    public static void throwE(String s) throws Exception {
        throw new Exception(s);
    }

    public static void throwIfTrue(boolean b,String s) throws Exception {
        if(b) {
            throw new Exception(s);
        }
    }

    public static void throwIfEmptyCollection(Collection list, Exception e) throws Exception {
        throwIfNull(list, e);
        if (list.isEmpty()) {
            throw e;
        }
    }
}
