package com.ghprint.cms.utils;

import com.google.common.base.Objects;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * User: 董培基
 * Date: 13-7-30
 * Time: 下午6:26
 */
public class DateUtil {

    private static final DateTimeFormatter yyyyMM = DateTimeFormat.forPattern("yyyyMM");

    private static final DateTimeFormatter yyyyMMdd = DateTimeFormat.forPattern("yyyyMMdd");

    private static final DateTimeFormatter yyyyMMddHHmmss = DateTimeFormat.forPattern("yyyyMMddHHmmss");

    private static final DateTimeFormatter timeyyyyMMddHHmmss = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    public static Date getDate() {
        return new Date();
    }

    public static String formatDate(Date date, String pattern) {
        final DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);
        return formatter.print(new DateTime(date.getTime()));
    }

    public static String formatTimestamp(Timestamp timestamp) {
        return yyyyMMddHHmmss.print(new DateTime(timestamp.getTime()));
    }

    public static Date formatString(String date) {
        return yyyyMMdd.parseDateTime(date).toDate();
    }

    public static Date formatStringSS(String date) {
        return yyyyMMddHHmmss.parseDateTime(date).toDate();
    }

    public static String getDateYYYYMMddHHMMSS() {
        return yyyyMMddHHmmss.print(new DateTime());
    }

    public static String getDateYYYYMMdd() {
        return yyyyMMdd.print(new DateTime());
    }

    public static String getMonth() {
        return yyyyMM.print(new DateTime());
    }

    public static String getDateYYYYMMDD() {
        return timeyyyyMMddHHmmss.print(new DateTime()).substring(0, 10);
    }

    public static Timestamp getTime() {
        String s = timeyyyyMMddHHmmss.print(new DateTime());
        return Timestamp.valueOf(s);
    }

    public static Timestamp getFirstTime(Date date) {
        if (date == null)
            return null;
        else
            return new Timestamp(date.getYear(), date.getMonth(), date.getDate(), 0, 0, 0, 0);
    }

    public static Timestamp getLastTime(Date date) {
        if (date == null)
            return null;
        else
            return new Timestamp(date.getYear(), date.getMonth(), date.getDate(), 23, 59, 59, 0);
    }

    public static int compareTime(Date createTime) {
        if (Objects.equal(formatDate(createTime, "yyyyMMdd"), DateUtil.getDateYYYYMMdd())) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * @param endDate   结束日期
     * @param startDate 开始日期
     * @return 相差天数
     * @throws Exception
     */
    public static long differDays(String endDate, String startDate) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse(endDate);
        Date date2 = sdf.parse(startDate);
        GregorianCalendar cal1 = new GregorianCalendar();
        GregorianCalendar cal2 = new GregorianCalendar();
        cal1.setTime(date1);
        cal2.setTime(date2);
        long gap = (cal1.getTimeInMillis() - cal2.getTimeInMillis()) / (1000 * 3600 * 24);
        return gap;
    }

    /**
     * 字符串格式日期增加天数
     *
     * @param startDate 原日期
     * @param day       增加天数
     * @return 改变后的日期
     * @throws Exception
     */
    public static String addDays(String startDate, int day) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(startDate);
        Calendar fromCal = Calendar.getInstance();
        fromCal.setTime(date);
        fromCal.add(Calendar.DATE, day);
        return sdf.format(fromCal.getTime());
    }

    /**
     * 字符串减少天数
     *
     * @param day 减少的天数
     * @return 改变后的日期
     */
    public static String reduceDays(int day) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -day);
        return new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
    }

    /**
     * 字符串减少天数
     *
     * @param day 减少的天数
     * @return 改变后的日期
     */
    public static String reduceOneDays(int day) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -day);
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }

    /**
     * @param date
     *            需要格式化的日期對像
     * @param formatter
     *            格式化的字符串形式
     * @return 按照formatter指定的格式的日期字符串
     * ParseException無法解析的字符串格式時拋出
     *
     */
    public static String formatDateToStr(Date date, String formatter) {
        if (date == null)
            return "";
        try {
            return new java.text.SimpleDateFormat(formatter).format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
