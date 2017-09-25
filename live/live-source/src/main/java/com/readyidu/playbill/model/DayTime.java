package com.readyidu.playbill.model;

/**
 * Created by 123 on 2017/9/25.
 */
public class DayTime {
    private int hour;
    private int min;

    public DayTime(String time){
        String[] vars = time.split(":");
        this.hour = Integer.valueOf(vars[0]);
        this.min = Integer.valueOf(vars[1]);
    }
    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
