package edu.java.deipss.common.date;

import cn.hutool.core.text.csv.CsvUtil;
import edu.java.deipss.common.util.TimeUtil;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * TimeUtil Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>04/24/2023</pre>
 */
public class TimeUtilTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: epochMilli(LocalDateTime localDateTime)
     */
    @Test
    public void testEpochMilli() throws Exception {
        long l = TimeUtil.epochMilli(LocalDateTime.now());
        System.out.println(l);
    }

    /**
     * Method: parseLocalDate(String pattern, String dateString)
     */
    @Test
    public void testParseLocalDate() throws Exception {
        Date date = TimeUtil.parseDate(TimeUtil.YYYYMMDD, "20210101");
        System.out.println(date);
    }

    /**
     * Method: parseLocalDateTime(String pattern, String dateString)
     */
    @Test
    public void testParseLocalDateTime() throws Exception {
        LocalTime localTime = TimeUtil.parseLocalTime(TimeUtil.YYYYMMDD, "20210101");
        System.out.println(localTime);
    }



    @Test
    public void test1() throws Exception {
        System.out.println(TimeUtil.format(TimeUtil.YYYYMMDD, LocalDate.now()));
        System.out.println(TimeUtil.format(TimeUtil.YYYY_MM_DD_HH_mm_SS, LocalDateTime.now()));
        System.out.println(TimeUtil.format(TimeUtil.HH_mm_SS, LocalTime.now()));
        System.out.println(TimeUtil.format(TimeUtil.HH_mm_SS, new Date()));
    }


} 
