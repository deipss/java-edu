package edu.java.deipss.common.date;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.util.Date;

public class DateTest {

    @Test
    public void dateUtilTest(){
        Date addOneDay = DateUtils.addDays(new Date(), -1);
        System.out.println(addOneDay);
    }
}
