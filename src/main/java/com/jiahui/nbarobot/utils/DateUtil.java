package com.jiahui.nbarobot.utils;


import lombok.Data;

import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * @author dongjiahui
 */
public class DateUtil {


    /**
     * 返回当前周的第一天
     * @param date 当前时间
     * @return 结果
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(date);
            cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            //将小时至0
            cal.set(Calendar.HOUR_OF_DAY, 0);
            //将分钟至0
            cal.set(Calendar.MINUTE, 0);
            //将秒至0
            cal.set(Calendar.SECOND,0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cal.getTime();
    }

    /**
     * 返回当前月的第一天
     * @return 结果
     */
    public static Date getCurrentMonthFirstDay() {
        Calendar cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        //将小时至0
        cale.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        cale.set(Calendar.MINUTE, 0);
        //将秒至0
        cale.set(Calendar.SECOND,0);
        return cale.getTime();
    }

    public static DateRange getTimeInterval(Date date) {

        DateRange dateRange = new DateRange();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        dateRange.setBegin(cal.getTime());
        cal.add(Calendar.DATE, 6);
        dateRange.setEnd(cal.getTime());

        return dateRange;
    }


    /**
     * 对日期的【周】进行加/减
     *
     * @param date 日期
     * @param weeks 周数，负数为减
     * @return 加/减几周后的日期
     */
    public static Date addDateWeeks(Date date, int weeks) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.WEEK_OF_YEAR,- weeks);
        return cal.getTime();
    }

    @Data
    public static class DateRange{

        private Date begin;

        private Date end;

    }


}
