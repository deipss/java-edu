package edu.java.deipss.common.date;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

/**
 * 日期测试
 */
public class DateTest {

    /**
     * common-lang 的日期测试
     */
    @Test
    public void dateUtilTest(){
        // commons-lang3包
        Date addOneDay = DateUtils.addDays(new Date(), -1);
        System.out.println(addOneDay);
        // 获取当月的天数
        System.out.println(LocalDate.now().getDayOfMonth());
        // 获取本周的天数
        System.out.println(LocalDate.now().getDayOfWeek());
        // 获取本年的天数
        System.out.println(LocalDate.now().getDayOfYear());
    }
}
