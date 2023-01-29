package util;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * guava common lang date util 功能测试类
 */
public class DateUtilTest {
    /**
     * 日期的加减，截断
     */
    @Test
    public void test(){
        System.out.println(DateUtils.truncate(new Date(), Calendar.DATE));
        System.out.println(DateUtils.addDays(new Date(),1));
        System.out.println(DateUtils.addDays(new Date(),-1));

    }
}
