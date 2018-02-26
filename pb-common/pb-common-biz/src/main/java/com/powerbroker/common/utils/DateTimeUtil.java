package com.powerbroker.common.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author wjwjtftf
 */
public class DateTimeUtil {

    private static final String DATETIME_T_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
    public static final DateTimeFormatter LOCAL_DATE_TIME;

    static {
        LOCAL_DATE_TIME = DateTimeFormatter.ofPattern(DATETIME_T_PATTERN);
    }

    public static LocalDateTime convert(Date date) {
        if (null != date) {
            return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        }
        return null;
    }

    public static Date convert(LocalDateTime date) {
        if (null != date) {
            return Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
        }
        return null;
    }
}
