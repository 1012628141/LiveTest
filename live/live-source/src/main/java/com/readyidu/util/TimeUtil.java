package com.readyidu.util;

import com.readyidu.playbill.model.DayTime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 123 on 2017/9/25.
 */
public class TimeUtil
{
    public static boolean isAfterNowTime(String showTime){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:MM");
        String nowTime = formatter.format(date);
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
}
