package com.jiahui.nbarobot.utils;


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
        return cale.getTime();
    }


}
