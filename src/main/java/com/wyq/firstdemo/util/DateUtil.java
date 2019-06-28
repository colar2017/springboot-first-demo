package com.wyq.firstdemo.util;

import lombok.extern.slf4j.Slf4j;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateUtil
 * @Description 时间工具类
 * @Author weiyanqiang
 * @Date 2019/6/25 10:46
 * @Version 1.0
 */
@Slf4j
public class DateUtil {

    /**
     * 标准datetime格式: yyyy-MM-dd HH:mm:ss
     */
    public static final String STANDARD_DATE_TIME_FORM = "yyyy-MM-dd HH:mm:ss";

    /**
     * 标准date格式: yyyy-MM-dd
     */
    public static final String STANDARD_DATE_FORM = "yyyy-MM-dd";

    /**
     * 标准time格式: HH:mm:ss
     */
    public static final String STANDARD_TIME_FORM = "HH:mm:ss";

    /**
     * 字符串（yyyy-MM-dd）转date
     * @author weiyanqiang
     * @param strDate yyyy-MM-dd
     * @return java.util.Date
     * @date 2019/6/25 11:36
     */
    public static Date strToDate(String strDate) {
        SimpleDateFormat format = new SimpleDateFormat(STANDARD_DATE_FORM);
        ParsePosition pos = new ParsePosition(0);
        Date date = format.parse(strDate, pos);
        log.info(String.valueOf(pos.getIndex()));
        return date;
    }

    /**
     * date转字符串（yyyy-MM-dd）
     * @author weiyanqiang
     * @param date
     * @return java.lang.String
     * @date 2019/6/25 11:36
     */
    public static String dateToStr(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(STANDARD_DATE_FORM);
        String str = format.format(date);
        return str;
    }

    /**
     * 字符串（yyyy-MM-dd HH:mm:ss）转dateTime
     * @author weiyanqiang
     * @param strDate yyyy-MM-dd HH:mm:ss
     * @return java.util.Date
     * @date 2019/6/25 11:38
     */
    public static Date strToDateTime(String strDate) {
        SimpleDateFormat format = new SimpleDateFormat(STANDARD_DATE_TIME_FORM);
        ParsePosition pos = new ParsePosition(0);
        Date date = format.parse(strDate, pos);
        log.info(String.valueOf(pos.getIndex()));
        return date;
    }

    /**
     * dateTime转字符串（yyyy-MM-dd HH:mm:ss）
     * @author weiyanqiang
     * @param date
     * @return java.lang.String
     * @date 2019/6/25 11:38
     */
    public static String dateTimeToStr(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(STANDARD_DATE_TIME_FORM);
        String str = format.format(date);
        return str;
    }

}
