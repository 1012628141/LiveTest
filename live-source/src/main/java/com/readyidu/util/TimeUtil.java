package com.readyidu.util;

import com.readyidu.playbill.model.DayTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by 123 on 2017/9/25.
 */
public class TimeUtil
{
    private static Date currentTime = null;
    private static SimpleDateFormat SDF;
    public static boolean isAfterNowTime(String showTime){
        if (NullUtil.isNullObject(currentTime))
        {
            currentTime = new Date();
        }
        SimpleDateFormat formatter = new SimpleDateFormat("HH:MM");
        String nowTime = formatter.format(currentTime);
        DayTime currentTime = new DayTime(nowTime);
        DayTime compareTime = new DayTime(showTime);
        if (currentTime.getHour() == compareTime.getHour())
        {
            if (currentTime.getMin() < compareTime.getMin())
            {
                return true;
            }
        }else if (currentTime.getHour() < compareTime.getHour())
        {
            return true;
        }
        return false;
    }
    public static long getCurrentTime(){
        if (NullUtil.isNullObject(currentTime))
        {
            currentTime = new Date();
        }
        return currentTime.getTime();
    }
    public static long getTodayLong(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_YEAR,0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime().getTime();
    }
    public static String getTargetDayTime(int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_YEAR,days);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime().getTime());
    }
    public static String getTodayTime(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_YEAR,0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime().getTime());
    }
    public static String getTomorrowTime(long time){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(time));
        cal.add(Calendar.DAY_OF_YEAR,1) ;
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime().getTime());
    }
    public static long getStamp(String time){
        if (NullUtil.isNullObject(SDF)){
            SDF = new SimpleDateFormat("HH:mm");
            SDF.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        }
        try {
            return SDF.parse(time).getTime()+getTodayLong();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
