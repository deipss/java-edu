package edu.java.deipss.base.util;

import com.frxs.repeater.receiver.common.exception.RepeaterException;
import org.apache.logging.log4j.util.Strings;

import java.util.Collection;
import java.util.Objects;

/**
 * 异常检查类
 */
public class ThrowUtil {

    public static void throwIfNull(Object o, RepeaterException e) throws RepeaterException {
        if (Objects.isNull(o)) {
            throw e;
        }
    }

    public static void throwIfEmptyString(String s, RepeaterException e) throws RepeaterException {
        throwIfNull(s, e);
        if (Strings.isEmpty(s)) {
            throw e;
        }
    }

    public static void throwE(String s) throws RepeaterException {
        throw new RepeaterException(s);
    }

    public static void throwIfTrue(boolean b,String s) throws RepeaterException {
        if(b) {
            throw new RepeaterException(s);
        }
    }

    public static void throwIfEmptyCollection(Collection list, RepeaterException e) throws RepeaterException {
        throwIfNull(list, e);
        if (list.isEmpty()) {
            throw e;
        }
    }
}
