package com.zhangbin.jpa.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * @author liu 2018年6月13日
 */
public class DateUtil {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat longDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 将日期字符串转成短日期的date yyyy-MM-dd
     */
    public static synchronized Date formatDate(String s) {
        Date d = null;
        try {
            d = dateFormat.parse(s);
        } catch (Exception localException) {
        }
        return d;
    }

    /**
     * 获取长日期 yyyy-MM-dd HH:mm:ss
     */
    public static synchronized Date formatLongDate(String s) {
        Date d = null;
        try {
            d = longDateFormat.parse(s);
        } catch (Exception localException) {
        }
        return d;
    }
    public static synchronized String formatLongDate(Object v) {
        if ((v == null) || (("").equals(v))) {
            return "";
        }
        return longDateFormat.format(v);
    }

    /**
     * 将日期字符串按照日期格式进行date的转换
     * 
     * @param s 日期的字符串
     * @param format 日期格式
     */
    public static synchronized Date formatDate(String s, String format) {
        Date d = null;
        try {
            SimpleDateFormat dFormat = new SimpleDateFormat(format);
            d = dFormat.parse(s);
        } catch (Exception dFormat) {
        }
        return d;
    }

    /**
     * 将时间按照需要格式化的格式级进行字符串的格式化
     * 
     * @param format 需要格式还的格式
     * @param v 时间对象
     */
    public static synchronized String formatTime(String format, Date v) {
        if (v == null) {
            return null;
        }
        if (("").equals(v)) {
            return "";
        }
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(v);
    }
    /**
     * 取得当前时间
     */
    public static Date getCurrentDate() {
        return new Date();
    }

    /**
     * 日期增加或减少天数
     */
    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    /**
     * 月份增加或减少
     */
    public static Date addMonth(Date date, int month) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, month);
        return cal.getTime();
    }
    /**
     * 将时间进行格式化 yyyy-MM-dd
     */
    public static synchronized String formatShortDate(Date v) {
        if (v == null) {
            return null;
        }
        return dateFormat.format(v);
    }

    /**
     * 获取昨天的时间
     * */
    public static synchronized Date getYesDate() {
        return DateUtil.addDays(DateUtil.getCurrentDate(), -1);
    }

    /**
     * 分钟的增加或减少
     */
    public static Date addMin(Date date, int min) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, min);
        return cal.getTime();
    }

    /**
     * 一天的开始
     * @param date
     * @return
     */
    public static Date beginOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 一天的结束
     * @param date
     * @return
     */
    public static Date endOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 格式化时间，返回字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String parseDate(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }
}
