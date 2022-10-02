package edu.java.deipss.base.util;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 *
 * @author hxl
 * @version 1.0
 * @since 2022/1/3 14:06
 */

public class TimeUtil {
    public static String YYYY_MM_DD_HH_mm_SS = "yyyy-MM-dd HH:mm:ss";
    public static String YYYY_MM_DD = "yyyy-MM-dd";
    public static String YYYYMMDD = "yyyyMMdd";
    public static String YYYYMM = "yyyyMM";
    public static String HH_mm_SS = "HH:mm:ss";
    public static String HHmmSS = "HHmmss";
    public static final DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendPattern("yyyy-MM-dd[['T'HH][:mm][:ss]]")
            .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
            .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
            .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
            .parseDefaulting(ChronoField.MILLI_OF_SECOND, 0)
            .toFormatter();

    public static long getEpochMilli(LocalDateTime localDateTime){
        return localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    public static LocalDate parseLocalDate(String pattern, String dateString) {
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDateTime parseLocalDateTime(String pattern, String dateString) {
        return LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalTime parseLocalTime(String pattern, String dateString) {
        return LocalTime.parse(dateString, DateTimeFormatter.ofPattern(pattern));
    }

    public static Date parseDate(String pattern, String dateString) {
        LocalDateTime localDateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(pattern));
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }


    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static String getFormatDate(String pattern, Date date) {
        LocalDateTime localDateTime = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return dateTimeFormatter.format(localDateTime);
    }

    public static String getFormatToday() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(YYYYMMDD);
        return dateTimeFormatter.format(LocalDateTime.now());
    }

    public static String getFormatLocalDate(String pattern, LocalDate date) {
        return DateTimeFormatter.ofPattern(pattern).format(date);
    }

    public static String getFormatLocalDateTime(String pattern, LocalDateTime date) {
        return DateTimeFormatter.ofPattern(pattern).format(date);
    }

    public static String getFormatLocalTime(String pattern, LocalTime date) {
        return DateTimeFormatter.ofPattern(pattern).format(date);
    }

    public static String getFormatTimeToday() {
        return DateTimeFormatter.ofPattern(YYYYMMDD).format(LocalTime.now());
    }

}
